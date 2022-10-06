package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class finderidActivity2 extends AppCompatActivity {
    private EditText editTextLoginId;
    private EditText editTextLoginPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finderid2);

        setTitle("회원로그인");

        editTextLoginId = findViewById(R.id.editTextLoginId);
        editTextLoginPasswd = findViewById(R.id.editTextLoginPasswd);

        findViewById(R.id.buttonDoLogin).setOnClickListener(view -> {
            startActivity(new Intent());
        });



    }
    private void doLogin() {
        String loginId = editTextLoginId.getText().toString().trim();
        String loginPasswd = editTextLoginPasswd.getText().toString().trim();

        if (loginId.length() == 0) {
            Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
            editTextLoginId.requestFocus();

            return;

        }

            if (loginPasswd.length() == 0) {
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                editTextLoginPasswd.requestFocus();

                return;

            }

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            
    }

}