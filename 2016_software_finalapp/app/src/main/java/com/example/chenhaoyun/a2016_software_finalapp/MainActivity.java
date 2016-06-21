package com.example.chenhaoyun.a2016_software_finalapp;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin,
            btnCreateSql;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            btnLogin = (Button)findViewById(R.id.login);
        btnCreateSql = (Button)findViewById(R.id.create_sql);

            btnLogin.setOnClickListener(btnLoginOnClick);
            btnCreateSql.setOnClickListener(btnCreateSqlOnClick);



    }
   private View.OnClickListener btnCreateSqlOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this, Main2Activity.class);
            startActivity(it);
        }
    };

    private View.OnClickListener btnLoginOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent();
            it.setClass(MainActivity.this, Main3Activity.class);
            startActivity(it);
        }
    };

}
