package com.example.rrkr2016.javaclassname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Conformation extends AppCompatActivity {

    private  static final String TAG = "SecondActivity";
    // ImageView Iv;
    TextView incomingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conformation);

        incomingData = (TextView) findViewById(R.id.etIncomingData);
        //  Iv = (ImageView) findViewById(R.id.imageView);

        Intent incomIntent = getIntent();
        String incomingRoom = incomIntent.getStringExtra("Room");

        Toast.makeText(Conformation.this, "User Clicked on: " + incomingRoom, Toast.LENGTH_LONG).show();

        incomingData.setText(incomingRoom);

    }
}

