package com.example.chenhaoyun.a2016_software_finalapp;

/**
 * Created by User on 2016/6/19.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RestDAO{

    public static final String TABLE_NAME = "item";
    public static final String KEY_ID = "_id";

    public static final String RESTNAME_COLUMN = "Restname";
    public static final String RESTPOSX_COLUMN  = "RestPosX";
    public static final String RESTPOSY_COLUMN = "RestPosY";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            KEY_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " +
            RESTPOSX_COLUMN + " REAL " +
            RESTPOSY_COLUMN + " REAL)";

    private SQLiteDatabase db;

    public RestDAO(Context context){
        db = RestaurnatDBHelper.getRestDb(context);
    }
    
}
