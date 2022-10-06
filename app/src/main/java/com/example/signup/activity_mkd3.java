package com.example.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class activity_mkd3 extends AppCompatActivity {

  //회원가입 한 데이터 담을 배열 선언
 ArrayList<member> memberData = new ArrayList<>();

 //입력값 받아오기
 private EditText signPW , signmail;
 private Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkd3);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signmail_s = signmail.getText().toString();
                String signPW_s = signPW.getText().toString();
                //member 테이블에서 입력값 가져오기
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("member");
                Query mailQuery = databaseReference.orderByChild("signmail").equalTo(signmail_s);
                Query PwQuery = databaseReference.orderByChild("signPW").equalTo(signPW_s);


            }
        });
    }
}