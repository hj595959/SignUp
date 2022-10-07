package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class account extends AppCompatActivity {

private ImageButton imageButton4,imageButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        imageButton4=findViewById(R.id.imageButton4);
        imageButton6=findViewById(R.id.imageButton6);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account.this, activity_mkd3.class);
                startActivity(intent);
            }
        });

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}