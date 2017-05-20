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
 * Created by Alex Feng Li on 5/19/2017.
 */

class AccountListAdapter extends BaseAdapter{
    public ArrayList<HashMap<String,String>> list;
    Activity activity;
    TextView txtFirst,txtSecond,txtThird,txtFourth;
    public AccountListAdapter(Activity activity,ArrayList<HashMap<String, String>> list){
        super();
        this.activity=activity;
        this.list=list;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub



        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){

            convertView=inflater.inflate(R.layout.view_account_entry, null);

            txtFirst =(TextView) convertView.findViewById(R.id.AccountID);
            txtSecond =(TextView) convertView.findViewById(R.id.AccountType);
            txtThird =(TextView) convertView.findViewById(R.id.AccountCoin);
         //   txtFourth = (TextView) convertView.findViewById(R.id.AccountFund);


        }

        HashMap<String, String> map=list.get(position);
        txtFirst.setText(map.get("first"));
        txtSecond.setText(map.get("second"));
        txtThird.setText(map.get("third"));
     //   txtFourth.setText(map.get("Fourth"));


        return convertView;
    }
}
