package com.example.alexfengli.bancatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AccountListViewAcitivity extends AppCompatActivity {
    String user;
    RestService service;
    Button close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list_view_acitivity);
        final Intent intent = getIntent();
        user = intent.getStringExtra("Cedula");
        close = (Button)findViewById(R.id.bCancelAccountsView);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        service = new RestService();
        //0refresh();

        service.getService().getAccountsClient(user, new Callback<List<AccountDTO>>() {
            @Override
            public void success(List<AccountDTO> accountDTOs, Response response) {
                ListView accountList = (ListView)findViewById(R.id.listView);
                final ArrayList<HashMap<String,String>> accounts = new ArrayList<HashMap<String, String>>();
                for(int i = 0; i< accountDTOs.size();i++)
                {

                    HashMap<String,String> temp=new HashMap<String, String>();
                    temp.put("first",accountDTOs.get(i).getNumero());
                    if(accountDTOs.get(i).isTipoahorro())
                    {
                        temp.put("second","Ahorro");
                    }
                    else{
                        temp.put("second","Corriente");
                    }
                    if(accountDTOs.get(i).isEndolares())
                    {
                        temp.put("third","Dolar");
                    }
                    else
                    {
                        temp.put("third","colon");
                    }
                    // temp.put("fourth",String.valueOf(accountDTOs.get(i).getSaldo()));
                    accounts.add(temp);
                }
                accountList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView result = (TextView)view.findViewById(R.id.AccountID);
                        String accountNumber = result.getText().toString();
                        //new intent
                        Intent myIntent = new Intent(getApplicationContext(),DebitCardListActivity.class);
                        myIntent.putExtra("numero",accountNumber);
                        startActivity(myIntent);
                    }
                });
                AccountListAdapter adapter= new AccountListAdapter(AccountListViewAcitivity.this,accounts);
                accountList.setAdapter(adapter);


            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(AccountListViewAcitivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void refresh()
    {


    }
}
