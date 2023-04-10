package com.example.nhom25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class phep_tinh extends AppCompatActivity {
    int kqq ;

    Button cong, tru, nhan, chia;
    EditText stn, sth;
    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phep_tinh);
        cong= findViewById(R.id.cong);
        tru= findViewById(R.id.tru);
        nhan= findViewById(R.id.nhan);
        chia= findViewById(R.id.chia);
        kq= findViewById(R.id.kq);





        stn = findViewById(R.id.stn);
        sth = findViewById(R.id.sth);
        clickk();



    }
    private void clickk() {
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                run("+");

            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                run("-");

            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                run("*");

            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                run("/");
            }
        });

    }
    private void run(String tmp) {
        if (stn.getText().length()==0)
        {
            stn.requestFocus();
            stn.setError("Hãy nhập số thứ nhất" );
        }
        else if (sth.getText().length()==0) {
            sth.requestFocus();
            sth.setError("Hãy nhập số thứ 2");
        }

        else{
           switch (tmp) {
               case "+":
                   kqq = Integer.parseInt(stn.getText().toString()) + Integer.parseInt(sth.getText().toString());
                   break;
               case "-":
                   kqq = Integer.parseInt(stn.getText().toString()) - Integer.parseInt(sth.getText().toString());
                   break;
               case "*":
                   kqq = Integer.parseInt(stn.getText().toString()) * Integer.parseInt(sth.getText().toString());
                   break;
               case "/":
                   if (Integer.parseInt(sth.getText().toString())==0) {
                       sth.setError("Trong phép chia số chia không thể bằng 0");
                       kq.setText("");
                       return;
                   }
                   else
                       kqq = Integer.parseInt(stn.getText().toString()) / Integer.parseInt(sth.getText().toString());
                   break;
           }
           kq.setText("Kết quả của Phép tính \n"+stn.getText().toString()+ "/"+sth.getText().toString()+"="+ kqq );
       }

    }


}