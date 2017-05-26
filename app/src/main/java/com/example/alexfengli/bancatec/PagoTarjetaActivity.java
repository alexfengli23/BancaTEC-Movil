package com.example.alexfengli.bancatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PagoTarjetaActivity extends AppCompatActivity {
    Spinner tarjetas,cuentas;
    Button confirmar,cancel;
    TextView txt1,txt2;
    RestService service;
    String cedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_tarjeta);
        service = new RestService();
        final Intent intent = getIntent();
        cedula = intent.getStringExtra("Cedula");
        confirmar = (Button)findViewById(R.id.bPagoConfirm);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay();
            }
        });
        cancel = (Button)findViewById(R.id.bPagoCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txt1 = (TextView)findViewById(R.id.txtPendiente);
        txt2 = (TextView)findViewById(R.id.txtsaldo);

        service.getService().getTarjetasPendientes(cedula, new Callback<List<CreditDTO>>() {
            @Override
            public void success(List<CreditDTO> creditDTOs, Response response) {
                tarjetas = (Spinner)findViewById(R.id.txtMontoPorPagar);
                ArrayList<String> cards = new ArrayList<String>();
                for(int i = 0; i<creditDTOs.size();i++)
                {
                    cards.add(creditDTOs.get(i).numero_tarjeta);
                }
                if(creditDTOs.size()>0) {
                    txt1.setText("Monto pendiente es: " + String.valueOf(creditDTOs.get(0).pendiente)+" colones");
                }
                else{
                    txt1.setText("No tiene monto pendiente");
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PagoTarjetaActivity.this,android.R.layout.simple_spinner_item,cards);
                tarjetas.setAdapter(adapter);
                tarjetas.setSelection(0);


                service.getService().getAccountsClient(cedula, new Callback<List<AccountDTO>>() {
                    @Override
                    public void success(List<AccountDTO> accountDTOs, Response response) {
                        cuentas = (Spinner)findViewById(R.id.PagoAccountList);
                        ArrayList<String> accounts = new ArrayList<String>();
                        for(int i = 0; i< accountDTOs.size();i++)
                        {
                            accounts.add(accountDTOs.get(i).numeroCuenta);
                        }
                        if(accountDTOs.size()>0){
                            if(accountDTOs.get(0).endolares==true)
                            {
                                txt2.setText("Saldo disponible es: "+String.valueOf(accountDTOs.get(0).saldo)+" dolares");
                            }
                            else{
                                txt2.setText("Saldo disponible es: "+String.valueOf(accountDTOs.get(0).saldo)+" colones");
                            }

                        }
                        else{
                            txt2.setText("Saldo disponible es : 0");
                        }

                        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(PagoTarjetaActivity.this,android.R.layout.simple_spinner_item,accounts);
                        cuentas.setAdapter(adapter2);
                        cuentas.setSelection(0);


                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(PagoTarjetaActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(PagoTarjetaActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
    private void pay()
    {
        service.getService().getCuenta((String) cuentas.getSelectedItem(), new Callback<AccountDTO>() {
            @Override
            public void success(final AccountDTO accountDTO, Response response) {
                if(accountDTO.endolares==true)
                {
                    txt2.setText("Saldo disponible es: "+String.valueOf(accountDTO.saldo)+" dolares");
                }
                else{
                    txt2.setText("Saldo disponible es: "+String.valueOf(accountDTO.saldo)+" colones");
                }

                service.getService().getTarjetaCredito((String) tarjetas.getSelectedItem(), new Callback<CreditDTO>() {
                    @Override
                    public void success(final CreditDTO creditDTO, Response response) {
                        txt1.setText("Monto pendiente es: "+String.valueOf(creditDTO.pendiente)+" colones");
                        if (accountDTO.endolares != true) {
                            if (accountDTO.saldo >= creditDTO.pendiente) {
                                AccountOperationDTO data = new AccountOperationDTO(accountDTO.numeroCuenta, "movil", "pago tarjeta", creditDTO.pendiente);
                                service.getService().operacionCuenta(data, false, new Callback<String>() {
                                    @Override
                                    public void success(String s, Response response) {
                                        service.getService().pagarTarjetaPendiente(creditDTO.numero_tarjeta, new Callback<String>() {
                                            @Override
                                            public void success(String s, Response response) {
                                                Toast.makeText(PagoTarjetaActivity.this, "Pago exitoso", Toast.LENGTH_LONG).show();
                                                finish();
                                            }

                                            @Override
                                            public void failure(RetrofitError error) {
                                                Toast.makeText(PagoTarjetaActivity.this, "Error de operacion", Toast.LENGTH_LONG).show();
                                            }
                                        });
                                    }

                                    @Override
                                    public void failure(RetrofitError error) {
                                        Toast.makeText(PagoTarjetaActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

                                    }
                                });
                            }
                            Toast.makeText(PagoTarjetaActivity.this, "Fondo no suficiente", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(PagoTarjetaActivity.this, "Solo puede cancelar con cuenta en colones", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(PagoTarjetaActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(PagoTarjetaActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
