package com.example.rgsj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class User extends AppCompatActivity {

    TextView textName,textEmail,textPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail);
        textName = findViewById(R.id.tv_uName);
        textEmail = findViewById(R.id.tv_uEmail);
        textPhone = findViewById(R.id.tv_uPhone);

        textName.setText(getIntent().getStringExtra("name"));
        textEmail.setText(getIntent().getStringExtra("email"));
        textPhone.setText(getIntent().getStringExtra("phone"));

    }
}