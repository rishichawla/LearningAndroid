package com.example.myfirstsgsitsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalciActivity extends AppCompatActivity {

    Button btn_one, btn_two, btn_three, btn_plus, btn_equal, btn_minus;
    EditText ed_data;
    int data = 0;
    boolean plus = false, minus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calci);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_plus = (Button) findViewById(R.id.btn_add);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        ed_data = (EditText) findViewById(R.id.ed_data);

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_data.setText(ed_data.getText().toString() + btn_one.getText());
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_data.setText(ed_data.getText().toString() + btn_two.getText());

            }
        });
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_data.setText(ed_data.getText().toString() + btn_three.getText());

            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus = true;
                minus = false;
                data = Integer.parseInt(ed_data.getText().toString());
                ed_data.setText("");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus = false;
                minus = true;
                data = Integer.parseInt(ed_data.getText().toString());
                ed_data.setText("");
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (plus == true) {
                    ed_data.setText(String.valueOf(data +
                            Integer.parseInt(ed_data.getText().toString())));
                }else if (minus == true) {
                    ed_data.setText(String.valueOf(data -
                            Integer.parseInt(ed_data.getText().toString())));
                }
            }
        });
    }
}
