package com.example.chenhaoyun.a2016_software_finalapp;

/**
 * Created by User on 2016/6/19.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class RestDAO{

    public static final String TABLE_NAME = "rest";
    public static final String KEY_ID = "_id";

    public static final String RESTNAME_COLUMN = "restname";
    public static final String RESTPOSX_COLUMN  = "restposx";
    public static final String RESTPOSY_COLUMN = "restposy";

    public static final String CREATE_TABLE = "CREATE TABLE  IF NOT EXIST" + TABLE_NAME + " (" +
            KEY_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " +
            RESTNAME_COLUMN + " TEXT, " +
            RESTPOSX_COLUMN + " REAL, " +
            RESTPOSY_COLUMN + " REAL)";

    private SQLiteDatabase db;

    public RestDAO(Context context){
        db = RestaurnatDBHelper.getRestDb(context);
        System.out.println("DB constructor");
    }

    public void colse(){
        db.close();
    }

    public RestItem insert(RestItem item){

        ContentValues cv = new ContentValues();
        cv.put(RESTNAME_COLUMN , item.getRestName());
        cv.put(RESTPOSX_COLUMN , item.getPosX());
        cv.put(RESTPOSY_COLUMN , item.getPosY());
        System.out.println(item.getRestName() + " " + item.getPosX() + " " + item.getPosY());
        long id = db.insert(TABLE_NAME , null , cv);
        item.setId(id);

        System.out.println("insert" + id);
        return item;
    }
    public boolean update(RestItem item){
        ContentValues cv = new ContentValues();
        cv.put(RESTNAME_COLUMN , item.getRestName());
        cv.put(RESTPOSX_COLUMN , item.getPosX());
        cv.put(RESTPOSY_COLUMN , item.getPosY());
        String where = KEY_ID + "=" + item.getId();

        return db.update(TABLE_NAME , cv , where , null) > 0;
    }

    public RestItem getRecord(Cursor cursor){


        RestItem ret = new RestItem();
        ret.setRestName(cursor.getString(0));
        ret.setPosX(cursor.getDouble(1));
        ret.setPosY(cursor.getDouble(2));

        return ret;
    }


    public boolean delete(long id){
        String where = KEY_ID + "=" + id;

        return db.delete(TABLE_NAME , where , null )>0;
    }
    public List<RestItem> getAll(){
        List<RestItem> ret = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME , null , null , null ,null , null,null,null );

        while(cursor.moveToNext()){
            ret.add(getRecord(cursor));
        }
        cursor.close();
        return ret;
    }
    public RestItem get(long id){
        RestItem item = null;
        String where = KEY_ID + "=" + id;
        Cursor cursor = db.query(TABLE_NAME , null , where, null , null , null ,null , null );
        if(cursor.moveToFirst()){
            item = getRecord(cursor);
        }
        cursor.close();
        return item;
    }

    public int getCount(){
        int ret = 0;
        Cursor cursor = db.rawQuery("SLELCT COUNT(*) FROM " + TABLE_NAME , null);
        if(cursor.moveToNext()){
            ret = cursor.getInt(0);
        }
        return ret;
    }

    public void DbTest(){
        RestItem item1 = new RestItem(0,"TestRest",25.033408,121.564099);
        System.out.println(item1.getRestName());
        insert(item1);
    }
}
