package com.example.myfirstsgsitsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView img_splash;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pref = getSharedPreferences(Constant.login, MODE_PRIVATE);
        editor = pref.edit();
        img_splash = (ImageView) findViewById(R.id.img_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pref.getBoolean(Constant.isLoggedIn, false)) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, LinearLayoutActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 4000);
    }
}
