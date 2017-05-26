package com.example.alexfengli.bancatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PagoOrdinarioActivity extends AppCompatActivity {
    RestService service;
    Spinner prestamos,cuentas;
    EditText montoSuperior;
    TextView pendiente,saldo;
    Button confirmar,cancelar;
    String cedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_ordinario);
        service = new RestService();
        final Intent intent = getIntent();
        cedula = intent.getStringExtra("cedula");
        confirmar = (Button)findViewById(R.id.bprestamoOconfirm);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   final  int idPago = Integer.valueOf((String)prestamos.getSelectedItem());

                    String numeroCuenta = (String) cuentas.getSelectedItem();
                service.getService().getCuenta(numeroCuenta, new Callback<AccountDTO>() {
                    @Override
                    public void success(final AccountDTO accountDTO, Response response) {
                        service.getService().getCalendarioPrestamo(idPago, new Callback<List<CalendarioDTO>>() {
                            @Override
                            public void success(List<CalendarioDTO> calendarioDTOs, Response response) {
                                int monto = Integer.valueOf(montoSuperior.getText().toString());
                                if(monto>=calendarioDTOs.get(0).montoPago && accountDTO.saldo>=monto)
                                {
                                    service.getService().pagoPrestamo(idPago, monto, new Callback<List<String>>() {
                                        @Override
                                        public void success(List<String> strings, Response response) {
                                            Toast.makeText(PagoOrdinarioActivity.this,"ok".toString(), Toast.LENGTH_LONG).show();
                                            finish();
                                        }

                                        @Override
                                        public void failure(RetrofitError error) {
                                            Toast.makeText(PagoOrdinarioActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

                                        }
                                    });
                                    Toast.makeText(PagoOrdinarioActivity.this,"Monto inferior o fondo insuficiente", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(PagoOrdinarioActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(PagoOrdinarioActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        cancelar = (Button)findViewById(R.id.bPrestamoOcancel);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        montoSuperior = (EditText)findViewById(R.id.editMonto);
        pendiente = (TextView)findViewById(R.id.txtPagoEpendiente);
        saldo = (TextView)findViewById(R.id.txtpagoOsaldo);

        service.getService().getPrestamoActivo(cedula, new Callback<List<String>>() {
            @Override
            public void success(List<String> strings, Response response) {
                prestamos = (Spinner)findViewById(R.id.listaPrestamo);
                ArrayList<String> listaPrestamo = new ArrayList<String>();
                for(int i = 0; i<strings.size();i++)
                {
                    listaPrestamo.add(strings.get(i));
                }
                if(listaPrestamo.size()==0)
                {
                    confirmar.setClickable(false);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PagoOrdinarioActivity.this,android.R.layout.simple_spinner_item,listaPrestamo);
                prestamos.setAdapter(adapter);
                prestamos.setSelection(0);

                service.getService().getAccountsClient(cedula, new Callback<List<AccountDTO>>() {
                    @Override
                    public void success(List<AccountDTO> accountDTOs, Response response) {
                        cuentas = (Spinner)findViewById(R.id.listaCuentaPrestamo);
                        ArrayList<String> listaCuenta = new ArrayList<String>();
                        for(int i = 0; i< accountDTOs.size();i++)
                        {
                            listaCuenta.add(accountDTOs.get(i).numeroCuenta);
                        }
                        if(listaCuenta.size()==0)
                        {
                            confirmar.setClickable(false);
                        }
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(PagoOrdinarioActivity.this,android.R.layout.simple_spinner_item,listaCuenta);
                        cuentas.setAdapter(adapter2);
                        cuentas.setSelection(0);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(PagoOrdinarioActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(PagoOrdinarioActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
