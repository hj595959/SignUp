package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Mkd2Activity extends AppCompatActivity {

    private Button choiceBtn2 ,choiceBtn1 ,matching_choice;
    private TextView cardName , cardDate , cardLocation, cardDetail ,receive_ID1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkd2);

        ArrayList<mypageMatchDTO> mypageMatchList = new ArrayList<mypageMatchDTO>();
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userServiceID = intent.getStringExtra("userServiceID");


    }
}