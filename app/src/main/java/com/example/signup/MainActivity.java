package com.example.signup;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private Button signupbutton;
    private EditText signName,  signID, signmail, signBirth, signBirth2, signBirth3, signPW, signPW2 ;
    private RadioGroup gender , serviceId;
    private RadioButton male,female,patient,caregiver;
    private FirebaseDatabase database = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스연동
    private DatabaseReference databaseReference = database.getReference();
    private String gender_result , serviceId_result;

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
        gender = findViewById(R.id.gender);
        serviceId =  findViewById(R.id.serviceId);
        male=  findViewById(R.id.male); // 남자
        female = findViewById(R.id.female); //여자
        patient = findViewById(R.id.patient); //환자
        caregiver = findViewById(R.id.caregiver); //간병인

        //성별 라디오 버튼 상태 값 담기
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.male){
                    gender_result = String.valueOf(male.getText());
                }else if(i == R.id.female){
                    gender_result = String.valueOf(female.getText());
                }
            }
        });
        //간병인 인지 환자인지 버튼 값 담기
        serviceId.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.patient){
                    serviceId_result = String.valueOf(patient.getText());
                }else if(i == R.id.caregiver){
                    serviceId_result = String.valueOf(caregiver.getText());
                }
            }
        });
        //회원가입 버튼
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //유효성 체크
                if(signName.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요!",Toast.LENGTH_SHORT).show();
                    signName.requestFocus();
                }else if(signmail.getText().toString().length() ==0){
                    Toast.makeText(getApplicationContext(),"메일을 입력하세요!",Toast.LENGTH_SHORT).show();
                    signmail.requestFocus();
                }else if(signID.getText().toString().length() ==0){
                    Toast.makeText(getApplicationContext(),"아이디를 입력하세요!",Toast.LENGTH_SHORT).show();
                    signID.requestFocus();
                }else if(signBirth.getText().toString().length() ==0){
                    Toast.makeText(getApplicationContext(),"년도를 입력하세요!",Toast.LENGTH_SHORT).show();
                    signBirth.requestFocus();
                }else if(signBirth2.getText().toString().length() ==0) {
                    Toast.makeText(getApplicationContext(), "월을 입력하세요!", Toast.LENGTH_SHORT).show();
                    signBirth2.requestFocus();
                }else if(signBirth3.getText().toString().length() ==0) {
                    Toast.makeText(getApplicationContext(), "일을 입력하세요!", Toast.LENGTH_SHORT).show();
                    signBirth3.requestFocus();
                }else {
                    //값을 텍스트로 변환후 함수 선언
                    addMember(gender_result, serviceId_result, signName.getText().toString(), signmail.getText().toString(), signID.getText().toString(), signBirth.getText().toString(), signBirth2.getText().toString(), signBirth3.getText().toString(), signPW.getText().toString());
                    //회원가입 성공 메세지
                    Toast.makeText(getApplicationContext(), "회원가입에 성공했습니다!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, account.class);
                    startActivity(intent);
                }

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
        public void addMember(String gender_result,String serviceId_result,String signName, String signmail, String signID,String signBirth, String signBirth2,String signBirth3,String signPW){
          //member 클래스 에서 선언했던 함수
          member member = new member(gender_result,serviceId_result,signName,signmail,signID,signBirth,signBirth2,signBirth3,signPW);
          databaseReference.child("member").child(signmail).push().setValue(member); //member그룹으로 값 저장
        }






    }
