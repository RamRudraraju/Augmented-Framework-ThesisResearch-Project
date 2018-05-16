package com.example.rrkr2016.javaclassname;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RRKR2016 on 10/18/2017.
 */

public class OneColumn_ListAdapter  extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users2;
    private int mViewResourseId;

    public OneColumn_ListAdapter(Context context, int textViewResourseId, ArrayList<User> users2){
        super(context, textViewResourseId, users2);
        this.users2 = users2;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourseId = textViewResourseId;
    }

    public View getView(int position, View convertView2, ViewGroup parent){
        convertView2 = mInflater.inflate(mViewResourseId, null);

        User user2 = users2.get(position);

        if(user2 != null){
            TextView RoomNumber = (TextView) convertView2.findViewById(R.id.rnoclid);
            if (RoomNumber != null){
                RoomNumber.setText(user2.getRN());
            }
        }
        return convertView2;
    }
}