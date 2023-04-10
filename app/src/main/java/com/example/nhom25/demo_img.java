package com.example.nhom25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class demo_img extends AppCompatActivity {
    ToggleButton btn_bat;
    Switch switch_Button ;
    ImageView quat,den;
    Boolean checkk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_img);

        quat=findViewById(R.id.quat);
        den = findViewById(R.id.den);
        switch_Button=  findViewById(R.id.switch_Button);
        btn_bat = findViewById(R.id.btn_bat);
        den.setImageResource(R.drawable.baseline_lightbulb_24);
        quat.setImageResource(R.mipmap.quat);

        btn_bat.setText("on");
        btn_bat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (btn_bat.isChecked()) {
                    den.setImageResource(R.drawable.on);
                    btn_bat.setText("off");
                }
                else {
                    den.setImageResource(R.drawable.baseline_lightbulb_24);
                    btn_bat.setText("on");
                }
            }
        });
        switch_Button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    quat.setImageResource(R.mipmap.quay);

                } else {
                    quat.setImageResource(R.mipmap.quat);
                }
            }
        });
    }
}