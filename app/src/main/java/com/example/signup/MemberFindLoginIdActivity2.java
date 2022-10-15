package com.example.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MemberFindLoginIdActivity2 extends AppCompatActivity {

    private EditText editTextEmaill;
    private Button buttonDoFindLoginId,backBtn;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_find_login_id2);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        editTextEmaill.findViewById(R.id.editTextEmaill);
        buttonDoFindLoginId.findViewById(R.id.buttonDoFindLoginId);
        backBtn.findViewById(R.id.backBtn);


        buttonDoFindLoginId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            };
         });

        //뒤로가기 버튼
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

   }
}