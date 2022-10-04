package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button pwcheck;
    private EditText pw, pw2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //뒤로 가기 버튼
        Button back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, account.class);
            startActivity(intent);
        });



        //비밀번호 확인 버튼
        pwcheck = findViewById(R.id.pwcheckbutton);
        pwcheck.setOnClickListener(v -> {
            if(pw.getText().toString().equals(pw2.getText().toString())){
                pwcheck.setText("일치");
            }else{
                Toast.makeText(this,"비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });

    }





    }
