package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MemberFindLoginIdActivity2 extends AppCompatActivity {

    private EditText signmail;
    private Button buttonDoFindLoginId,backBtn;

    //데이터 받아올 member 클래스의 리스트 생성
    member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_find_login_id2);



        signmail  = findViewById(R.id.signmail);
        buttonDoFindLoginId = findViewById(R.id.buttonDoFindLoginId);
        backBtn = findViewById(R.id.backBtn);


       buttonDoFindLoginId.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
           }
         });

        //뒤로가기 버튼
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemberFindLoginIdActivity2.this, account.class);
                startActivity(intent);
            }
        });

   }
}
