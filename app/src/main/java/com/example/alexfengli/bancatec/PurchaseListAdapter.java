package com.example.alexfengli.bancatec;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alex Feng Li on 5/7/2017.
 */

public class PurchaseListAdapter extends BaseAdapter {
    public ArrayList<HashMap<String,String>> list;
    Activity activity;
    TextView txtFirst,txtSecond,txtThird,txtFourth,txtFifth;
    public PurchaseListAdapter(Activity activity,ArrayList<HashMap<String,String>> list)
    {
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=activity.getLayoutInflater();

        if(inflater == null)
        {
            convertView = inflater.inflate(R.layout.purchase_history_listview,null);
            txtFirst = (TextView) convertView.findViewById(R.id.pHID);
            txtSecond = (TextView) convertView.findViewById(R.id.pHDate);
            txtThird = (TextView) convertView.findViewById(R.id.pHAmount);
            txtFourth = (TextView) convertView.findViewById(R.id.pHPlace);
            txtFifth = (TextView) convertView.findViewById(R.id.pHDesc);

        }
        HashMap<String,String> map = list.get(position);
        txtFirst.setText(map.get("First"));
        txtSecond.setText(map.get("Second"));
        txtThird.setText(map.get("Third"));
        txtFourth.setText(map.get("Fourth"));
        txtFifth.setText(map.get("Fifth"));


        return convertView;
    }
}
