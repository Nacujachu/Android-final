package com.example.chenhaoyun.a2016_software_finalapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private static final String DB_FILE = "user.db",
            DB_TABLE = "user";

    private SQLiteDatabase myUserDb;

    private EditText edtName,
            edtGender,
            edtAge,
            edtList;

    private Button btnAdd,
            btnList,
            btnDelete;

    private Spinner mSpnsalary;
    private String msSalary;

    private Spinner mSpntime;
    private String msTime;

    private Spinner mSpnlocate;
    private String msLocate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //build user database
        UserDbOpenHelper userDbOpenHelper = new UserDbOpenHelper(getApplicationContext(), DB_FILE, null, 1);
        myUserDb = userDbOpenHelper.getWritableDatabase();

        //check 資料表是否已存在
        Cursor cursor = myUserDb.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + DB_TABLE + "'", null);

        if (cursor != null) {

            if (cursor.getCount() == 0) {
                myUserDb.execSQL("CREATE TABLE " + DB_TABLE + " (" + "_id INTEGER PRIMARY KEY, " +
                        "name TEXT NOT NULL," +
                        "gender TEXT," +
                        "age INTEGER," +
                        "time TEXT," +
                        "locate TEXT," +
                        "salary TEXT );");
            }
            cursor.close();
        }

        edtName = (EditText) findViewById(R.id.textusername);
        edtGender = (EditText) findViewById(R.id.textusergender);
        edtAge = (EditText) findViewById(R.id.textuserage);


        edtList = (EditText) findViewById(R.id.editlist);

        btnAdd = (Button) findViewById(R.id.add);
        btnList = (Button) findViewById(R.id.list);
        btnDelete = (Button) findViewById(R.id.del);
        btnAdd.setOnClickListener(btnAddOnClick);
        btnList.setOnClickListener(btnListOnClick);
        btnDelete.setOnClickListener(btnDeleteOnClick);

        mSpnsalary = (Spinner) findViewById(R.id.spnsalary);
        mSpnsalary.setOnItemSelectedListener(spnSalaryOnItemSelected);

        mSpntime = (Spinner) findViewById(R.id.spntime);
        mSpntime.setOnItemSelectedListener(spnTimeOnItemSelected);

        mSpnlocate = (Spinner) findViewById(R.id.spnlocate);
        mSpnlocate.setOnItemSelectedListener(spnLocateOnItemSelected);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //  final String DROP_TABLE = "DROP TABLE IF EXISTS" + DB_TABLE;
        // myUserDb.execSQL(DROP_TABLE);
        myUserDb.close();
    }

    private View.OnClickListener btnAddOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Cursor cursor = myUserDb.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + DB_TABLE + "'", null);

            if (cursor != null) {

                if (cursor.getCount() == 0) {
                    myUserDb.execSQL("CREATE TABLE " + DB_TABLE + " (" + "_id INTEGER PRIMARY KEY," +
                            "name TEXT NOT NULL," +
                            "gender TEXT," +
                            "age INTEGER," +
                            "time TEXT," +
                            "locate TEXT," +
                            "salary TEXT);");
                }
                cursor.close();
            }

            ContentValues nrow = new ContentValues();
            nrow.put("name", edtName.getText().toString());
            nrow.put("gender", edtGender.getText().toString());
            nrow.put("age", edtAge.getText().toString());
            nrow.put("time", msTime);
            nrow.put("locate", msLocate);
            nrow.put("salary", msSalary);

            myUserDb.insert(DB_TABLE, null, nrow);
        }

    };

    private View.OnClickListener btnDeleteOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            final String DROP_TABLE = "DROP TABLE IF EXISTS " + DB_TABLE;
            myUserDb.execSQL(DROP_TABLE);
            myUserDb.execSQL("DROP TABLE IF EXISTS " + "gender");
            myUserDb.execSQL("DROP TABLE IF EXISTS " + "age");
            myUserDb.execSQL("DROP TABLE IF EXISTS " + "time");
            myUserDb.execSQL("DROP TABLE IF EXISTS " + "locate");
            //   myUserDb.close();
        }

    };

    private View.OnClickListener btnListOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Cursor cursor = myUserDb.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + DB_TABLE + "'", null);

            if (cursor != null) {

                if (cursor.getCount() == 0) {
                    myUserDb.execSQL("CREATE TABLE " + DB_TABLE + " (" + "_id INTEGER PRIMARY KEY," +
                            "name TEXT NOT NULL," +
                            "gender TEXT," +
                            "age INTEGER," +
                            "time TEXT," +
                            "locate TEXT," +
                            "salary TEXT);");
                }

                cursor.close();
            }
            Cursor c = myUserDb.query(true, DB_TABLE, new String[]{"name", "gender", "age", "time", "locate", "salary"}, null, null, null, null, null, null);

            if (c == null) return;

            if (c.getCount() == 0) {
                edtList.setText("");
                Toast.makeText(Main2Activity.this, "沒有資料", Toast.LENGTH_LONG).show();

            } else {
                c.moveToFirst();
                edtList.setText(c.getString(0) + "  " + c.getString(1) + "  " + c.getString(2) + "  " + c.getString(3) + "  " + c.getString(4) + "  " + c.getString(5));

                while (c.moveToNext()) {
                    edtList.append("\n" + c.getString(0) + "  " + c.getString(1) + "  " + c.getString(2) + "  " + c.getString(3) + "  " + c.getString(4) + "  " + c.getString(5));
                }
            }

        }
    };


    private AdapterView.OnItemSelectedListener spnSalaryOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView parent, View view, int i, long l) {
            msSalary = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnItemSelectedListener spnTimeOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView parent, View view, int i, long l) {
            msTime = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnItemSelectedListener spnLocateOnItemSelected = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int i, long l) {
                msLocate = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
    };

}