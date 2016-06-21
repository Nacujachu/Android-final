package com.example.chenhaoyun.a2016_software_finalapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main5Activity extends AppCompatActivity {

    private Button btnComfirmStartMatch;

    private SQLiteDatabase myUserDb;

    private static final String DB_FILE = "user.db",
            DB_TABLE = "user";
    private EditText nowEdtName,
            nowEdtGender,
            nowEdtAge;

    private Spinner mSpnUsersalary;
    private String msUserSalary;

    private Spinner mSpnUsertime;
    private String msUserTime;

    private Spinner mSpnUserlocate;
    private String msUserLocate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        btnComfirmStartMatch = (Button) findViewById(R.id.comfirm_startmatch);
        btnComfirmStartMatch.setOnClickListener(btnComfirmStartMatchOnClick);

        nowEdtName = (EditText) findViewById(R.id.nowusername);
        nowEdtGender = (EditText) findViewById(R.id.nowusergender);
        nowEdtAge = (EditText) findViewById(R.id.nowuserage);


        mSpnUsersalary = (Spinner) findViewById(R.id.nowusersalary);
        mSpnUsersalary.setOnItemSelectedListener(spnUserSalaryOnItemSelected);

        mSpnUsertime = (Spinner) findViewById(R.id.nowusertime);
        mSpnUsertime.setOnItemSelectedListener(spnUserTimeOnItemSelected);

        mSpnUserlocate = (Spinner) findViewById(R.id.nowuserlocate);
        mSpnUserlocate.setOnItemSelectedListener(spnUserLocateOnItemSelected);


        UserDbOpenHelper userDbOpenHelper = new UserDbOpenHelper(getApplicationContext(), DB_FILE, null, 1);
        myUserDb = userDbOpenHelper.getWritableDatabase();

    }


    private View.OnClickListener btnComfirmStartMatchOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // Intent it = new Intent();


           // final String DROP_TABLE = "DROP TABLE IF EXISTS " + DB_TABLE;
          //  myUserDb.execSQL(DROP_TABLE);
            myUserDb.execSQL("DROP TABLE IF EXISTS " + "gender");
            myUserDb.execSQL("DROP TABLE IF EXISTS " + "age");
            myUserDb.execSQL("DROP TABLE IF EXISTS " + "time");
            myUserDb.execSQL("DROP TABLE IF EXISTS " + "locate");

            Intent transIt = new Intent();
            transIt.setClass(Main5Activity.this, Main7Activity.class);
            Bundle bundle = new Bundle();


            Editable StrName;
            StrName = nowEdtName.getText();
            String nowStrName = StrName.toString();

            Editable StrGender;
            StrGender = nowEdtGender.getText();
            String nowStrGender = StrGender.toString();

            Editable StrAge;
            StrAge = nowEdtAge.getText();
            String nowStrAge = StrAge.toString();

            //int nowAge = Integer.parseInt(nowStrAge);



            bundle.putString("nowUserName",nowStrName);
            bundle.putString("nowUserGender",nowStrGender);
            bundle.putString("nowUserAge",nowStrAge);
            bundle.putString("nowUserTime",msUserTime);
            bundle.putString("nowUserLocate",msUserLocate);
            bundle.putString("nowUserSalary",msUserSalary);

            transIt.putExtras(bundle);
            // startActivity(transIt);

            startActivity(transIt);
         //   it.setClass(Main5Activity.this, Main7Activity.class);
         //   startActivity(it);
        }
    };

    private AdapterView.OnItemSelectedListener spnUserSalaryOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView parent, View view, int i, long l) {
            msUserSalary = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnItemSelectedListener spnUserTimeOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView parent, View view, int i, long l) {
            msUserTime = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnItemSelectedListener spnUserLocateOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView parent, View view, int i, long l) {
            msUserLocate = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

}
