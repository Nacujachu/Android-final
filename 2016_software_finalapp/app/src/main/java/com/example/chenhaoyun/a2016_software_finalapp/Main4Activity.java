package com.example.chenhaoyun.a2016_software_finalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {


    private Button btnComfirmOpentable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btnComfirmOpentable = (Button) findViewById(R.id.comfirm_opentable);

        btnComfirmOpentable.setOnClickListener(btnComfirmOpenTableOnClick);

    }


    private View.OnClickListener btnComfirmOpenTableOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(Main4Activity.this, Main6Activity.class);
            startActivity(it);
        }
    };


}
