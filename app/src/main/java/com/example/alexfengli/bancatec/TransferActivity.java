package com.example.alexfengli.bancatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TransferActivity extends AppCompatActivity {
    EditText id,amount,description;
    Button confirm,cancel;
    TextView txt1,txt2,txt3;
    RestService service;
    Spinner list;
    String cedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        service = new RestService();
        final Intent intent = getIntent();
        cedula = intent.getStringExtra("Cedula");
        id = (EditText)findViewById(R.id.transferAccount);
        amount = (EditText)findViewById(R.id.transferAmount);
        description = (EditText)findViewById(R.id.transferDesc);
        txt1 = (TextView)findViewById(R.id.textView2);
        txt2 = (TextView)findViewById(R.id.textView3);
        txt3 = (TextView)findViewById(R.id.textView4);
        confirm = (Button)findViewById(R.id.tBconfirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    TransferDTO transfer = new TransferDTO(((String)list.getSelectedItem()),id.getText().toString(),
                            description.getText().toString(),"movil",Integer.valueOf(amount.getText().toString()));
                    service.getService().transfer(transfer, new Callback<TransferDTO>() {
                        @Override
                        public void success(TransferDTO transferDTO, Response response) {
                            Toast.makeText(TransferActivity.this, "Ok".toString(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(TransferActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });
              //  }
               //Toast.makeText(TransferActivity.this, "Error koko", Toast.LENGTH_LONG).show();
            }
        });
        cancel = (Button)findViewById(R.id.tBcancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        service.getService().getAccountsClient(cedula, new Callback<List<AccountDTO>>() {
            @Override
            public void success(List<AccountDTO> accountDTOs, Response response) {
                list = (Spinner)findViewById(R.id.spinner);
                ArrayList<String> Accounts = new ArrayList<String>();
                for(int i = 0; i<accountDTOs.size();i++)
                {
                    AccountDTO tmp = accountDTOs.get(i);
                    Accounts.add(tmp.numero);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(TransferActivity.this,android.R.layout.simple_spinner_item,Accounts);
                list.setAdapter(adapter);
                list.setSelection(0);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(TransferActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void transfer()
    {

        //Aqui recolecta info y haga request
    }
}
