package com.example.nhom25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
public class bai11 extends AppCompatActivity {
    private EditText usernameEditText;


    private EditText passwordEditText;
    private CheckBox rememberMeCheckBox;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai11);
        ImageView imageView = findViewById(R.id.img_log);

        Picasso.get().load("https://scontent.fsgn5-10.fna.fbcdn.net/v/t39.30808-6/340341879_246828674580697_1592864459040586876_n.jpg?stp=dst-jpg_p843x403&_nc_cat=107&ccb=1-7&_nc_sid=730e14&_nc_ohc=yGl0E1CKGKIAX8nHOmb&_nc_ht=scontent.fsgn5-10.fna&oh=00_AfA77JK0DF7o463os70e921P05CfgmIwnN9wVJU1h2xLzg&oe=643841A1").into(imageView);

        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        rememberMeCheckBox = findViewById(R.id.remember_me_check_box);

        sharedPreferences = getSharedPreferences("loginPreferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getBoolean("rememberMe", false)) {
            String savedUsername = sharedPreferences.getString("username", "");
            String savedPassword = sharedPreferences.getString("password", "");
            usernameEditText.setText(savedUsername);
            passwordEditText.setText(savedPassword);
            rememberMeCheckBox.setChecked(true);
        }
    }

    public void login(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (rememberMeCheckBox.isChecked()) {
            editor.putBoolean("rememberMe", true);
            editor.putString("username", username);
            editor.putString("password", password);
            editor.apply();
        } else {
            editor.clear();
            editor.apply();
        }

        // Do the login logic here
    }
}
