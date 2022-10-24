package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainPage1 extends AppCompatActivity {

    private Spinner gender_spinner,location_spinner,home_care_spinner;
    private ImageButton bottomMyPageBtn, bottomBackBtn;
    private long backKeyPressedTime = 0;
    private Toast toast;

    ArrayList<String> gender_list,location_list,home_care_list;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page1);

        gender_list = new ArrayList<>();
        gender_list.add("선택없음");
        gender_list.add("남자");
        gender_list.add("여자");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                gender_list);
        gender_spinner = (Spinner) findViewById(R.id.gender_spinner);
        gender_spinner.setAdapter(arrayAdapter);
        gender_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        location_list = new ArrayList<>();
        location_list.add("선택 없음");
        location_list.add("인천");
        location_list.add("경기");
        location_list.add("서울");
        location_list.add("전북");
        location_list.add("전남");
        location_list.add("충남");
        location_list.add("충북");
        location_list.add("제주");
        location_list.add("부산");
        location_list.add("대구");
        location_list.add("대전");
        location_list.add("울산");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                location_list);
        location_spinner = (Spinner) findViewById(R.id.location_spinner);
        location_spinner.setAdapter(arrayAdapter);
        location_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        home_care_list = new ArrayList<>();
        home_care_list.add("선택없음");
        home_care_list.add("재택 간병");
        home_care_list.add("병원 간병");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                home_care_list);
        home_care_spinner = (Spinner) findViewById(R.id.home_care_spinner);
        home_care_spinner.setAdapter(arrayAdapter);
        home_care_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()



        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        bottomMyPageBtn=findViewById(R.id.bottomMyPageBtn);
        bottomMyPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage1.this, Mypage.class);
                startActivity(intent);
            }
        });


        bottomBackBtn=findViewById(R.id.bottomBackBtn);
        bottomBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
                    backKeyPressedTime = System.currentTimeMillis();
                    Toast.makeText(getApplicationContext(),"한번 더 누르면 종료됩니다.", Toast.LENGTH_LONG).show();
                    return;
                }
                // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
                // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지나지 않았으면 종료
                if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
                    finishAffinity();
                    System.exit(0);
                    Toast.makeText(getApplicationContext(),"이용해주셔서 감사합니다.", Toast.LENGTH_LONG).show();

                    //조조조조

            }}
        });
    }
}
