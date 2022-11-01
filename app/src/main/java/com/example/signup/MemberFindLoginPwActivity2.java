package com.example.signup;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class MemberFindLoginPwActivity2 extends AppCompatActivity {

    private EditText signID,signmail;
    private Button buttonDoFindLoginPw, buttonCancel, emailcheck;

    //데이터 받아올 member 클래스의 리스트 생성
    member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_find_login_pw2);



        signID = findViewById(R.id.signID);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonDoFindLoginPw = findViewById(R.id.buttonDoFindLoginPw);
        emailcheck = findViewById(R.id.emailcheck);
        signmail = findViewById(R.id.signmail);






    }
}

