package com.example.rrkr2016.javaclassname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ListOfResourceButtons extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button B1, B2, B3, B4, B5, B6, B7, B8, B9, B10;
    String[] ClassNames, correspondingDorH, correspondingUniIdent, correspondingMaxTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent IncomingResource = getIntent();

           String resourceNumber = IncomingResource.getStringExtra("NumberOfResources:");
            ClassNames = getIntent().getStringArrayExtra("ClassTitlesArray:");
            correspondingDorH = getIntent().getStringArrayExtra("ParametersDorHArray:");
            correspondingUniIdent = getIntent().getStringArrayExtra("UniqrIdentifierArray:");
            correspondingMaxTime = getIntent().getStringArrayExtra("MaxTimePeriod:");

           int cn = ClassNames.length;
           int dh = correspondingDorH.length;
           int ui = correspondingUniIdent.length;
           int mtp = correspondingMaxTime.length;

        Log.d(TAG, "Length of the Input Strings : " + cn + " " + dh + " " + ui+"----->"+ mtp);
        //DaysOrHours = IncomingResource.getStringExtra("DaysOrHours:");

        Log.d(TAG, "Before If Condition " + resourceNumber);

        for(int i = 0; i < cn ; i++){
            Log.d(TAG, "Class Name : " + ClassNames[i]);
            Log.d(TAG, "D or H : " + correspondingDorH[i]);
            Log.d(TAG, "Uni ID : " + correspondingUniIdent[i]);
            Log.d(TAG, "Max Times : " + correspondingMaxTime[i]);

        }

           if(resourceNumber.equals("1")) {
               setContentView(R.layout.activity_list_of_resource_buttons);

                    B1 = (Button) findViewById(R.id.b1);

                    B1.setText(ClassNames[0]);

                   B1.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {

                           Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                           is.putExtra("DorH", correspondingDorH[0]);
                           is.putExtra("UniqeID",correspondingUniIdent[0]);
                           is.putExtra("MaxTime---->",correspondingMaxTime[0]);

                           // String
                           is.putExtra("Title:", ClassNames[0]);

                           startActivity(is);

                       }
                   });




                }
           else if(resourceNumber.equals("2")) {
               setContentView(R.layout.activity_list_of_resource_buttons2);

                       B1 = (Button) findViewById(R.id.b1);
                       B2 = (Button) findViewById(R.id.b2);


                       B1.setText(ClassNames[0]);
                       B2.setText(ClassNames[1]);


                       B1.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {

                               Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                               is.putExtra("DorH", correspondingDorH[0]);
                               is.putExtra("UniqeID",correspondingUniIdent[0]);
                               is.putExtra("MaxTime---->",correspondingMaxTime[0]);

                               is.putExtra("Title:", ClassNames[0]);


                               startActivity(is);

                           }
                       });

                       B2.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {

                               Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                               is.putExtra("DorH", correspondingDorH[1]);
                               is.putExtra("UniqeID",correspondingUniIdent[1]);
                               is.putExtra("MaxTime---->",correspondingMaxTime[1]);

                               is.putExtra("Title:", ClassNames[1]);

                               startActivity(is);

                           }
                       });



           }
           else if(resourceNumber.equals("3")) {
               setContentView(R.layout.activity_list_of_resource_buttons3);

                  B1 = (Button) findViewById(R.id.b1);
                  B2 = (Button) findViewById(R.id.b2);
                  B3 = (Button) findViewById(R.id.b3);

                      B1.setText(ClassNames[0]);
                      B2.setText(ClassNames[1]);
                      B3.setText(ClassNames[2]);

                      B1.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {

                              Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                              is.putExtra("DorH", correspondingDorH[0]);
                              is.putExtra("UniqeID",correspondingUniIdent[0]);
                              is.putExtra("MaxTime---->",correspondingMaxTime[0]);

                              is.putExtra("Title:", ClassNames[0]);

                              startActivity(is);

                          }
                      });

                       B2.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {

                               Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                               is.putExtra("DorH", correspondingDorH[1]);
                               is.putExtra("UniqeID",correspondingUniIdent[1]);
                               is.putExtra("MaxTime---->",correspondingMaxTime[1]);

                               is.putExtra("Title:", ClassNames[1]);

                               startActivity(is);

                           }
                       });

                       B3.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {

                               Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                               is.putExtra("DorH", correspondingDorH[2]);
                               is.putExtra("UniqeID",correspondingUniIdent[2]);
                               is.putExtra("MaxTime---->",correspondingMaxTime[2]);

                               is.putExtra("Title:", ClassNames[2]);

                               startActivity(is);

                           }
                       });



                }
           else if(resourceNumber.equals("4")) {
               setContentView(R.layout.activity_list_of_resource_buttons4);

                   B1 = (Button) findViewById(R.id.b1);
                   B2 = (Button) findViewById(R.id.b2);
                   B3 = (Button) findViewById(R.id.b3);
                   B4 = (Button) findViewById(R.id.b4);

                   B1.setText(ClassNames[0]);
                   B2.setText(ClassNames[1]);
                   B3.setText(ClassNames[2]);
                   B4.setText(ClassNames[3]);

               B1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                       is.putExtra("DorH", correspondingDorH[0]);
                       is.putExtra("UniqeID",correspondingUniIdent[0]);
                       is.putExtra("MaxTime---->",correspondingMaxTime[0]);

                       is.putExtra("Title:", ClassNames[0]);

                       startActivity(is);

                   }
               });

               B2.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                       is.putExtra("DorH", correspondingDorH[1]);
                       is.putExtra("UniqeID",correspondingUniIdent[1]);
                       is.putExtra("MaxTime---->",correspondingMaxTime[1]);

                       is.putExtra("Title:", ClassNames[1]);

                       startActivity(is);

                   }
               });

               B3.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                       is.putExtra("DorH", correspondingDorH[2]);
                       is.putExtra("UniqeID",correspondingUniIdent[2]);
                       is.putExtra("MaxTime---->",correspondingMaxTime[2]);

                       is.putExtra("Title:", ClassNames[2]);

                       startActivity(is);

                   }
               });

               B4.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       Intent is = new Intent(ListOfResourceButtons.this, ResourcePage.class);

                       is.putExtra("DorH", correspondingDorH[3]);
                       is.putExtra("UniqeID",correspondingUniIdent[3]);
                       is.putExtra("MaxTime---->",correspondingMaxTime[3]);

                       is.putExtra("Title:", ClassNames[3]);

                       startActivity(is);

                   }
               });


           }



    }
}
