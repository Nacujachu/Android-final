package com.example.chenhaoyun.a2016_software_finalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//do it for looking for customers

public class Main3Activity extends AppCompatActivity {

        private Button btnOpenTable;
       private Button btnFindList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnOpenTable = (Button) findViewById(R.id.opentable);
        btnFindList = (Button)findViewById(R.id.findlist);

        btnOpenTable.setOnClickListener(btnOpenTableOnClick);
        btnFindList.setOnClickListener(btnFindListOnClick);
    }


    private View.OnClickListener btnOpenTableOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(Main3Activity.this, Main4Activity.class);
            startActivity(it);
        }
    };

    private  View.OnClickListener btnFindListOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v)
        {
            Intent it = new Intent();
            it.setClass(Main3Activity.this, Main5Activity.class);
            startActivity(it);
        }


    };

}

