package com.example.rrkr2016.javaclassname;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {

    InputStream inputStream;
    private static final String TAG = "MainActivity";
    String  csvLine, resourceType;
    int n = 0, classCount;
    Resource ob;
    String[] ids, className = new String[10];// resourceTitleArray = new String[10], resourceFunionsArray = new String[10], resourceUniIdeArray = new String[10];
    String RN, A, SM, SD, SY, EM, ED, EY, ST, ET,  resourceFunOn, resourceUniIde, stClassCount, resourceMaxTime;
    int numberOfCol = 10;
    String[][] resourceGrid;
    DbHelperPj Dbp;

    EditText TFusername, TFpassword;
    Button Bsignup, Blogin;
    String Username, Password;
    String[] resourceTitleArray , resourceFunionsArray , resourceUniIdeArray, resourceMaxTimeArray ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dbp = new DbHelperPj(this);

        TFusername = (EditText) findViewById(R.id.TFusername);
        TFpassword = (EditText) findViewById(R.id.TFpassword);
        Bsignup = (Button) findViewById(R.id.Bsignup);
        Blogin = (Button) findViewById(R.id.Blogin);

        /* Reading Multiple Resource Titles*/
                        inputStream = getResources().openRawResource(R.raw.resourcer);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        try {

                            if( (csvLine = reader.readLine()) != null ){

                                ids = csvLine.split(",");
                                Log.d(TAG, "Crossed the Split Line");
                                resourceType = ids[0];

                                         Log.d(TAG, "csvWithHeader: "+ resourceType);
                                          int i = 0;

                                        if(resourceType.equals("\uFEFF1"))
                                            {
                                                classCount = 1;
                                                Log.d(TAG, "Number of Classes = " + classCount);
                                            }
                                        if(resourceType.equals("\uFEFF2"))
                                            {
                                                classCount = 2;
                                                Log.d(TAG, "Number of Classes = " + classCount);
                                            }
                                        if(resourceType.equals("\uFEFF3"))
                                            {
                                                classCount = 3;
                                                Log.d(TAG, "Number of Classes = " + classCount);
                                            }
                                        if(resourceType.equals("\uFEFF4"))
                                            {
                                                classCount = 4;
                                                Log.d(TAG, "Number of Classes = " + classCount);
                                            }


                                        try {
                                            while ((csvLine = reader.readLine()) != null){

                                                ids = csvLine.split(",");

                                                if( n == 0){
                                                    n++;
                                                }else if(n == 1) {

                                                    Log.d(TAG, "csvWithHeader: Came Inside Else ");
                                                    try {
                                                        Log.d(TAG, "onCreate: Room Number: ids " + ids[0]);
                                                        className[i] = ids[0];
                                                        Log.d(TAG, "onCreate: Room Number: cN " + className[i]);
                                                        i++;
                                                    } catch (Exception e) {
                                                        Log.d(TAG, "onCreate: Inside Exception 1");

                                                    }
                                                }
                                            }
                                        }
                                        catch (Exception e){
                                            Log.d(TAG, "onCreate: Inside Exception 2");
                                        }

                            }
                            else{
                                   Log.d(TAG, "csvWithHeader: There is no data in the Input file.");
                                }

                            Log.d(TAG, "onCreate: Came Before the Count ------   ");

                        }
                        catch (Exception e){
                           Log.d(TAG, "onCreate: Inside Exception 3");
                        }

                      /*  Log.d(TAG, "Controller came Before the Count." );
                        classCount = className.length;
                        Log.d(TAG, "onCreate: " + classCount);
                       */

                          Log.d(TAG, "Before the For Loop");
                            //   for (int j = 0; j < className.length; j++){
                        for (int j = 0; j < classCount; j++){

                            Log.d(TAG, "Name of Classes : " + className[j]);

                        }

               // String[] resourceTitleArray = new String[classCount], resourceFunionsArray = new String[classCount], resourceUniIdeArray = new String[classCount];

                       resourceTitleArray = new String[classCount];
                       resourceFunionsArray = new String[classCount];
                       resourceUniIdeArray = new String[classCount];

        /* New Code */
                       resourceMaxTimeArray = new String[classCount];
         /* New Code */

                     Log.d(TAG, " Length of resourceTitleArray " + resourceTitleArray.length);
                     Log.d(TAG, " Length of resourceFunionsArray " + resourceFunionsArray.length);
                     Log.d(TAG, " Length of resourceUniIdeArray " + resourceUniIdeArray.length);
                     Log.d(TAG, " Length of resourceMaxTimeArray --> " + resourceMaxTimeArray.length);

        /* Reading Multiple Resource Titles*/


        /* Assinning the Resource Titles to the Variables and calling the Associated classes */

                        for (int j = 0; j < classCount; j++){

                          //  Log.d(TAG, "Name of Classes : " + className[j]);

                            String inputJavaClass;
                            inputJavaClass = className[j];

                            Log.d(TAG, "onCreate: " + inputJavaClass);


                            String resName = "com.example.rrkr2016.javaclassname." + inputJavaClass;


                            try {

                                Class exampleClass = Class.forName(resName);
                                ob = (Resource) exampleClass.newInstance();
                                resourceGrid = ob.getResourceMatrix();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            String[] rowMatrix = new String[numberOfCol];

                            resourceType = ob.getName();
                            Log.d(TAG, "extraResourceData: resourceType ---> " + resourceType);
                            resourceTitleArray[j] =  resourceType;
                            Log.d(TAG, "extraResourceData: resourceTitleArray ---> " + resourceTitleArray[j]);

                            resourceFunOn = ob.getHorD();
                            Log.d(TAG, "extraResourceData: resourceFunOn ---> " + resourceFunOn);
                            resourceFunionsArray[j] =  resourceFunOn;
                            Log.d(TAG, "extraResourceData: resourceFunionsArray ---> " + resourceFunionsArray[j]);

                            resourceUniIde = ob.getUniqueIdentifier();
                            Log.d(TAG, "extraResourceData: resourceUniIde ---> " + resourceUniIde);
                            resourceUniIdeArray[j] =  resourceUniIde;
                            Log.d(TAG, "extraResourceData: resourceUniIde ---> " + resourceUniIdeArray[j]);

                            resourceMaxTime = ob.timePeriod();
                            Log.d(TAG, "extraResourceData: TimePeriod ---> " + resourceMaxTime);
                            resourceMaxTimeArray[j] =  resourceMaxTime;
                            Log.d(TAG, "extraResourceData: TimePeriod --------------> " + resourceMaxTimeArray[j]);


                           // Log.d(TAG, "extraResourceData: resourceFunOn ---> " + resourceFunOn);

                            for (int row = 2; row < resourceGrid.length; row++) {
                                int n = 0;

                                for (int col = 0; col < resourceGrid[row].length; col++) {

                                    rowMatrix[n] = resourceGrid[row][col];
                                    n++;
                                }

                                RN = rowMatrix[0];
                                A = rowMatrix[1];
                                SM = rowMatrix[2];
                                SD = rowMatrix[3];
                                SY = rowMatrix[4];
                                EM = rowMatrix[5];
                                ED = rowMatrix[6];
                                EY = rowMatrix[7];
                                ST = rowMatrix[8];
                                ET = rowMatrix[9];
                                Log.d(TAG, "extraResourceData: Before AddDate Method ---> " + RN + A + SM + SD + SY + EM + ED + EY + ST + ET);

                                AddData(RN, A, SM, SD, SY, EM, ED, EY, ST, ET);
                            }

                        }



                        for (int j = 0; j < classCount; j++){

                            Log.d(TAG, "Name of Classes in the Array : " + resourceTitleArray[j]);
                            Log.d(TAG, "Parameters on which the Functionality has to Apply : " + resourceFunionsArray[j]);
                            Log.d(TAG, "Unique Identifiers in the Database : " + resourceUniIdeArray[j]);
                            Log.d(TAG, "Max Time Period: ---------> " + resourceMaxTimeArray[j]);

                        }
        /* Assinning the Resource Titles to the Variables and calling the Associated classes */


        /* Login Button Code */

                      stClassCount = Integer.toString(classCount);

                        View.OnClickListener log = new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast tl = Toast.makeText(MainActivity.this, "Entered in to the login", Toast.LENGTH_SHORT);
                                tl.show();

                                TFusername = (EditText) findViewById(R.id.TFusername);
                                Username = TFusername.getText().toString();
                                TFpassword = (EditText) findViewById(R.id.TFpassword);
                                Password = TFpassword.getText().toString();

                                if (Username.equals("admin") && Password.equals("admin")) {
                                    Intent is = new Intent(MainActivity.this, AdminSuccess.class);
                                    startActivity(is);
                                } else {
                                    Intent is = new Intent(MainActivity.this, ListOfResourceButtons.class);

                                    is.putExtra("NumberOfResources:", stClassCount);
                                    is.putExtra("ClassTitlesArray:", resourceTitleArray);
                                    is.putExtra("ParametersDorHArray:", resourceFunionsArray);
                                    is.putExtra("UniqrIdentifierArray:", resourceUniIdeArray);
                                    is.putExtra("MaxTimePeriod:", resourceMaxTimeArray);

                                    startActivity(is);
                                }
                            }
                        };
                        Blogin.setOnClickListener(log);

         /* Login Button Code Ending */


    }


                        /* Method to Add Resource*/
                        public void AddData(String RN, String A, String SM, String SD, String SY, String EM, String ED, String EY, String ST, String ET) {

                            boolean insertData = Dbp.addData(RN, A, SM, SD, SY, EM, ED, EY, ST, ET);

                            if (insertData) {
                              //  Toast.makeText(this, "Data Inserted Successfully-", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "Something went wrong Please check DbHelper.", Toast.LENGTH_LONG).show();
                            }

                        }
                         /* Method to Add Resource*/

}
