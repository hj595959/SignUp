package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user_info extends AppCompatActivity {

    private Button checkButton;
    private EditText nameEditText, emailEditText, birthDayEditText, phone, addressEditText, rating, note ;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        checkButton = findViewById(R.id.checkButton);
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        birthDayEditText = findViewById(R.id.birthDayEditText);
        phone = findViewById(R.id.phone);
        addressEditText = findViewById(R.id.addressEditText);
        rating = findViewById(R.id.rating);
        note = findViewById(R.id.note);

        //전달할 데이터 받을 intent 선언
        Intent intent=  getIntent();
        //String 형식으로 전달받을 signmail 저장
        String signmail = intent.getStringExtra("signmail");

        //전달되는지 테스트 (나중에 지울거임)
        TextView emailEditText = findViewById(R.id.emailEditText);
        emailEditText.setText(signmail);
    }
}