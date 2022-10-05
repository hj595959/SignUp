package com.example.signup;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private Button signupbutton;
    private EditText signName,  signID, signmail, signBirth, signBirth2, signBirth3, signPW, signPW2 ;
    private FirebaseDatabase database = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스연동
    private DatabaseReference databaseReference = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupbutton = findViewById(R.id.signupbutton);
        signName = findViewById(R.id.signName);
        signmail = findViewById(R.id.signmail);
        signID = findViewById(R.id.signID);
        signBirth = findViewById(R.id.signBirth);
        signBirth2 = findViewById(R.id.signBirth2);
        signBirth3 = findViewById(R.id.signBirth3);
        signPW = findViewById(R.id.signPW);

        //회원가입 버튼
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //값을 텍스트로 변환후 함수 선언

                addMember(signName.getText().toString(),signmail.getText().toString(),signID.getText().toString(),signBirth.getText().toString(),signBirth2.getText().toString(),signBirth3.getText().toString(),signPW.getText().toString());

                Toast.makeText(getApplicationContext(), "회원가입에 성공했습니다!", Toast.LENGTH_LONG).show();

            }
        });


        //뒤로 가기 버튼
        Button back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, account.class);
            startActivity(intent);
        });





    }
        //member값 넣어주기위한 함수
        public void addMember(String signName, String signmail, String signID,String signBirth, String signBirth2,String signBirth3,String signPW){
          //member 클래스 에서 선언했던 함수
          member member = new member(signName,signmail,signID,signBirth,signBirth2,signBirth3,signPW);
          databaseReference.child("member").push().setValue(member); //member그룹으로 값 저장
        }






    }
