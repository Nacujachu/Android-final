package com.example.chenhaoyun.a2016_software_finalapp;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Nacu on 2016/6/18.
 */
public class RestaurnatDBHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "RestData.db";
    public static final int VERSION = 1;
    private static SQLiteDatabase RestDb;


    public RestaurnatDBHelper(Context context , String name , CursorFactory factory , int VERSION){
        super(context, name , factory , VERSION);
    }

    public static  SQLiteDatabase getRestDb (Context context){
        if(RestDb == null || !RestDb.isOpen()) {
            //System.out.println("getRestDb");
            RestDb = new RestaurnatDBHelper(context, DATABASE_NAME, null, VERSION).getWritableDatabase();
        }
        return RestDb;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //
       // System.out.println("QQ on Create DB");
       // db.execSQL(RestDAO.CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion){
        //
       // db.execSQL("DROP TABLE IF EXIST" + RestDAO.TABLE_NAME);
       // onCreate(db);
    }
}
