package com.example.signup;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//로그인 기능 담당 클래스
public class LoginRepsoitory {

    // 로그인 성공 , 실패
    interface Listener{
        void onLoginSuccess(member member); //로그인 성공시
        void onLoginFailure(DatabaseError error);//로그인 실패시
    }
    // 테이블명 , 컬럼 값 명시
    private static final String TABLE_NAME = "member";
    private static final String Id_NAME = "signID";
    // private static final String Mail_NAME = "signmail"; 메일 대신 id로 바꿈
    private static final String PASSWORD_NAME = "signPW";

    //DatabaseReference,Listener 선언
    private final DatabaseReference dbRef;
    private Listener listener;

    //LoginResoitory 에 데이터 베이스 실행 코드 담기
    public LoginRepsoitory(){
        this.dbRef = FirebaseDatabase.getInstance().getReference();
    }
    //Listener 담을 공간 선언
    public void setListener(Listener listener){
        this.listener = listener;
    }

    //로그인 기능
    public void login(String Id, String PW){
        dbRef.child(TABLE_NAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              //실제로 로그인 기능 실행할 함수 선언
              MemberFetched(snapshot.getChildren(), Id , PW);
            }
            //로그인 기능 실패시 실행되는 부분
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
              if(listener != null) listener.onLoginFailure(error);
            }
        });
    }
    //로그인 기능 함수
    private void MemberFetched(Iterable<DataSnapshot> snapshots,String Id,String PW){
        //member 클래스 선언 및 초기화
        member loggeedInUser = null;
        //signId , signPW 가져오는 부분
        for(DataSnapshot snapshot : snapshots){
            String signID = snapshot.child(Id_NAME).getValue() + "";
            String signPW = snapshot.child(PASSWORD_NAME).getValue() + "";
            //sigId , signPW 이랑 데이터베이스에 저장된 값이 일치한지 비교
            if(signID.equals(Id) && signPW.equals(PW)){
                //비교후 member 클래스 선언한 곳에 저장
                loggeedInUser = snapshot.getValue(member.class);
                break;
            }
        }
        // 값이 들어있지않을시 (로그인 실패)
        if(loggeedInUser == null){
            if(listener != null) listener.onLoginFailure(null);
            return;
        }
        // 값이 들어있을시 (로그인성공)
        if(listener != null) listener.onLoginSuccess(loggeedInUser);
    }
}
