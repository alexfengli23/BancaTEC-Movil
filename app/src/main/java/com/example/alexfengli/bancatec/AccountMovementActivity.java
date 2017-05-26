package com.example.alexfengli.bancatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AccountMovementActivity extends AppCompatActivity {
    String accountId;
    Button bCard,bCancel;
    RestService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_movement);
        service = new RestService();
        final Intent intent = getIntent();
        accountId = intent.getStringExtra("numero");
        bCancel = (Button)findViewById(R.id.bCancelMovementA);
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bCard = (Button)findViewById(R.id.bDebitCards);
        bCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),DebitCardListActivity.class);
                myIntent.putExtra("numero",accountId);
                startActivity(myIntent);
            }
        });
        service.getService().getAccountMovement(accountId, new Callback<List<MovimientoCuentaDTO>>() {
            @Override
            public void success(List<MovimientoCuentaDTO> movimientoCuentaDTOs, Response response) {
                ListView lv = (ListView)findViewById(R.id.AccountMoveListView);
                final ArrayList<HashMap<String,String>> movements = new ArrayList<HashMap<String, String>>();
                for(int i = 0;i<movimientoCuentaDTOs.size();i++)
                {
                    HashMap<String,String> temp=new HashMap<String, String>();
                    temp.put("first",movimientoCuentaDTOs.get(i).fecha.toString());
                    temp.put("second",movimientoCuentaDTOs.get(i).operacion);

                    temp.put("third",movimientoCuentaDTOs.get(i).descripcion);
                    temp.put("fourth",String.valueOf(movimientoCuentaDTOs.get(i).monto));
                    movements.add(temp);
                }
                AccountMovementAdapter adapter = new AccountMovementAdapter(AccountMovementActivity.this,movements);
                lv.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(AccountMovementActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
