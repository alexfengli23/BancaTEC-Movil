package com.example.alexfengli.bancatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {
    ImageButton login;
    EditText userName,password;

    RestService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.pwd);
        login = (ImageButton)findViewById(R.id.bLogin);
        service = new RestService();

        //Aqui debe ir el service de post login al api
        service.getService().login(userName.getText().toString(), password.getText().toString(), new Callback<ClientDTO>() {
            @Override
            public void success(ClientDTO clientDTO, Response response) {
                Intent myIntent = new Intent(LoginActivity.this,MainActivity.class);
                myIntent.putExtra("Cedula",clientDTO.cedula);
                LoginActivity.this.startActivity(myIntent);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(LoginActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
        //Aqui debe solicitar al api el nombre de usuario

    }
}
