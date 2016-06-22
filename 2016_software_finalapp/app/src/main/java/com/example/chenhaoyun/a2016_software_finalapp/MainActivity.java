package com.example.chenhaoyun.a2016_software_finalapp;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin,
            btnCreateSql,
            btnShare;
    private Button btnFbLogin;
    CallbackManager callbackmanager;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        CallbackManager callbackManager = CallbackManager.Factory.create();;
        btnLogin = (Button)findViewById(R.id.login);
        btnCreateSql = (Button)findViewById(R.id.create_sql);
        btnShare = (Button)findViewById(R.id.share_app);
        btnFbLogin = (Button)findViewById(R.id.Fblogin);


        btnLogin.setOnClickListener(btnLoginOnClick);
        btnCreateSql.setOnClickListener(btnCreateSqlOnClick);
        btnShare.setOnClickListener(btnShareOnClick);
        btnFbLogin.setOnClickListener(btnFbOnClick);

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

    private View.OnClickListener btnShareOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ShareDialog sharedialog = new ShareDialog(MainActivity.this);
            callbackmanager = CallbackManager.Factory.create();

            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setQuote("best APP!!!")
                    .build();
            sharedialog.show(content);
        }
    };

    private View.OnClickListener btnFbOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent it = new Intent();
            it.setClass(MainActivity.this , Main8Activity.class);
            startActivity(it);
        }
    };

}
