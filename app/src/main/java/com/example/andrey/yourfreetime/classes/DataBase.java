package com.example.andrey.yourfreetime.classes;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "yourfreetime.db";
    private static final int DATABASE_VERSION = 1;

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student ("
                + "name,"
                + "category,"
                + "id_icon,"
                + "timeofbegin,"
                + "durationofday,"
                + "durationofweek,"
                + "durationofmonth,"
                + "durationofall"+");");

        db.execSQL("create table worker ("
                + "name,"
                + "category,"
                + "id_icon,"
                + "timeofbegin,"
                + "durationofday,"
                + "durationofweek,"
                + "durationofmonth,"
                + "durationofall"+");");

        db.execSQL("create table pensioner ("
                + "name,"
                + "category,"
                + "id_icon,"
                + "timeofbegin,"
                + "durationofday,"
                + "durationofweek,"
                + "durationofmonth,"
                + "durationofall" + ");");

        db.execSQL("create table staticdata ("
            + "timeoffirstinclude"+");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
