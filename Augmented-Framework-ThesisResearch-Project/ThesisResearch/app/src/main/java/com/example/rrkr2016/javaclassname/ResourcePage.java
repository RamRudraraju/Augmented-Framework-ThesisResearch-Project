package com.example.rrkr2016.javaclassname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResourcePage extends AppCompatActivity {
    private static final String TAG = "ResourcePage";
    TextView resourceid, setTitle;
    String Resource, DaysOrHours, UniqeID, MaxTime;
    int alotedWindow; Double Ideff;
    // RoomReservation Variables
    DbHelperPj Dbp;
    EditText etStHour, etEndHour, etStMin, etDuration, etsm, etsd, etsy, etem, eted, etey;
    Button bSubmit;
   Intent intent;
    String STimeS, ETimeS, Title;
    // RoomReservation Variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent IncomingResource = getIntent();
        DaysOrHours = IncomingResource.getStringExtra("DorH");
        UniqeID = IncomingResource.getStringExtra("UniqeID");
        MaxTime = IncomingResource.getStringExtra("MaxTime---->");

        Title = IncomingResource.getStringExtra("Title:");

        Log.d(TAG, "onCreate: " + DaysOrHours);
        Log.d(TAG, "onCreate: " + UniqeID);
        Log.d(TAG, "onCreate: " + MaxTime);

        if (DaysOrHours.equals("H")) {
            setContentView(R.layout.activity_resource_page);
            //    resourceid = (TextView)findViewById(R.id.resourceid);
            //   resourceid.setText(Resource);

            setTitle = (TextView)findViewById(R.id.tit);
            setTitle.setText(Title);

            Dbp = new DbHelperPj(this);

            etStHour = (EditText) findViewById(R.id.etStHour);
            etStMin = (EditText) findViewById(R.id.etStMin);
            etDuration = (EditText) findViewById(R.id.etDuration);

            etsm = (EditText) findViewById(R.id.etsmid);
            etsd = (EditText) findViewById(R.id.etsdid);
            etsy = (EditText) findViewById(R.id.etsyid);

            etem = (EditText) findViewById(R.id.etemid);
            eted = (EditText) findViewById(R.id.etedid);
            etey = (EditText) findViewById(R.id.eteyid);


            bSubmit = (Button) findViewById(R.id.bSubmit);
            bSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String StartingHour = etStHour.getText().toString();
                    String StartingMin = etStMin.getText().toString();
                    String Duration = etDuration.getText().toString();

                    String SM = etsm.getText().toString();
                    String SD = etsd.getText().toString();
                    String SY = etsy.getText().toString();
                    String EM = etem.getText().toString();
                    String ED = eted.getText().toString();
                    String EY = etey.getText().toString();

                    if (SD.equals(ED) && SM.equals(EM) && SY.equals(EY)) {

                        if (StartingHour.length() != 0 && StartingMin.length() != 0 && Duration.length() != 0) {

                            Double SHour = Double.valueOf(StartingHour);
                            Double SMin = Double.valueOf(StartingMin);
                            Double Dura = Double.valueOf(Duration);

                            Double STime = SHour + (SMin / 60);
                            Double ETime = STime + Dura;

                            STimeS = STime.toString();
                            ETimeS = ETime.toString();

                            Toast.makeText(ResourcePage.this, "Ending Time was: " + ETime, Toast.LENGTH_SHORT).show();

                            double Ist, Iet;
                            Ist = Double.valueOf(STimeS);
                            Iet = Double.valueOf(ETimeS);
                            Ideff = Iet - Ist;
                            alotedWindow = Integer.valueOf(MaxTime);

                               if(Ideff <= alotedWindow ) {

                                   Log.d(TAG, "Resource: Inside IF condition");

                                   intent =new Intent(ResourcePage.this, ListOfResource.class);

                                   intent.putExtra("StartTime", STimeS);
                                   intent.putExtra("EndTime", ETimeS);
                                   intent.putExtra("Resource", Resource);

                                   intent.putExtra("SM", SM);
                                   intent.putExtra("SD", SD);
                                   intent.putExtra("SY", SY);

                                   intent.putExtra("EM", EM);
                                   intent.putExtra("ED", ED);
                                   intent.putExtra("EY", EY);

                                   intent.putExtra("DaysOrHours:", DaysOrHours);

                                   intent.putExtra("UniqeID", UniqeID);

                                   intent.putExtra("Title:", Title);

                                   startActivity(intent);

                                   etStHour.setText("");
                                   etStMin.setText("");
                                   etDuration.setText("");

                                   etsm.setText("");
                                   etsy.setText("");
                                   etsd.setText("");

                                   etem.setText("");
                                   etey.setText("");
                                   eted.setText("");
                               }
                               else{
                                   Log.d(TAG, "Resource: Rooms are allocated at a Max of :" + alotedWindow);
                                   Toast.makeText(ResourcePage.this, "Rooms are allocated at a Max of :" + alotedWindow + " Hrs", Toast.LENGTH_SHORT).show();
                               }

                        } else {
                            Toast.makeText(ResourcePage.this, "Please enter all the parameters!!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ResourcePage.this, "Please Enter Same Dates!!!", Toast.LENGTH_SHORT).show();
                    }
                }

            });

        } else if (DaysOrHours.equals("D")) {

            Log.d(TAG, "onCreate: Inside the D Section");

            setContentView(R.layout.activity_resource_page_daysonly);

            setTitle = (TextView)findViewById(R.id.tit);
            setTitle.setText(Title);

            Dbp = new DbHelperPj(this);

            etsm = (EditText) findViewById(R.id.etsmid);
            etsd = (EditText) findViewById(R.id.etsdid);
            etsy = (EditText) findViewById(R.id.etsyid);

            etem = (EditText) findViewById(R.id.etemid);
            eted = (EditText) findViewById(R.id.etedid);
            etey = (EditText) findViewById(R.id.eteyid);


            bSubmit = (Button) findViewById(R.id.bSubmit);
            bSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  /*  String StartingHour = etStHour.getText().toString();
                    String StartingMin = etStMin.getText().toString();
                    String Duration = etDuration.getText().toString();
                  */

                    String SM = etsm.getText().toString();
                    String SD = etsd.getText().toString();
                    String SY = etsy.getText().toString();
                    String EM = etem.getText().toString();
                    String ED = eted.getText().toString();
                    String EY = etey.getText().toString();


                    if (SM.length() != 0 && SD.length() != 0 && SY.length() != 0 && EM.length() != 0 && ED.length() != 0 && EY.length() != 0) {

                        int iSM = Integer.valueOf(SM);
                        int iSD = Integer.valueOf(SD);
                        int iSY = Integer.valueOf(SY);
                        int iEM = Integer.valueOf(EM);
                        int iED = Integer.valueOf(ED);
                        int iEY = Integer.valueOf(EY);

                        // Date Caluculation

                        int Sdate = (100 * iSM) + (iSD);
                        int Edate = (100 * iEM) + (iED);
                        int windowFromUser = Edate - Sdate;
                        alotedWindow = Integer.valueOf(MaxTime);


                        if (iSM == 1 || iSM == 3 || iSM == 5 || iSM == 7 || iSM == 8 || iSM == 10 || iSM == 12) {
                            if (windowFromUser <= alotedWindow || (windowFromUser >= 70 && windowFromUser <= 76)) {
                                Log.d(TAG, "onClick: Your Dates are in Range");

                                sendingDates(SM,SD,SY,EM,ED,EY, UniqeID);


                            } else {
                                Log.d(TAG, "onClick: We will only provide for 7 Days");
                            }
                        } else if (iSM == 4 || iSM == 6 || iSM == 9 || iSM == 11) {
                            if (windowFromUser <= alotedWindow || (windowFromUser >= 71 && windowFromUser <= 77)) {
                                Log.d(TAG, "onClick: Your Dates are in Range");

                                sendingDates(SM,SD,SY,EM,ED,EY, UniqeID);

                            } else {
                                Log.d(TAG, "onClick: We will only provide for 7 Days");
                            }

                        } else if (iSM == 2) {
                            if (windowFromUser <= alotedWindow || (windowFromUser >= 73 && windowFromUser <= 79)) {
                                Log.d(TAG, "onClick: Your Dates are in Range");

                                sendingDates(SM,SD,SY,EM,ED,EY, UniqeID);

                            } else {
                                Log.d(TAG, "onClick: We will only provide for 7 Days");
                            }
                        } else {
                            Log.d(TAG, "onClick: You Had enterd a wrong Month");
                        }

                    }


                }

            });

        }
    }

    public void sendingDates(String SM, String SD, String SY,String EM,String ED,String EY, String UniqeID) {

        Intent intent2 = new Intent(ResourcePage.this, ListOfResource.class);

        Log.d(TAG, "sendingDates: " + SM);

        intent2.putExtra("SM", SM);
        intent2.putExtra("SD", SD);
        intent2.putExtra("SY", SY);

        intent2.putExtra("EM", EM);
        intent2.putExtra("ED", ED);
        intent2.putExtra("EY", EY);

        intent2.putExtra("DaysOrHours:", DaysOrHours);

        intent2.putExtra("UniqeID", UniqeID);

        intent2.putExtra("Title:", Title);

        startActivity(intent2);

                            /*    etStHour.setText("");
                                etStMin.setText("");
                                etDuration.setText(""); */

        etsm.setText("");
        etsy.setText("");
        etsd.setText("");

        etem.setText("");
        etey.setText("");
        eted.setText("");
    }


}
