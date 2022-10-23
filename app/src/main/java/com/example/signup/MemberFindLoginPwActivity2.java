package com.example.signup;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MemberFindLoginPwActivity2 extends AppCompatActivity {

    private EditText signID,signmail;
    private Button buttonDoFindLoginPw, buttonCancel, emailcheck;
    private DatabaseReference databaseReference;
    //데이터 받아올 member 클래스의 리스트 생성
    member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_find_login_pw2);

        databaseReference = FirebaseDatabase.getInstance().getReference("member");

        signID = findViewById(R.id.signID);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonDoFindLoginPw = findViewById(R.id.buttonDoFindLoginPw);
        emailcheck = findViewById(R.id.emailcheck);
        signmail = findViewById(R.id.signmail);




        buttonDoFindLoginPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query myQuery = databaseReference.orderByChild("signID").equalTo(signID.getText().toString());


                myQuery.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        member = new member();
                        for(DataSnapshot datasnapshot : snapshot.getChildren()){
                            member memberadd = datasnapshot.getValue(member.class);
                            member.setSignPW(memberadd.getSignPW());






                            Toast.makeText(getApplicationContext(),"회원님의 비밀번호는 :"  + member.getSignPW() + "입니다.", Toast.LENGTH_LONG).show();
                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            };

        });

        //뒤로가기 버튼
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemberFindLoginPwActivity2.this, account.class);
                startActivity(intent);

            }
        });

        emailcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query query1 = databaseReference.orderByChild("signmail").equalTo(signmail.getText().toString());

                query1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        member = new member();
                        for (DataSnapshot dataSnapshot:snapshot.getChildren()) {
                            member memberadd = dataSnapshot.getValue(member.class);
                            buttonDoFindLoginPw.setEnabled(true);
                            buttonDoFindLoginPw.setVisibility(View.VISIBLE);
                            //버튼 활성호ㅏ
                            }


                        }





                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}

