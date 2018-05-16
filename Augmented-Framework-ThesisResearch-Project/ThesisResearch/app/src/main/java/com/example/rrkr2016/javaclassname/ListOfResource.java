package com.example.rrkr2016.javaclassname;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListOfResource extends AppCompatActivity {

    String Resource, DaysOrHours, UniqeID, Title;
    private static final String TAG = "ListOfResource";
   // private static final String TAG = "MainActivity";
   TextView setTitle;

    DbHelperPj Dbp;
    ListView listView2;
    User user2;
    ArrayList<User> ul;
    Cursor data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* setTitle = (TextView)findViewById(R.id.pname);
        setTitle.setText(Title); */

        Intent IncomingResource = getIntent();
        DaysOrHours = IncomingResource.getStringExtra("DaysOrHours:");
        UniqeID = IncomingResource.getStringExtra("UniqeID");
        Title = IncomingResource.getStringExtra("Title:");

        Log.d(TAG, "onCreate: "+ DaysOrHours);
        Log.d(TAG, "onCreate: "+ UniqeID);



        if(DaysOrHours.equals("H")){

            setContentView(R.layout.activity_list_of_resource);
            Log.d(TAG, "onCreate: Inside RR " + DaysOrHours + DaysOrHours);

            setTitle = (TextView)findViewById(R.id.pname);
            setTitle.setText(Title);

            Dbp = new DbHelperPj(this);
            // displayTheAvaiRooms();
            listView2 = (ListView) findViewById(R.id.lvp);

            Intent incomIntent = getIntent();    // compAddress
            String StartTime = incomIntent.getStringExtra("StartTime");
            String EndTime = incomIntent.getStringExtra("EndTime");
            String SM = incomIntent.getStringExtra("SM");
            String SD = incomIntent.getStringExtra("SD");
            String SY = incomIntent.getStringExtra("SY");
            String EM = incomIntent.getStringExtra("EM");
            String ED = incomIntent.getStringExtra("ED");
            String EY = incomIntent.getStringExtra("EY");


            data2 = Dbp.roomSearch(StartTime, EndTime, SM,SD,SY,EM,ED,EY, UniqeID);
            ul = new ArrayList<>();

            int numRow2 = data2.getCount();

            if (numRow2 == 0){
                Toast.makeText(this, "There is nothing in Database!!!", Toast.LENGTH_SHORT).show();
            }else {
                while (data2.moveToNext()) {          // Have a look over It
                    // user2 = new User(data2.getString(1));
                    user2 = new User(data2.getString(0));
                   // ul.add(data2.getString(0));
                    ul.add(user2);

                    Log.d(TAG, "onCreate: "+ ul);
                }

                Log.d(TAG, "onCreate: sUCCESSFULL UPTO THIS POINT");
            }


            OneColumn_ListAdapter OneAdapt = new OneColumn_ListAdapter(ListOfResource.this, R.layout.one_adapter_view, ul);
            listView2.setAdapter(OneAdapt);


            listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Log.d(TAG, "onItemClick ListView");
                    Intent intent = new Intent(ListOfResource.this, Conformation.class);         // (String Name , Type of value)
                     Toast.makeText(ListOfResource.this, "I: " + i + listView2.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                    // Toast.makeText(ListOfRooms.this, "I: " + i, Toast.LENGTH_LONG).show();
                    String Value = listView2.getItemAtPosition(i).toString();

                   // Log.d(TAG, "onItemClick: " + Value);
                    Toast.makeText(ListOfResource.this, "************* : "+ Value, Toast.LENGTH_LONG).show();

                    intent.putExtra("Room", listView2.getItemAtPosition(i).toString());         // Attaching Data to ListView.
                    startActivity(intent);
                }
            });



        } else if(DaysOrHours.equals("D")){

            setContentView(R.layout.activity_list_of_resource);
            Log.d(TAG, "onCreate: Inside Dates ");

            setTitle = (TextView)findViewById(R.id.pname);
            setTitle.setText(Title);

            Dbp = new DbHelperPj(this);
            // displayTheAvaiRooms();
            listView2 = (ListView) findViewById(R.id.lvp);

            Intent incomIntent = getIntent();    // compAddress
            //  String StartTime = incomIntent.getStringExtra("StartTime");
            // String EndTime = incomIntent.getStringExtra("EndTime");
            String SM = incomIntent.getStringExtra("SM");
            String SD = incomIntent.getStringExtra("SD");
            String SY = incomIntent.getStringExtra("SY");
            String EM = incomIntent.getStringExtra("EM");
            String ED = incomIntent.getStringExtra("ED");
            String EY = incomIntent.getStringExtra("EY");

            Log.d(TAG, "onCreate: Before going to DataBase" + SM);



            Cursor data2 = Dbp.datesSearch(SM,SD,SY,EM,ED,EY,UniqeID);
            ArrayList<User> ul = new ArrayList<>();

            int numRow2 = data2.getCount();

            if (numRow2 == 0){
                Toast.makeText(this, "There is nothing in Database!!!", Toast.LENGTH_SHORT).show();
            }else {
                while (data2.moveToNext()) {          // Have a look over It
                    // user2 = new User(data2.getString(1));
                    user2 = new User(data2.getString(0));
                    ul.add(user2);

                    Log.d(TAG, "onCreate: "+ ul);
                }

                Log.d(TAG, "onCreate: sUCCESSFULL UPTO THIS POINT");
            }

            OneColumn_ListAdapter OneAdapt = new OneColumn_ListAdapter(ListOfResource.this, R.layout.one_adapter_view, ul);
            listView2.setAdapter(OneAdapt);


        }



    }







}

