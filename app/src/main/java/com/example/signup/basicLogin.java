package com.example.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class basicLogin extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText join_name , join_password , join_pwck , join_email;
    private Button check_button , delete , join_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();

        join_name = findViewById(R.id.join_name);
        join_password = findViewById(R.id.join_password);
        join_pwck = findViewById(R.id.join_pwck);
        join_email = findViewById(R.id.join_email);
        check_button = findViewById(R.id.check_button);
        delete = findViewById(R.id.delete);
        join_button = findViewById(R.id.join_button);

        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //회원가입 처리
              String s_join_name = join_name.getText().toString();
              String s_join_password = join_password.getText().toString();
              String s_join_pwck = join_pwck.getText().toString();
              String s_join_email = join_email.getText().toString();


            }
        });

    }
}