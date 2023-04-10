package com.example.nhom25;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9,btn10,btn11,btn12_sql,btn12_api;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();


        run();
    }
    private void setup() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12_sql = findViewById(R.id.btn12_sql);
        btn12_api = findViewById(R.id.btn12_api);
    }
    private void run() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, Frame_layout.class);
                startActivity(view2);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, Linearlayout.class);
                startActivity(view2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, phep_tinh.class);
                startActivity(view2);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, dktt.class);
                startActivity(view2);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, ttcn.class);
                startActivity(view2);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, demo_img.class);
                startActivity(view2);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, bai7.class);
                startActivity(view2);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, bai8.class);
                startActivity(view2);
            }
        });


        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, bai11.class);
                startActivity(view2);
            }
        });
        btn12_sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, bai12_SQL.class);
                startActivity(view2);
            }
        });
        btn12_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view2 = new Intent(MainActivity.this, bai12_API.class);
                startActivity(view2);
            }
        });

    }


}