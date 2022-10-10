package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class Mypage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Button mypage = findViewById(R.id.mypage);
        mypage.setOnClickListener(v -> {
            Intent intent = new Intent(Mypage.this, user_info.class);
            startActivity(intent);
        });



    }
}