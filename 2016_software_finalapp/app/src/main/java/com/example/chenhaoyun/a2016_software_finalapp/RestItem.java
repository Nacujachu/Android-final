package com.example.chenhaoyun.a2016_software_finalapp;

/**
 * Created by User on 2016/6/19.
 */
import android.content.ClipData;

import java.util.Date;
import java.util.Locale;

public class RestItem implements java.io.Serializable{


    private String RestName;
    private long id;
    private double PosX;
    private double PosY;

    public RestItem(){
        RestName = "";
        PosX = 0.0;
        PosY = 0.0;
    }

    public RestItem(long Id,String name , double x , double y){
        RestName = name;
        id = Id;
        PosX = x;
        PosY = y;
    }
    public long getId(){
        return id;
    }
    public void setId(long ID){
        id = ID;
    }
    public void setRestName(String restName){
        RestName = restName;
    }
    public String getRestName(){
        return RestName;
    }
    public void setPosX(double posX){
        PosX = posX;
    }
    public void setPosY(double posY){
        PosY = posY;
    }
    public double getPosX(){
        return PosX;
    }
    public double getPosY(){
        return PosY;
    }
}
