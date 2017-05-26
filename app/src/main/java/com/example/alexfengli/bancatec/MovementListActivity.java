package com.example.alexfengli.bancatec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MovementListActivity extends AppCompatActivity {
    ListView contents;
    ArrayList<MovementHistoryDto> history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement_list);
        history = new ArrayList<MovementHistoryDto>();
        //Requeste la info de history
    }
/*
    private void Refresh()
    {
        contents = (ListView)findViewById(R.id.MovementList);
        ArrayList<HashMap<String,String>> records = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i<records.size();i++)
        {
            HashMap<String,String> temp = new HashMap<String, String>();
            temp.put("First",String.valueOf(history.get(i).operacion);
            int operacion = history.get(i).operacion;
            switch (operacion){
                case 0:
                    temp.put("Second","deposito");
                    break;
                case 1:
                    temp.put("Second","retiro");
                    break;


            }
            /*
            temp.put("Second",history.get(i).getOperation());
            temp.put("Third",String.valueOf(history.get(i).getAmount()));
            temp.put("Fourth",history.get(i).getPlace());
            temp.put("Fifth",history.get(i).getDescription());
            temp.put("Six",history.get(i).getDate().toString());
            records.add(temp);

        }
        MovementListAdapter adapter = new MovementListAdapter(this,records);
        contents.setAdapter(adapter);
    }
    */
}
