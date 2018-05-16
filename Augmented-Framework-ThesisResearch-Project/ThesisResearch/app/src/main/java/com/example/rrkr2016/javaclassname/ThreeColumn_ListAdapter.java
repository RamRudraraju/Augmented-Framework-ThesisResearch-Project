package com.example.rrkr2016.javaclassname;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RRKR2016 on 10/17/2017.
 */

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourseId;

    // ListAdapter

    public ThreeColumn_ListAdapter(Context context, int textViewResourseId, ArrayList<User> users){
        super(context, textViewResourseId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourseId = textViewResourseId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        convertView = mInflater.inflate(mViewResourseId, null);

        User user = users.get(position);
        if(user != null){                       // SM,SD,SY,EM,ED,EY,ST,ET
            TextView ID = (TextView) convertView.findViewById(R.id.ID);
            TextView RN = (TextView) convertView.findViewById(R.id.RN);
            TextView A  = (TextView) convertView.findViewById(R.id.A);
            TextView SM = (TextView) convertView.findViewById(R.id.SM);
            TextView SD = (TextView) convertView.findViewById(R.id.SD);
            TextView SY = (TextView) convertView.findViewById(R.id.SY);
            TextView EM = (TextView) convertView.findViewById(R.id.EM);
            TextView ED = (TextView) convertView.findViewById(R.id.ED);
            TextView EY = (TextView) convertView.findViewById(R.id.EY);
            TextView ST = (TextView) convertView.findViewById(R.id.ST);
            TextView ET = (TextView) convertView.findViewById(R.id.ET);

            if(ID != null){
                ID.setText(user.getID());
            }
            if (RN != null){
                RN.setText(user.getRN());
            }
            if (A != null){
                A.setText(user.getA());
            }
            if(SM != null){
                SM.setText(user.getSM());
            }
            if (SD != null){
                SD.setText(user.getSD());
            }
            if(SY != null){
                SY.setText(user.getSY());
            }
            if (EM != null){
                EM.setText(user.getEM());
            }
            if(ED != null){
                ED.setText(user.getED());
            }
            if (EY != null){
                EY.setText(user.getEY());
            }
            if(ST != null){
                ST.setText(user.getST());
            }
            if(ET != null){
                ET.setText(user.getET());
            }

        }
        return convertView;

    }
}