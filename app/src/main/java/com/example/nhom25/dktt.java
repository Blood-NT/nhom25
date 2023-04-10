package com.example.nhom25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dktt extends AppCompatActivity {

    Button dky;
    TextView show_tk;
    EditText tk, mk, ns, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dktt);
        sett();
        runn();
    }


    private void sett() {
        dky= findViewById(R.id.dky);

        show_tk= findViewById(R.id.show_tk);

        tk= findViewById(R.id.tk);
        mk= findViewById(R.id.mk);
        ns= findViewById(R.id.ns);
        mail= findViewById(R.id.mail);

    }

    private void runn() {
        dky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tk.getText().length()==0)
                {
                    tk.requestFocus();
                    tk.setError("Hãy nhập thông tin");

                }
                if (mk.getText().length()==0)
                {
                    mk.requestFocus();
                    mk.setError("Hãy nhập thông tin");

                }
                if (ns.getText().length()==0)
                {
                    ns.requestFocus();
                    ns.setError("Hãy nhập thông tin");

                }
                if (mail.getText().length()==0)
                {
                    mail.requestFocus();
                    mail.setError("Hãy nhập thông tin");

                }
                show_tk.setText("Tài khoản: "+ tk.getText().toString() + "\n Mật khẩu: " + mk.getText().toString()+"\n Ngày sinh: "+ ns.getText().toString() +"\n email: "+ mail.getText().toString());
            }
        });
    }

}