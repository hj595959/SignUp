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

    private Button pwcheck , signupbutton;
    private EditText signName, gender, signID,serviceId, signmail, signBirth, signBirth2, signBirth3, signPw, signPw2;
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
        signPw = findViewById(R.id.signPW);

        //회원가입 버튼
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //값을 텍스트로 변환후 함수 선언
                addMember(signName.getText().toString(),signmail.getText().toString(),signID.getText().toString(),signBirth.getText().toString(),signBirth2.getText().toString(),signBirth3.getText().toString(),signPw.getText().toString());
            }
        });


        //뒤로 가기 버튼
        Button back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, account.class);
            startActivity(intent);
        });



        //비밀번호 확인 버튼
        pwcheck = findViewById(R.id.pwcheckbutton);
        pwcheck.setOnClickListener(v -> {
            if(signPw.getText().toString().equals(signPw2.getText().toString())){
                pwcheck.setText("일치");
            }else{
                Toast.makeText(this,"비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });

    }
        //member값 넣어주기위한 함수
        public void addMember(String signName, String signmail, String signID,String signBirth, String signBirth2,String signBirth3,String signPw){
          //member 클래스 에서 선언했던 함수
          member member = new member(signName,signmail,signID,signBirth,signBirth2,signBirth3,signPw);
          databaseReference.child("member").setValue(member); //member그룹으로 값 저장
        }



    }
