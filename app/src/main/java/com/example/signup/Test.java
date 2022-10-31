package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity {
    private TextView tvid, tvpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tvid = findViewById(R.id.tvid);
        tvpass = findViewById(R.id.tvpass);

        Intent intent =getIntent();
        String userID = intent.getStringExtra("userID");
        String userpass = intent.getStringExtra("userpass");

        tvid.setText(userID);
        tvpass.setText(userpass);
    }
}