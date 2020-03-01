package com.example.myfirstsgsitsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_click, btn_calci, btn_linear, btn_logout;
    TextView txt_goodBye;
    EditText ed_one, ed_two, ed_result;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_click = (Button) findViewById(R.id.btn_click);
        btn_calci = (Button) findViewById(R.id.btn_cacli);
        btn_linear = (Button) findViewById(R.id.btn_linear);
        txt_goodBye = (TextView) findViewById(R.id.txt_goodBye);
        ed_one = (EditText) findViewById(R.id.ed_one);
        ed_two = (EditText) findViewById(R.id.ed_two);
        ed_result = (EditText) findViewById(R.id.ed_result);
        btn_logout = (Button) findViewById(R.id.btn_logout);

        pref = getSharedPreferences(Constant.login, MODE_PRIVATE);
        editor = pref.edit();

        txt_goodBye.setText("Welcome, " + pref.getString(Constant.mobile, "goodBye"));

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_result.setText(String.valueOf(Integer.parseInt(ed_one.getText().toString())
                        + Integer.parseInt(ed_two.getText().toString())));
            }
        });

        btn_calci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalciActivity.class);
                startActivity(intent);
            }
        });
        btn_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
                editor.putBoolean(Constant.isLoggedIn, false);
                editor.remove(Constant.mobile);
                editor.commit();
            }
        });
    }
}
