package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class user_info2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info2);

        //전달할 데이터 받을 intent 선언
        Intent intent=  getIntent();
        //String 형식으로 전달받을 signmail 저장
        String signmail = intent.getStringExtra("signmail");

        //전달되는지 테스트 (나중에 지울거)
        TextView emailEditText = findViewById(R.id.emailEditText);
        emailEditText.setText(signmail);
    }
}