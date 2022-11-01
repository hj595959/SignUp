
package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


public class user_info2 extends AppCompatActivity {

    private EditText career, workTime, license;
    private RadioGroup location_working, info2_rating;
    private RadioButton home_work, hospital_work, info2_1rating, info2_2rating, info2_3rating, info2_4rating, info2_5rating, info2_6rating;
    private Button checkButton3;
    private String signID, location_working_result, info2_rating_result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info2);

        //전달할 데이터 받을 intent 선언
        Intent intent=  getIntent();

        career = findViewById(R.id.career);
        workTime = findViewById(R.id.workTime);
        license = findViewById(R.id.license);
        location_working = findViewById(R.id.location_working);
        home_work = findViewById(R.id.home_work);
       hospital_work = findViewById(R.id.hospital_work);
        info2_rating = findViewById(R.id.info2_rating);
        info2_1rating = findViewById(R.id.info2_1rating);
        info2_2rating = findViewById(R.id.info2_2rating);
        info2_3rating = findViewById(R.id.info2_3rating);
        info2_4rating = findViewById(R.id.info2_4rating);
        info2_5rating = findViewById(R.id.info2_5rating);
        info2_6rating = findViewById(R.id.info2_6rating);
        checkButton3 = findViewById(R.id.checkButton3);

        //String 형식으로 전달받을 signID 저장
        signID = intent.getStringExtra("signID");

        location_working.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.home_work){
                    location_working_result = String.valueOf(home_work.getText());
                }else if(i == R.id.hospital_work){
                    location_working_result = String.valueOf(hospital_work.getText());
                }
            }
        });

        info2_rating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.info2_1rating){
                    info2_rating_result = String.valueOf(info2_1rating.getText());
                }else if(i == R.id.info2_2rating){
                   info2_rating_result = String.valueOf(info2_2rating.getText());
                }else if(i == R.id.info2_3rating){
                    info2_rating_result = String.valueOf(info2_3rating.getText());
                }
                else if(i == R.id.info2_4rating){
                    info2_rating_result = String.valueOf(info2_4rating.getText());
                }
                else if(i == R.id.info2_5rating){
                    info2_rating_result = String.valueOf(info2_5rating.getText());
                }
                else if(i == R.id.info2_6rating){
                    info2_rating_result = String.valueOf(info2_6rating.getText());
                }
            }
        });


    }

}