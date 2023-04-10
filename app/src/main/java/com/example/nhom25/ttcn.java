package com.example.nhom25;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ttcn extends AppCompatActivity {
    Button submit_btn;
    EditText edt_ho_va_ten, edt_cmnd,khacc;
    CheckBox Game_check, Sach_check, Bao_check;
    //    RadioButton DH_check, CD_check,TC_check;
    TextView show_name,show_cmnd,show_bangcap,show_sothich,show_khac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttcn);
        set_ctrl();
        set_even();
    }

    private void set_ctrl() {
        submit_btn= findViewById(R.id.submit_btn);

        edt_ho_va_ten= findViewById(R.id.edt_ho_va_ten);
        edt_cmnd= findViewById(R.id.edt_cmnd);
        khacc=findViewById(R.id.khacc);

        Game_check= findViewById(R.id.Game_check);
        Sach_check= findViewById(R.id.Sach_check);
        Bao_check= findViewById(R.id.Bao_check);

        show_name= findViewById(R.id.show_name);
        show_cmnd= findViewById(R.id.show_cmnd);
        show_bangcap= findViewById(R.id.show_bangcap);
        show_sothich= findViewById(R.id.show_sothich);
        show_khac= findViewById(R.id.show_khac);

    }

    private void set_even() {
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_info();
            }
        });

    }

    private void show_info() {
        try {
            String tmp_str="";
            // check hvt va cccd
            tmp_str=edt_ho_va_ten.getText().toString().trim();
            if (tmp_str.length()<3)
            {
                edt_ho_va_ten.selectAll();
                edt_ho_va_ten.requestFocus();
                edt_ho_va_ten.setError("họ tên không nhỏ hơn 3 ký tự");
                return;
            }
            show_name.setText("Ho va ten: "+ tmp_str );
            tmp_str="";
            tmp_str=edt_cmnd.getText().toString().trim();
            if (tmp_str.length()==9 || tmp_str.length()==12)
            {
                show_cmnd.setText("Ho va ten: "+ tmp_str );
            }
            else
            {
                edt_cmnd.selectAll();
                edt_cmnd.requestFocus();
                edt_cmnd.setError("cccd có 12 số, cmnd có 9 sô");
                return;
            }
            tmp_str="";
            RadioGroup checkkk=(RadioGroup) findViewById(R.id.rdo_group);
            int id=checkkk.getCheckedRadioButtonId();
            if (id==-1)
            {
                Toast.makeText(getApplication(),"chọn trình độ", Toast.LENGTH_LONG).show();
                return;
            }
            RadioButton get_btn=(RadioButton)findViewById(id);
            tmp_str= get_btn.getText().toString();
            show_bangcap.setText(" trình độ : " + tmp_str);
            tmp_str="";
            if (Game_check.isChecked())
                tmp_str+=Game_check.getText().toString();
            if (Bao_check.isChecked())
                tmp_str+=Bao_check.getText().toString();
            if (Sach_check.isChecked())
                tmp_str+=Sach_check.getText().toString();
            if (tmp_str.length()==0)
                tmp_str="khác";
            show_sothich.setText("sở thích :" + tmp_str);
            tmp_str= khacc.getText().toString().trim();
            show_khac.setText("note: "+ tmp_str);
        }
        catch (Exception e){
            Log.d("1",e.getMessage());
        }
    }

}