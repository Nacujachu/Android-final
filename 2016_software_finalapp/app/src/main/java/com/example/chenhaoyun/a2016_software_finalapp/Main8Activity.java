package com.example.chenhaoyun.a2016_software_finalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;

public class Main8Activity extends AppCompatActivity {
    private CallbackManager mLoginCallbackManager ;
    private LoginButton butFbLogin;
    private AccessToken accessToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);


        AppEventsLogger.activateApp(getApplication());


        setContentView(R.layout.activity_main8);

         // Login button provided by SDK
        System.out.println("AAAAAFUCKCCCCCCCC");
        mLoginCallbackManager = CallbackManager.Factory.create();
        System.out.println("GGGGGGAAAAAFUCKCCCCCCCC");
        butFbLogin = (LoginButton) findViewById(R.id.login_button);
        System.out.println("GGZZZZZZZZZZGGGGAAAAAFUCKCCCCCCCC");

        assert butFbLogin != null;
        butFbLogin.registerCallback(mLoginCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if(loginResult.getAccessToken() != null){
                    Intent intent = new Intent(Main8Activity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else{

                }
            }

            @Override
            public void onCancel() {
                //TODO
            }

            @Override
            public void onError(FacebookException error) {
                error.printStackTrace();
                Toast.makeText(Main8Activity.this, "Error Login to Facebook", Toast.LENGTH_LONG).show();
            }
        });


    }

            @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        mLoginCallbackManager.onActivityResult(requestCode, resultCode, data);
        }
}
