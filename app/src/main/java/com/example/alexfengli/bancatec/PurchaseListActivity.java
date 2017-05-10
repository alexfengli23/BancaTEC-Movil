package com.example.alexfengli.bancatec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PurchaseListActivity extends AppCompatActivity {
    Button show,cancel;
    TextView txtSdate,txtFdate,txtHistory;
    EditText sDate,fDate;
    ListView contents;
    ArrayList<PurchaseRecordDto> history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_list);
        txtHistory = (TextView)findViewById(R.id.txtHC);
        txtSdate = (TextView)findViewById(R.id.txtSDate);
        txtFdate = (TextView)findViewById(R.id.txtFDate);
        sDate = (EditText)findViewById(R.id.eSdate);
        fDate = (EditText)findViewById(R.id.eFDate);
        show = (Button)findViewById(R.id.pBshow);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //request al api history;
                Refresh();
            }
        });
        cancel = (Button)findViewById(R.id.pBcancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void Refresh()
    {
        contents = (ListView)findViewById(R.id.pHistoryList);
        ArrayList<HashMap<String,String>> records = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i<records.size();i++)
        {
            HashMap<String,String> temp = new HashMap<String, String>();
            temp.put("First",String.valueOf(history.get(i).getID()));
            temp.put("Second",history.get(i).getDate().toString());
            temp.put("Third",String.valueOf(history.get(i).getAmount()));
            temp.put("Fourth",history.get(i).getPlace());
            temp.put("Fifth",history.get(i).getDesc());
            records.add(temp);
        }
        MovementListAdapter adapter = new MovementListAdapter(this,records);
        contents.setAdapter(adapter);
    }
}
