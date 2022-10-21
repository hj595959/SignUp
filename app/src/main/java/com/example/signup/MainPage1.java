package com.example.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainPage1 extends AppCompatActivity {

    private Spinner gender_spinner,location_spinner,home_care_spinner;
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
    }
}