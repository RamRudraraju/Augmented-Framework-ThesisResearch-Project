package com.example.rrkr2016.javaclassname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


    public class AdminSuccess extends AppCompatActivity {

        Button bAddResource, bViewList, bDeleteRecord, bEditRecord, bDeleteRecordsLessthanET;
        EditText RN, SM,SD,SY,EM,ED,EY,ST,ET, ENorDA,ID, DLETID;
        private static final String TAG = "AdminSuccess";


        DbHelperPj Db;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin_success);

            Db = new DbHelperPj(this);

            RN = (EditText) findViewById(R.id.rnid);
            SM = (EditText) findViewById(R.id.etsmid);
            SD = (EditText) findViewById(R.id.etsdid);
            SY = (EditText) findViewById(R.id.etsyid);
            EM = (EditText) findViewById(R.id.etemid);
            ED = (EditText) findViewById(R.id.etedid);
            EY = (EditText) findViewById(R.id.eteyid);
            ST = (EditText) findViewById(R.id.etStHour);
            ET = (EditText) findViewById(R.id.etStMin);
            ENorDA = (EditText) findViewById(R.id.etDuration);
            ID = (EditText) findViewById(R.id.idid);
            DLETID = (EditText) findViewById(R.id.dletid);

            bAddResource = (Button) findViewById(R.id.bSubmit);
            bViewList    = (Button) findViewById(R.id.bViewListID);
            bDeleteRecord = (Button) findViewById(R.id.bDeleteRecordID);
            bEditRecord = (Button) findViewById(R.id.bEditRecordID);
            bDeleteRecordsLessthanET = (Button) findViewById(R.id.bDeleteRecordsLessthanETID);


            bAddResource.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String Rn = RN.getText().toString();
                    String Sm = SM.getText().toString();
                    String Sd = SD.getText().toString();
                    String Sy = SY.getText().toString();
                    String Em = EM.getText().toString();
                    String Ed = ED.getText().toString();
                    String Ey = EY.getText().toString();
                    String St = ST.getText().toString();
                    String Et = ET.getText().toString();
                    String Enorrn = ENorDA.getText().toString();

                    if((Enorrn.equals("0")) || (Enorrn.equals("1")) ) {
                        if (Rn.length() != 0 && Sm.length() != 0 && Sd.length() != 0 && Sy.length() != 0 && Em.length() != 0 && Ed.length() != 0
                                && Ey.length() != 0 && St.length() != 0 && Et.length() != 0 && Enorrn.length() != 0) {

                            AddData(Rn, Enorrn, Sm, Sd, Sy, Em, Ed, Ey, St, Et);
                        } else {
                            Toast.makeText(AdminSuccess.this, "Please enter all the parameters!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Log.d(TAG, "You Have to Enter Either 0 or 1 in Enable or Dicable Column");
                    }


                }
            });

            bViewList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent is = new Intent(AdminSuccess.this, ViewListContents.class);
                    startActivity(is);
                }
            });

            bDeleteRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int temp = ID.getText().toString().length();
                    if (temp > 0){
                        DeleteData();
                        // String Et = ET.getText().toString();

                        ID.setText("");
                    }else {
                        Toast.makeText(AdminSuccess.this, "Please Enter an ID to Delete a record !!!", Toast.LENGTH_SHORT).show();
                    }

                }
            });

            bEditRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int temp = ID.getText().toString().length();
                    if (temp > 0){ // Checking if User had Entered any thing or Not.
                        UpdateData();
                        // deRd.setText("");
                    }else {
                        Toast.makeText(AdminSuccess.this, "Pleas Enter the Id to Update !!!", Toast.LENGTH_SHORT).show();
                    }

                }
            });

            bDeleteRecordsLessthanET.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int temp = DLETID.getText().toString().length();
                    if (temp > 0){
                        DeleteLessThan();

                    }else {
                        Toast.makeText(AdminSuccess.this, "Please enter the ending time !!!", Toast.LENGTH_SHORT).show();
                    }

                }
            });








        }

        public  void AddData(String RN,String A, String SM,String SD,String SY,String EM,String ED,String EY,String ST,String ET){

            boolean insertData = Db.addData(RN, A, SM,SD,SY,EM,ED,EY,ST,ET);

            if(insertData){
                Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Something went wrong Please check DbHelper.", Toast.LENGTH_LONG).show();
            }

        }

        public void DeleteData(){

            Integer deleteRow = Db.deleteDataById(ID.getText().toString());
            // Here we are passing the ID, to the DbHelper to Delete the Data.
            if(deleteRow > 0){
                Toast.makeText(AdminSuccess.this, "Successfully Deleted the record.", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(AdminSuccess.this, "Something went wrong.", Toast.LENGTH_LONG).show();
            }
        }

        public void UpdateData() {
            boolean update = Db.updataData( ID.getText().toString(),RN.getText().toString(), ENorDA.getText().toString(), SM.getText().toString(), SD.getText().toString(),
                    SY.getText().toString(), EM.getText().toString(), ED.getText().toString(), EY.getText().toString(), ST.getText().toString(), ET.getText().toString());

            if (update) {
                Toast.makeText(AdminSuccess.this, "Successfully Updated.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(AdminSuccess.this, "Something went wrong, In Updating.", Toast.LENGTH_LONG).show();
            }
        }

        private void DeleteLessThan() {
            Integer deleteLessThan = Db.deleteDataLessThan(ENorDA.getText().toString());
            if(deleteLessThan > 0){
                Toast.makeText(AdminSuccess.this, "Successfully Deleted the records.", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(AdminSuccess.this, "Something went wrong.", Toast.LENGTH_LONG).show();
            }
        }


    /*  Old Code  */

    /*
        View.OnClickListener vlc = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent is = new Intent(AdminSuccess.this, ViewListContents.class);
                startActivity(is);
            }
        };
        bViewLi.setOnClickListener(vlc);







        bAddRm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Rn = RN.getText().toString();
                String Sm = SM.getText().toString();
                String Sd = SD.getText().toString();
                String Sy = SY.getText().toString();
                String Em = EM.getText().toString();
                String Ed = ED.getText().toString();
                String Ey = EY.getText().toString();
                String St = ST.getText().toString();
                String Et = ET.getText().toString();


                if(Rn.length() != 0 && Sm.length() != 0 && Sd.length() != 0 && Sy.length() != 0 && Em.length() != 0 && Ed.length() != 0
                        && Ey.length() != 0 && St.length() != 0 && Et.length() != 0){

                    AddData(Rn, Sm,Sd,Sy,Em,Ed,Ey,St,Et);
                }else {
                    Toast.makeText(AdminSuccess.this, "Please enter all the parameters!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        deRd = (EditText) findViewById(R.id.deRdid);


        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = deRd.getText().toString().length();
                if (temp > 0){
                    DeleteData();
                    deRd.setText("");
                }else {
                    Toast.makeText(AdminSuccess.this, "Please Enter an ID to Delete a record !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bEditRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = deRd.getText().toString().length();
                if (temp > 0){ // Checking if User had Entered any thing or Not.
                    UpdateData();
                    // deRd.setText("");
                }else {
                    Toast.makeText(AdminSuccess.this, "Pleas Enter the Id to Update !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bLessEndTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int temp = deRd.getText().toString().length();
                if (temp > 0){
                    DeleteLessThan();
                    // etLessEndTime.setText("");
                }else {
                    Toast.makeText(AdminSuccess.this, "Please enter the ending time !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        */



}
