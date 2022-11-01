//package com.example.signup;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;
//
//public class MemberFindLoginIdActivity2 extends AppCompatActivity {
//
//    private EditText signmail;
//    private Button buttonDoFindLoginId,backBtn;
//    private DatabaseReference databaseReference;
//    //데이터 받아올 member 클래스의 리스트 생성
//    member member;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_member_find_login_id2);
//
//        databaseReference = FirebaseDatabase.getInstance().getReference("member");
//
//        signmail  = findViewById(R.id.signmail);
//        buttonDoFindLoginId = findViewById(R.id.buttonDoFindLoginId);
//        backBtn = findViewById(R.id.backBtn);
//
//
//        buttonDoFindLoginId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Query myQuery = databaseReference.orderByChild("signmail").equalTo(signmail.getText().toString());
//                myQuery.addValueEventListener(new ValueEventListener() {
//
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        member = new member();
//                        for(DataSnapshot datasnapshot : snapshot.getChildren()){
//                            member memberadd = datasnapshot.getValue(member.class);
//                            member.setSignID(memberadd.getSignID());
//                            Toast.makeText(getApplicationContext(),"회원님의 아이디는 :"  + member.getSignID() + " 입니다.", Toast.LENGTH_LONG).show();
//                        }
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//            };
//         });
//
//        //뒤로가기 버튼
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MemberFindLoginIdActivity2.this, account.class);
//                startActivity(intent);
//            }
//        });
//
//   }
//}