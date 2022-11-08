package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Mypage extends AppCompatActivity {
    private ImageButton bottomHomeBtn, bottomBackBtn;
    private Button btn_test3 , matching_list , btn_test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);


        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPW = intent.getStringExtra("userPW");
        String userPhoneNB = intent.getStringExtra("userPhoneNB");
        String userServiceID = intent.getStringExtra("userServiceID");
        String userName = intent.getStringExtra("userName");
        String userBirthday = intent.getStringExtra("userBirthday");
        String userBirthday2 = intent.getStringExtra("userBirthday2");
        String userBirthday3 = intent.getStringExtra("userBirthday3");
        String userMail = intent.getStringExtra("userMail");
        String userAddress = intent.getStringExtra("userAddress");


        bottomHomeBtn = findViewById(R.id.bottomHomeBtn);
        bottomHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


        bottomBackBtn = findViewById(R.id.bottomBackBtn);
        bottomBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        btn_test2 = findViewById(R.id.btn_test2);
        btn_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mypage.this, loginMyPage.class);
                intent.putExtra("userID", userID);
                intent.putExtra("userPW", userPW);
                intent.putExtra("userServiceID", userServiceID);
                intent.putExtra("userName", userName);
                intent.putExtra("userAddress", userAddress);
                intent.putExtra("userMail", userMail);
                intent.putExtra("userBirthday", userBirthday);
                intent.putExtra("userBirthday2", userBirthday2);
                intent.putExtra("userBirthday3", userBirthday3);
                intent.putExtra("userPhoneNB", userPhoneNB);
                startActivity(intent);



            }
        });


    }}
