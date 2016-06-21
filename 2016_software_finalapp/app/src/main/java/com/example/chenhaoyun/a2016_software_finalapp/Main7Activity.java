package com.example.chenhaoyun.a2016_software_finalapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;


import java.util.Objects;

public class Main7Activity extends AppCompatActivity {

    private Button btnInvite_1,
                btnInvite_2 ,
                btnInvite_3;
    private String Self;
    private SQLiteDatabase myUserDb;
    private static final String DB_FILE = "user.db",
            DB_TABLE = "user",
            DB_GENDER_TABLE = "gender",
            DB_AGE_TABLE = "age",
            DB_LOCATE_TABLE = "locate",
            DB_TIME_TABLE = "time",
            DB_FINAL_TABLE = "salary";
    private String[] Locate_mem;
    private static  String GENDER_PICK="" ,
                        LOCATE_PICK_1="",
                        LOCATE_PICK_2 = "",
                        LOCATE_PICK_3 = "",
                        TIME_PICK="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        btnInvite_1 = (Button)findViewById(R.id.match_1);
        btnInvite_2 = (Button)findViewById(R.id.match_2);
        btnInvite_3 = (Button)findViewById(R.id.match_3);
        btnInvite_1.setOnClickListener(btnMatchOneOnclick);
        btnInvite_2.setOnClickListener(btnMatchTwoOnclick);
        btnInvite_3.setOnClickListener(btnMatchThreeOnclick);

        int textViewCount = 7;
        Locate_mem = new String[20];

        TextView[] textViewArray = new TextView[textViewCount];

        for (int i = 0; i < textViewCount; i++) {
            textViewArray[i] = new TextView(this);
        }

        int number = 0;

        UserDbOpenHelper userDbOpenHelper = new UserDbOpenHelper(getApplicationContext(), DB_FILE, null, 1);
        myUserDb = userDbOpenHelper.getWritableDatabase();

        textViewArray[0] = (TextView) findViewById(R.id.first);
        textViewArray[1] = (TextView) findViewById(R.id.second);
        textViewArray[2] = (TextView) findViewById(R.id.third);
        textViewArray[3] = (TextView) findViewById(R.id.fourth);
        textViewArray[4] = (TextView) findViewById(R.id.fifth);
        textViewArray[5] = (TextView) findViewById(R.id.sixth);
        textViewArray[6] = (TextView) findViewById(R.id.seventh);

        //  String[] TxtArray = {"Txtfirst","Txtsecond","Txtthird","Txtfourth","Txtfifth","Txtsixth","Txtseventh"};


        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        String nowUserName = bundle.getString("nowUserName");
        String nowUserGender = bundle.getString("nowUserGender");
        String nowAge = bundle.getString("nowAge");
        String nowUserTime = bundle.getString("nowUserTime");
        String nowUserLocate = bundle.getString("nowUserLocate");
        String nowUserSalary = bundle.getString("nowUserSalary");
        //   edtMatchSequence.setText(nowUserSalary);
        Self = nowUserLocate;
        if ("male".equals(nowUserGender)) {
            GENDER_PICK = "female";
        } else {
            GENDER_PICK = "male";
        }

        TIME_PICK = nowUserTime;

        if (nowUserLocate.equals("Taipei")) {
            LOCATE_PICK_1 = "Taipei";
            LOCATE_PICK_2 = "New Taipei";
            LOCATE_PICK_3 = "Ilan";
        } else if (nowUserLocate.equals("Taoyuan")) {
            LOCATE_PICK_1 = "Taoyuan";
            LOCATE_PICK_2 = "New Taipei";
            LOCATE_PICK_3 = "Hsinchu";
        } else if (nowUserLocate.equals("Hsinchu")) {
            LOCATE_PICK_1 = "Hsinchu";
            LOCATE_PICK_2 = "Taoyuan";
            LOCATE_PICK_3 = "Miaoli";
        } else if (nowUserLocate.equals("Miaoli")) {
            LOCATE_PICK_1 = "Miaoli";
            LOCATE_PICK_2 = "Hsinchu";
            LOCATE_PICK_3 = "Taichung";
        } else if (nowUserLocate.equals("Taichung")) {
            LOCATE_PICK_1 = "Taichung";
            LOCATE_PICK_2 = "Miaoli";
            LOCATE_PICK_3 = "Chunghua";
        } else if (nowUserLocate.equals("Chunghua")) {
            LOCATE_PICK_1 = "Chunghua";
            LOCATE_PICK_2 = "Yunlin";
            LOCATE_PICK_3 = "Taichung";
        } else if (nowUserLocate.equals("Yunlin")) {
            LOCATE_PICK_1 = "Yunlin";
            LOCATE_PICK_2 = "Chunghua";
            LOCATE_PICK_3 = "Chiayi";
        } else if (nowUserLocate.equals("Chiayi")) {
            LOCATE_PICK_1 = "Chiayi";
            LOCATE_PICK_2 = "Yunlin";
            LOCATE_PICK_3 = "Tainan";
        } else if (nowUserLocate.equals("Tainan")) {
            LOCATE_PICK_1 = "Tainan";
            LOCATE_PICK_2 = "Chiayi";
            LOCATE_PICK_3 = "Kaohsiung";
        } else if (nowUserLocate.equals("Kaohsiung")) {
            LOCATE_PICK_1 = "Kaohsiung";
            LOCATE_PICK_2 = "Tainan";
            LOCATE_PICK_3 = "Pingtung";
        } else if (nowUserLocate.equals("New Taipei") ){
            LOCATE_PICK_1 = "New Taipei";
            LOCATE_PICK_2 = "Taoyuan";
            LOCATE_PICK_3 = "Taipei";
        }

        Cursor c = myUserDb.rawQuery("select name, gender, age, time, locate, salary " +
                "from " + DB_TABLE + " where gender = " + "'" + GENDER_PICK + "'", null);

        myUserDb.execSQL("CREATE TABLE IF NOT EXISTS " + DB_GENDER_TABLE + " (" + "_id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "gender TEXT," +
                "age INTEGER," +
                "time TEXT," +
                "locate TEXT," +
                "salary TEXT);");
        if (c.moveToFirst()) {
            ContentValues nrow = new ContentValues();
            nrow.put("name", c.getString(0));
            nrow.put("gender", c.getString(1));
            nrow.put("age", c.getString(2));
            nrow.put("time", c.getString(3));
            nrow.put("locate", c.getString(4));
            nrow.put("salary", c.getString(5));
            myUserDb.insert(DB_GENDER_TABLE, null, nrow);
        }
        ContentValues nro = new ContentValues();
        while (c.moveToNext()) {
            //      edtTest.append("\n" + c.getString(0) + " " + c.getString(2));

            nro.put("name", c.getString(0));
            nro.put("gender", c.getString(1));
            nro.put("age", c.getString(2));
            nro.put("time", c.getString(3));
            nro.put("locate", c.getString(4));
            nro.put("salary", c.getString(5));
            myUserDb.insert(DB_GENDER_TABLE, null, nro);

            nro.clear();
        }
        c.close();

        Cursor c1 = myUserDb.rawQuery("select name, gender, age, time, locate, salary " +
                "from " + DB_GENDER_TABLE +
                " where age <= 40 and age >=18" + " ORDER BY age ASC ", null);

        myUserDb.execSQL("CREATE TABLE IF NOT EXISTS " + DB_AGE_TABLE + " (" + "_id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "gender TEXT," +
                "age INTEGER," +
                "time TEXT," +
                "locate TEXT," +
                "salary TEXT);");

        if (c1.moveToFirst()) {

            ContentValues nrow1 = new ContentValues();
            nrow1.put("name", c1.getString(0));
            nrow1.put("gender", c1.getString(1));
            nrow1.put("age", c1.getString(2));
            nrow1.put("time", c1.getString(3));
            nrow1.put("locate", c1.getString(4));
            nrow1.put("salary", c1.getString(5));
            //    edtTest.setText(c.getString(0) + " " + c.getString(2));

            myUserDb.insert(DB_AGE_TABLE, null, nrow1);
        }

        ContentValues nro1 = new ContentValues();
        while (c1.moveToNext()) {
            //      edtTest.append("\n" + c.getString(0) + " " + c.getString(2));

            nro1.put("name", c1.getString(0));
            nro1.put("gender", c1.getString(1));
            nro1.put("age", c1.getString(2));
            nro1.put("time", c1.getString(3));
            nro1.put("locate", c1.getString(4));
            nro1.put("salary", c1.getString(5));
            myUserDb.insert(DB_AGE_TABLE, null, nro1);

            nro1.clear();
        }
        c1.close();

        Cursor c2 = myUserDb.rawQuery("select name, gender, age, time, locate, salary " +
                "from " + DB_AGE_TABLE +
                " where time = " + "'" + TIME_PICK + "'", null);

        myUserDb.execSQL("CREATE TABLE IF NOT EXISTS " + DB_TIME_TABLE + " (" + "_id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "gender TEXT," +
                "age INTEGER," +
                "time TEXT," +
                "locate TEXT," +
                "salary TEXT);");

        if (c2.moveToFirst()) {
            ContentValues nrow2 = new ContentValues();
            nrow2.put("name", c2.getString(0));
            nrow2.put("gender", c2.getString(1));
            nrow2.put("age", c2.getString(2));
            nrow2.put("time", c2.getString(3));
            nrow2.put("locate", c2.getString(4));
            nrow2.put("salary", c2.getString(5));
            //      edtTest.setText(c2.getString(0) + " " + c2.getString(3));

            myUserDb.insert(DB_TIME_TABLE, null, nrow2);
        }
        ContentValues nro2 = new ContentValues();
        while (c2.moveToNext()) {
            //             edtTest.append("\n" + c2.getString(0) + " " + c2.getString(3));

            nro2.put("name", c2.getString(0));
            nro2.put("gender", c2.getString(1));
            nro2.put("age", c2.getString(2));
            nro2.put("time", c2.getString(3));
            nro2.put("locate", c2.getString(4));
            nro2.put("salary", c2.getString(5));
            myUserDb.insert(DB_TIME_TABLE, null, nro2);

            nro2.clear();
        }
        c2.close();

        Cursor c3 = myUserDb.rawQuery("select name, gender, age, time, locate, salary " +
                "from " + DB_TIME_TABLE +
                " where locate = " + "'" + LOCATE_PICK_1 + "'", null);
        myUserDb.execSQL("CREATE TABLE IF NOT EXISTS " + DB_LOCATE_TABLE + " (" + "_id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "gender TEXT," +
                "age INTEGER," +
                "time TEXT," +
                "locate TEXT," +
                "salary TEXT);");
        if (c3.moveToFirst()) {
            ContentValues nrow3 = new ContentValues();
            nrow3.put("name", c3.getString(0));
            nrow3.put("gender", c3.getString(1));
            nrow3.put("age", c3.getString(2));
            nrow3.put("time", c3.getString(3));
            nrow3.put("locate", c3.getString(4));
            nrow3.put("salary", c3.getString(5));
            myUserDb.insert(DB_LOCATE_TABLE, null, nrow3);
        }
        ContentValues nro3 = new ContentValues();
        while (c3.moveToNext()) {
            //      edtTest.append("\n" + c.getString(0) + " " + c.getString(2));

            nro3.put("name", c3.getString(0));
            nro3.put("gender", c3.getString(1));
            nro3.put("age", c3.getString(2));
            nro3.put("time", c3.getString(3));
            nro3.put("locate", c3.getString(4));
            nro3.put("salary", c3.getString(5));
            myUserDb.insert(DB_LOCATE_TABLE, null, nro3);

            nro3.clear();
        }
        c3.close();

        Cursor c4 = myUserDb.rawQuery("select name, gender, age, time, locate, salary " +
                "from " + DB_TIME_TABLE +
                " where locate = " + "'" + LOCATE_PICK_2 + "'" + " or " + "locate = " + "'" + LOCATE_PICK_3 + "'", null);

        if (c4.moveToFirst()) {
            ContentValues nrow4 = new ContentValues();
            nrow4.put("name", c4.getString(0));
            nrow4.put("gender", c4.getString(1));
            nrow4.put("age", c4.getString(2));
            nrow4.put("time", c4.getString(3));
            nrow4.put("locate", c4.getString(4));
            nrow4.put("salary", c4.getString(5));
            myUserDb.insert(DB_LOCATE_TABLE, null, nrow4);
        }
        ContentValues nro4 = new ContentValues();
        while (c4.moveToNext()) {
            //      edtTest.append("\n" + c.getString(0) + " " + c.getString(2));

            nro4.put("name", c4.getString(0));
            nro4.put("gender", c4.getString(1));
            nro4.put("age", c4.getString(2));
            nro4.put("time", c4.getString(3));
            nro4.put("locate", c4.getString(4));
            nro4.put("salary", c4.getString(5));
            myUserDb.insert(DB_LOCATE_TABLE, null, nro4);

            nro4.clear();
        }
        c4.close();
        Cursor c0 = myUserDb.query(true, DB_LOCATE_TABLE, new String[]{"name", "gender", "age", "time", "locate", "salary"}, null, null, null, null, null, null);

        if (c0 == null) return;

        if (c0.getCount() == 0) {
            //.setText("");
            Toast.makeText(Main7Activity.this, "沒有資料", Toast.LENGTH_LONG).show();

        } else {
            c0.moveToFirst();
            textViewArray[number].setText(c0.getString(0) + "小姐  年齡：" + c0.getString(2) + " \n聚餐時間：" + c0.getString(3) + "\n聚餐地點：" + c0.getString(4));
            Locate_mem[number] = c0.getString(4);
            number++;
            while (c0.moveToNext()) {
                textViewArray[number].setText(c0.getString(0) + "小姐  年齡：" + c0.getString(2) + " \n聚餐時間：" + c0.getString(3) + "\n聚餐地點：" + c0.getString(4));
                Locate_mem[number] = c0.getString(4);
                number++;
            }
            c0.close();
            number = 0;
        }
    }

    private View.OnClickListener btnMatchOneOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("SelfLocate",Self);
            bundle.putString("EatLocate",Locate_mem[0]);
            it.putExtras(bundle);
            it.setClass(Main7Activity.this,MapsActivity.class);
            Toast.makeText(Main7Activity.this,"已發送邀請!!",Toast.LENGTH_LONG).show();
            startActivity(it);
        }
    };
    private View.OnClickListener btnMatchTwoOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("SelfLocate",Self);
            bundle.putString("EatLocate",Locate_mem[1]);
            it.putExtras(bundle);
            it.setClass(Main7Activity.this,MapsActivity.class);
            Toast.makeText(Main7Activity.this,"已發送邀請!!",Toast.LENGTH_LONG).show();
            startActivity(it);
        }
    };
    private View.OnClickListener btnMatchThreeOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("SelfLocate",Self);
            bundle.putString("EatLocate",Locate_mem[2]);
            it.putExtras(bundle);
            it.setClass(Main7Activity.this,MapsActivity.class);
            Toast.makeText(Main7Activity.this,"已發送邀請!!",Toast.LENGTH_LONG).show();
            startActivity(it);
        }
    };
}



