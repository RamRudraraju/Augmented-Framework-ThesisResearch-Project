package com.example.rrkr2016.javaclassname;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.data;

/**
 * Created by RRKR2016 on 10/17/2017.
 */

public class DbHelperPj extends SQLiteOpenHelper {

    private static final String TAG = "DbHelperPj";

    private static final String TABLE_NAME = "Resource";

    private static final String COL_1 = "ID";
    private static final String COL_2 = "RN";
    private static final String COL_3 = "A";
    private static final String COL_4 = "SM";
    private static final String COL_5 = "SD";
    private static final String COL_6 = "SY";
    private static final String COL_7 = "EM";
    private static final String COL_8 = "ED";
    private static final String COL_9 = "EY";
    private static final String COL_10 = "ST";
    private static final String COL_11 = "ET";


    public DbHelperPj(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " RN TEXT, A INTEGER, SM INTEGER, SD INTEGER, SY INTEGER, EM INTEGER, ED INTEGER, EY INTEGER, ST INTEGER, ET INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String RN, String A,String SM, String SD,String SY,String EM,String ED, String EY,String ST,String ET ) {
        SQLiteDatabase db = this.getWritableDatabase();                    // First thing we have to Do, Creating SQLiteDatabase Object.
        ContentValues contentValues = new ContentValues();                     // Second thing, Creating ContentValues Object which Helps us to write into DataBase.

        contentValues.put(COL_2, RN);
        contentValues.put(COL_3, A);
        contentValues.put(COL_4, SM);
        contentValues.put(COL_5, SD);
        contentValues.put(COL_6, SY);
        contentValues.put(COL_7, EM);
        contentValues.put(COL_8, ED);
        contentValues.put(COL_9, EY);
        contentValues.put(COL_10, ST);
        contentValues.put(COL_11, ET);

        long res = db.insert(TABLE_NAME, null, contentValues);    // Inserting the The values in cv Object (Entered Name)to TABLE_NAME.

        if (res == -1) {
            return false;
        } else {
            return true;


        }
    }

    public Cursor getData() {    // Returns all the Data from Database        // It returns a Cursor Type
        SQLiteDatabase db = this.getWritableDatabase();
        String qr = "SELECT * FROM " + TABLE_NAME;    // It is in the form of
        Cursor data = db.rawQuery(qr, null);
        return data;
    }

    public Cursor roomSearch(String st, String et, String sm, String sd, String sy,String em,String ed,String ey, String UniqeID){
        SQLiteDatabase db = this.getWritableDatabase();

        Log.d(TAG, "UID :" + UniqeID);

        //String Que = "SELECT DISTINCT RN FROM " + TABLE_NAME + " WHERE " + " ( ET <= " + st + " OR " + " ST >= " + et + " ) "  + " AND " + "( SD != " + sd + " ) ";
        String Que = "SELECT DISTINCT RN FROM " + TABLE_NAME + " WHERE " + " ( ET <= " + st + " OR " + " ST >= " + et + " ) "  + " AND " + "( SD != " + sd + " ) " + " AND " +  "( A = " + UniqeID + " ) " ;

        Cursor data = db.rawQuery(Que, null);
        return data;
    }

    public Cursor datesSearch( String sm, String sd, String sy,String em,String ed,String ey, String UniqeID){
        SQLiteDatabase db = this.getWritableDatabase();

        //String Que = "SELECT DISTINCT RN FROM " + TABLE_NAME + " WHERE " + " ( ET <= " + st + " OR " + " ST >= " + et + " ) "  + " AND " + "( SD != " + sd + " ) ";

        int CSV, CEV;

        String t = "0";
        Log.d(TAG, "datesSearch: " + t);
        int it = Integer.valueOf(t);
        Log.d(TAG, "datesSearch: " + it);

        // Log.d(TAG, "datesSearch: " + sm);

        Log.d(TAG, "datesSearch: Before the Errors");

        int iSD = Integer.valueOf(sd);
        Log.d(TAG, "datesSearch: ISD" + iSD);
        int iSM = Integer.valueOf(sm);
        Log.d(TAG, "datesSearch: ISM" + iSM);

        int iEM = Integer.valueOf(em);
        int iED = Integer.valueOf(ed);

        CSV = (100 * iSM) + (iSD);
        CEV = (100 * iEM) + (iED);
        Log.d(TAG, "UID :" + UniqeID);

        int uid = Integer.valueOf(UniqeID);

        // String Que = "SELECT DISTINCT RN FROM " + TABLE_NAME + " WHERE " + "( ((EM * 100) + ED) <= " + CSV + " OR "+ " ((SM * 100) + SD) >=  " + CEV +" )";
     String Que = "SELECT DISTINCT RN FROM " + TABLE_NAME + " WHERE " + "(" + "("+ "( (EM * 100) + ED) < " + CSV + " OR "+ " ((SM * 100) + SD) > " + CEV +" )"+ " AND " + "( A == " + uid + " ) " + " ) ";


        //  String Que = "SELECT DISTINCT RN FROM " + TABLE_NAME +  " WHERE "+  "( A == " + uid + " ) ";                                                                                                                                                  // + " AND " +  "( A != " + 0 + " ) "
        Cursor data = db.rawQuery(Que, null);
        return data;
    }




    public int deleteDataById(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new  String[] {id});
    }

    public int deleteDataLessThan(String endTime){     // Important
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME, "ET <= ? AND ET > 0.1 ", new String[] {endTime});
    }

    public boolean updataData(String id, String RN, String A,String SM, String SD,String SY,String EM,String ED, String EY,String ST,String ET){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, id);
        cv.put(COL_2, RN);
        cv.put(COL_3, A);
        cv.put(COL_4, SM);
        cv.put(COL_5, SD);
        cv.put(COL_6, SY);
        cv.put(COL_7, EM);
        cv.put(COL_8, ED);
        cv.put(COL_9, EY);
        cv.put(COL_10,ST);
        cv.put(COL_11,ET);
        // cv.put(COL_4, RET);
        db.update(TABLE_NAME, cv, "ID = ?", new String[] {id});
        return true;
    }




}
