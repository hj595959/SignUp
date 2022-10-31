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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private Button signupbutton;
    private EditText signName, signID, signmail, signBirth, signBirth2, signBirth3, signPW, phoneNb, signAddress;
    private RadioGroup gender, serviceId;
    private RadioButton male, female, patient, caregiver;
    private String gender_result, serviceId_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupbutton = findViewById(R.id.signupbutton);
        signName = findViewById(R.id.signName);
//        signmail = findViewById(R.id.signmail);
        signID = findViewById(R.id.signID);
//        signBirth = findViewById(R.id.signBirth);
//        signBirth2 = findViewById(R.id.signBirth2);
//        signBirth3 = findViewById(R.id.signBirth3);
        signPW = findViewById(R.id.signPW);
//        gender = findViewById(R.id.gender);
//        serviceId = findViewById(R.id.serviceId);
//        male = findViewById(R.id.male); // 남자
//        female = findViewById(R.id.female); //여자
//        patient = findViewById(R.id.patient); //환자
//        caregiver = findViewById(R.id.caregiver); //간병인
//        phoneNb = findViewById(R.id.phoneNb);
//        signAddress = findViewById(R.id.signAddress);
//
//        //성별 라디오 버튼 상태 값 담기
//        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (i == R.id.male) {
//                    gender_result = String.valueOf(male.getText());
//                } else if (i == R.id.female) {
//                    gender_result = String.valueOf(female.getText());
//                }
//            }
//        });
//        //간병인 인지 환자인지 버튼 값 담기
//        serviceId.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (i == R.id.patient) {
//                    serviceId_result = String.valueOf(patient.getText());
//                } else if (i == R.id.caregiver) {
//                    serviceId_result = String.valueOf(caregiver.getText());
//                }
//            }
//        });

        //회원가입 버튼
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //유효성 체크
//                if (signName.getText().toString().length() == 0) {
//                    Toast.makeText(getApplicationContext(), "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
//                    signName.requestFocus();
//                } else if (phoneNb.getText().toString().length() == 0) {
//                    Toast.makeText(getApplicationContext(), "전화번호를 입력하세요!", Toast.LENGTH_SHORT).show();
//                    phoneNb.requestFocus();
//                } else if (signAddress.getText().toString().length() == 0) {
//                    Toast.makeText(getApplicationContext(), "주소를 입력하세요!", Toast.LENGTH_SHORT).show();
//                    signAddress.requestFocus();
//                } else if (signmail.getText().toString().length() == 0) {
//                    Toast.makeText(getApplicationContext(), "메일을 입력하세요!", Toast.LENGTH_SHORT).show();
//                    signmail.requestFocus();
//                } else if (signID.getText().toString().length() == 0) {
//                    Toast.makeText(getApplicationContext(), "아이디를 입력하세요!", Toast.LENGTH_SHORT).show();
//                    signID.requestFocus();
//                } else if (signBirth.getText().toString().length() == 0) {
//                    Toast.makeText(getApplicationContext(), "년도를 입력하세요!", Toast.LENGTH_SHORT).show();
//                    signBirth.requestFocus();
//                } else if (signBirth2.getText().toString().length() == 0) {
//                    Toast.makeText(getApplicationContext(), "월을 입력하세요!", Toast.LENGTH_SHORT).show();
//                    signBirth2.requestFocus();
//                } else if (signBirth3.getText().toString().length() == 0) {
//                    Toast.makeText(getApplicationContext(), "일을 입력하세요!", Toast.LENGTH_SHORT).show();
//                    signBirth3.requestFocus();
//                } else {
//                    //값을 텍스트로 변환후 함수 선언
                    String userID = signID.getText().toString();
                    String userName = signName.getText().toString();
                    String userPassword = signPW.getText().toString();
//

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if (success) {
                                    Toast.makeText(getApplicationContext(), "회원등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, activity_mkd3.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "회원등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                        RegisterRequest registerRequest = new RegisterRequest(userID, userName, userPassword, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                        queue.add(registerRequest);


                        }


                });




    }
}






