package com.example.darkknight.bmicalc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;


public class InClassDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="inclass"; //Name of the DB
    private static final int DB_VERSION = 1; //version of the DB
    public static final String TABLE_NAME ="PERSON"; // name of table

    public InClassDatabaseHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION) ; //null id for cursor
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        System.out.println("CREATE TABLE "+ TABLE_NAME+"( "
                +"_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"NAME TEXT,"
                +"PASSWORD TEXT,"
                +"HEALTH_CARD_NUMB TEXT,"
                +"DATE INTEGER );");
        db.execSQL("CREATE TABLE "+ TABLE_NAME+"( "
        +"_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
        +" NAME TEXT,"
        +" PASSWORD TEXT,"
        +" HEALTH_CARD_NUMB TEXT,"
        +" DATE INTEGER );");


        Date today = new Date(); // we want to start with some initial data
        ContentValues personValues = new ContentValues();
        personValues.put("NAME", "DAN PENNY");
        personValues.put("PASSWORD", "SUPER SECRET");
        personValues.put("HEALTH_CARD_NUMB", "123456789101");
        personValues.put("DATE", today.getTime());

        db.insert(TABLE_NAME,null,personValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}

