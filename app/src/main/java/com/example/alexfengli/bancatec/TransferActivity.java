package com.example.alexfengli.bancatec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TransferActivity extends AppCompatActivity {
    EditText id,amount,description;
    Button confirm,cancel;
    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        id = (EditText)findViewById(R.id.accountID);
        amount = (EditText)findViewById(R.id.transferAmount);
        description = (EditText)findViewById(R.id.transferDesc);
        txt1 = (TextView)findViewById(R.id.textView2);
        txt2 = (TextView)findViewById(R.id.textView3);
        txt3 = (TextView)findViewById(R.id.textView4);
        confirm = (Button)findViewById(R.id.tBconfirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transfer();
            }
        });
        cancel = (Button)findViewById(R.id.tBcancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void transfer()
    {
        //Aqui recolecta info y haga request
    }
}
