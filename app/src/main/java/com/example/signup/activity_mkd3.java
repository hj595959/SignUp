package com.example.signup;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseError;

public class activity_mkd3 extends AppCompatActivity implements LoginRepsoitory.Listener {

    private LoginRepsoitory loginRepository;
    //입력값 받아오기
    private EditText signPW , signmail;
    private Button signUpBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkd3);
        //loginRepository 실행할 함수 선언
        injectDependencies();
        //findViewById 실행할 함수 선언
        bindView();
    }
    @Override
    protected  void onStart(){
        super.onStart();
        loginRepository.setListener(this);
    }
    @Override
    protected void onStop(){
        super.onStop();
        loginRepository.setListener(null);
    }
    private void injectDependencies(){
        loginRepository = new LoginRepsoitory();
    }

    private void bindView(){
        signmail = findViewById(R.id.signmail);
        signPW = findViewById(R.id.signPW);
        signUpBtn = findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(v -> {
            //로그인 버튼 클릭시 수행될 함수 선언
           submitLogin();
        });
    }
    private void submitLogin(){
        //loginReository에 입력된 메일 , 비번 보내기
        loginRepository.login(signmail.getText().toString() , signPW.getText().toString());
    }

    //로그인 성공 처리
    @Override
    public void onLoginSuccess(member member) {
        Toast.makeText(getApplicationContext(), "로그인에 성공했습니다! " +member.getSignName() + "님 환영합니다.", Toast.LENGTH_LONG).show();

        //버튼 비활성화
        signUpBtn.setEnabled(false);
        //로그인한 아이디가 환자 인지 간병인인지 구별
        if(member.getServiceId().equals("환자")){

        }else if(member.getServiceId().equals("간병인")){

        }
    }


    //로그인 실패 처리
    @Override
    public void onLoginFailure(DatabaseError error) {
      if(error != null){
          Toast.makeText(getApplicationContext(), "로그인 실패 했습니다!", Toast.LENGTH_LONG).show();

          return;
      }
        Toast.makeText(getApplicationContext(), "로그인 실패 했습니다!", Toast.LENGTH_LONG).show();
    }
}