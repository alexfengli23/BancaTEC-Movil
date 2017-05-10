package com.example.alexfengli.bancatec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

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

        //Aqui debe ir el service de post login al api
        LoginDto loginData = new LoginDto(userName.getText().toString(),password.getText().toString());
        //Aqui debe solicitar al api el nombre de usuario
        Intent myIntent = new Intent(LoginActivity.this,MainActivity.class);
        LoginActivity.this.startActivity(myIntent);
    }
}
