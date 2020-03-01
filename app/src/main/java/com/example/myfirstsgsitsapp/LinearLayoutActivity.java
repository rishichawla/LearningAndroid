package com.example.myfirstsgsitsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LinearLayoutActivity extends AppCompatActivity {

    EditText ed_mod, ed_pwd;
    Button btn_login;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        ed_mod = (EditText) findViewById(R.id.ed_mob);
        ed_pwd = (EditText) findViewById(R.id.ed_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        pref = getSharedPreferences(Constant.login, MODE_PRIVATE);
        editor = pref.edit();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinearLayoutActivity.this, MainActivity.class);
                startActivity(intent);
                editor.putBoolean(Constant.isLoggedIn, true);
                editor.putString(Constant.mobile, ed_mod.getText().toString());
                editor.commit();
            }
        });


    }
}
