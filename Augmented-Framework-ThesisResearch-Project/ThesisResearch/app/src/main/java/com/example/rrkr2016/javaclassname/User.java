package com.example.rrkr2016.javaclassname;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by RRKR2016 on 10/17/2017.
 */

public class User {

    public String ID,RN, A, SM,SD,SY,EM,ED,EY,ST,ET;

    public User(String id, String rn, String a, String sm,String sd, String sy, String em, String ed,String ey,String st, String et){    // When the Ibject was created Everything was
        // Stored in the Single Object.
        ID = id;
        RN = rn;
        A = a;
        SM = sm;
        SD = sd;
        SY = sy;
        EM = em;
        ED = ed;
        EY = ey;
        ST = st;
        ET = et;
    }

    public User(String rn){
        String  Res = rn;
        Log.d(TAG, "User: " + Res);
        RN = Res;
        Log.d(TAG, "User: " + RN);
    }

    public String getID(){
        return  ID;
    }
    public String getRN(){
        return  RN;
    }
    public String getA(){
        return  A;
    }
    public String getSM(){
        return  SM;
    }
    public String getSD(){
        return  SD;
    }
    public String getSY(){
        return  SY;
    }
    public String getEM(){
        return  EM;
    }
    public String getED(){
        return  ED;
    }
    public String getEY(){
        return  EY;
    }
    public String getST(){
        return  ST;
    }
    public String getET(){
        return  ET;
    }

}

