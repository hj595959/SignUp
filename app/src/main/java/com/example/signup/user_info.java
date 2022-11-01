//package com.example.signup;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class user_info extends AppCompatActivity {
//
//    private EditText diseaseName, time, note;
//    private RadioGroup location_check, dementia_check, info_rateing;
//    private RadioButton hospital_care, home_care, dimentia_yes, dimentia_no, rating1, rating2, rating3, rating4, rating5, rating6;
//    private Button checkButton1;
//    private FirebaseDatabase database = FirebaseDatabase.getInstance();
//    private DatabaseReference databaseReference = database.getReference();
//    private String location_check_result,dementia_check_result , info_rateing_result;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_info);
//
//
//        //전달할 데이터 받을 intent 선언
//        Intent intent = getIntent();
//
//        diseaseName = findViewById(R.id.diseaseName);
//        time = findViewById(R.id.time);
//        note = findViewById(R.id.note);
//        location_check = findViewById(R.id.location_check);
//        dementia_check = findViewById(R.id.dementia_check);
//        info_rateing = findViewById(R.id.info_rateing);
//        hospital_care = findViewById(R.id.hospital_care);
//        home_care = findViewById(R.id.home_care);
//        dimentia_yes = findViewById(R.id.dimentia_yes);
//        dimentia_no = findViewById(R.id.dimentia_no);
//        rating1 = findViewById(R.id.rating1);
//        rating2 = findViewById(R.id.rating2);
//        rating3 = findViewById(R.id.rating3);
//        rating4 = findViewById(R.id.rating4);
//        rating5 = findViewById(R.id.rating5);
//        rating6 = findViewById(R.id.rating6);
//        checkButton1 = findViewById(R.id.checkButton1);
//
//        //String 형식으로 전달받을 sigID 저장
//        String signID = intent.getStringExtra("signID");
//
//        location_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//                if (i == R.id.home_care) {
//                    location_check_result = String.valueOf(home_care.getText());
//                } else if (i == R.id.hospital_care) {
//                    location_check_result = String.valueOf(hospital_care.getText());
//                }
//            }
//        });
//
//        dementia_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//                if (i == R.id.dimentia_yes) {
//                    dementia_check_result = String.valueOf(dimentia_yes.getText());
//                } else if (i == R.id.dimentia_no) {
//                    dementia_check_result = String.valueOf(dimentia_no.getText());
//                }
//            }
//        });
//
//        info_rateing.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//                if (i == R.id.rating1) {
//                    info_rateing_result = String.valueOf(rating1.getText());
//                } else if (i == R.id.rating2) {
//                    info_rateing_result = String.valueOf(rating2.getText());
//                } else if (i == R.id.rating3) {
//                    info_rateing_result = String.valueOf(rating3.getText());
//                } else if (i == R.id.rating4) {
//                    info_rateing_result = String.valueOf(rating4.getText());
//                } else if (i == R.id.rating5) {
//                    info_rateing_result = String.valueOf(rating5.getText());
//                } else if (i == R.id.rating6) {
//                    info_rateing_result = String.valueOf(rating6.getText());
//                }
//            }
//        });
//
//       //등록 버튼 클릭시
//        checkButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addmeminfo(signID,diseaseName.getText().toString(),time.getText().toString(),note.getText().toString(),location_check_result,dementia_check_result,info_rateing_result);
//                Toast.makeText(getApplicationContext(), "환자 등록 에 성공했습니다!", Toast.LENGTH_LONG).show();
//                checkButton1.setEnabled(false); //버튼 비활성화
//                //Intent intent = new Intent(user_info.this, MainPage1.class);
//                //startActivity(intent);
//            }
//        });
//    }
//
//
//
//    public void addmeminfo(String signID,String diseaseName, String time, String note, String location_check_result, String dementia_check_result, String info_rateing_result) {
//        meminfo meminfo = new meminfo(signID,diseaseName, time, note, location_check_result, dementia_check_result, info_rateing_result);
//        databaseReference.child("patient").push().setValue(meminfo);
//    }
//}
//
