package com.example.rrkr2016.javaclassname;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewListContents extends AppCompatActivity {

    DbHelperPj Db;
    ListView lv;
    User user;
    private static final String TAG = "ViewListContents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_contents);

        lv = (ListView) findViewById(R.id.listContents);
        Db = new DbHelperPj(this);
        displayingListOfNames();

    }

    private void displayingListOfNames(){

        Cursor data = Db.getData();// Contains whole Data in the Table.              // Have a look Over It
        ArrayList<User> userList = new ArrayList<>();     // Each Block in the Array contains, User Number of Peaces(4).
        // "ArrayList" Take User type parameters
        int numRow = data.getCount();  // Count the number of Rows.

        if (numRow == 0){
            Toast.makeText(this, "There is nothing in Database!!!", Toast.LENGTH_SHORT).show();
        }else {
            while (data.moveToNext()){
                user = new User(data.getString(0), data.getString(1), data.getString(2), data.getString(3),
                        data.getString(4),  data.getString(5), data.getString(6), data.getString(7), data.getString(8),  data.getString(9), data.getString(10));
                userList.add(user);
            }

            ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.list_adapter_view, userList);
            lv.setAdapter(adapter);

        }

    }

}
