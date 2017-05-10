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
 * Created by Alex Feng Li on 5/6/2017.
 */

public class MovementListAdapter extends BaseAdapter {
    public ArrayList<HashMap<String,String>> list;
    Activity activity;
    TextView txtFirst,txtSecond,txtThird,txtFourth,txtFifth,txtSix;
    public MovementListAdapter(Activity activity,ArrayList<HashMap<String,String>> list)
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
            convertView = inflater.inflate(R.layout.move_history_listview,null);
            txtFirst = (TextView) convertView.findViewById(R.id.mID);
            txtSecond = (TextView) convertView.findViewById(R.id.mOperation);
            txtThird = (TextView) convertView.findViewById(R.id.mAmount);
            txtFourth = (TextView) convertView.findViewById(R.id.mPlace);
            txtFifth = (TextView) convertView.findViewById(R.id.mDescription);
            txtSix = (TextView)convertView.findViewById(R.id.mDate);
        }
        HashMap<String,String> map = list.get(position);
        txtFirst.setText(map.get("First"));
        txtSecond.setText(map.get("Second"));
        txtThird.setText(map.get("Third"));
        txtFourth.setText(map.get("Fourth"));
        txtFifth.setText(map.get("Fifth"));
        txtSix.setText(map.get("Six"));

        return convertView;
    }
}
