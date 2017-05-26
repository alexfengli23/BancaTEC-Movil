package com.example.alexfengli.bancatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DebitCardListActivity extends AppCompatActivity {
    RestService service;
    Spinner spinner;
    String account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card_list);
        service = new RestService();
        final Intent intent = getIntent();
        account = intent.getStringExtra("numero");
        service.getService().getTarjetasDeCuenta(account, new Callback<List<DebitDTO>>() {
            @Override
            public void success(List<DebitDTO> debitDTOs, Response response) {
                spinner = (Spinner) findViewById(R.id.spinner2);
                ArrayList<String> cards = new ArrayList<String>();
                for(int i = 0; i< debitDTOs.size();i++)
                {
                    cards.add(debitDTOs.get(i).NumeroTarjeta);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(DebitCardListActivity.this,android.R.layout.simple_spinner_item,cards);
                spinner.setAdapter(adapter);

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(DebitCardListActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
