package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user_info extends AppCompatActivity {

    private EditText diseaseName, time, note;
    private RadioGroup location_check, dementia_check, info_rateing;
    private RadioButton hospital_care, home_care, dimentia_yes, dimentia_no, rating1, rating2, rating3, rating4, rating5, rating6;
    private Button checkButton, checkButton1;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);


        //전달할 데이터 받을 intent 선언
        Intent intent = getIntent();

        diseaseName = findViewById(R.id.diseaseName);
        time = findViewById(R.id.time);
        note = findViewById(R.id.note);
        location_check = findViewById(R.id.location_check);
        dementia_check = findViewById(R.id.dementia_check);
        info_rateing = findViewById(R.id.info_rateing);
        hospital_care = findViewById(R.id.hospital_care);
        home_care = findViewById(R.id.home_care);
        dimentia_yes = findViewById(R.id.dimentia_yes);
        dimentia_no = findViewById(R.id.dimentia_no);
        rating1 = findViewById(R.id.rating1);
        rating2 = findViewById(R.id.rating2);
        rating3 = findViewById(R.id.rating3);
        rating4 = findViewById(R.id.rating4);
        rating5 = findViewById(R.id.rating5);
        rating6 = findViewById(R.id.rating6);
        checkButton = findViewById(R.id.checkButton);
        checkButton1 = findViewById(R.id.checkButton1);

        //String 형식으로 전달받을 signmail 저장
        String signID = intent.getStringExtra("signID");

        location_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String location_check_result;
                if (i == R.id.home_care) {
                    location_check_result = String.valueOf(home_care.getText());
                } else if (i == R.id.hospital_care) {
                    location_check_result = String.valueOf(hospital_care.getText());
                }
            }
        });

        dementia_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String dementia_check_result;
                if (i == R.id.dimentia_yes) {
                    dementia_check_result = String.valueOf(dimentia_yes.getText());
                } else if (i == R.id.dimentia_no) {
                    dementia_check_result = String.valueOf(dimentia_no.getText());
                }
            }
        });

        info_rateing.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String info_rateing_result;
                if (i == R.id.rating1) {
                    info_rateing_result = String.valueOf(rating1.getText());
                } else if (i == R.id.rating2) {
                    info_rateing_result = String.valueOf(rating2.getText());
                } else if (i == R.id.rating3) {
                    info_rateing_result = String.valueOf(rating3.getText());
                } else if (i == R.id.rating4) {
                    info_rateing_result = String.valueOf(rating4.getText());
                } else if (i == R.id.rating5) {
                    info_rateing_result = String.valueOf(rating5.getText());
                } else if (i == R.id.rating6) {
                    info_rateing_result = String.valueOf(rating6.getText());
                }
            }
        });


        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭시 작동되는 코드


            }
        });
    }

    public void addmeminfo(String diseaseName, String time, String note, String location_check, String dementia_check, String info_rateing) {
        meminfo meminfo = new meminfo(diseaseName, time, note, location_check, dementia_check, info_rateing);
        databaseReference.child("meminfo").push().setValue(meminfo);
    }
}

