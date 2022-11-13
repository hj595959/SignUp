package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class loginMyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_my_page);

        //선언
        TextView loginMyPageNameTv = findViewById(R.id.loginMyPageNameTv);
        TextView loginMyPageWhatTv = findViewById(R.id.loginMyPageWhatTv);
        TextView loginMyPageIDTv = findViewById(R.id.loginMyPageIDTv);
        TextView loginMyPageEmailTv = findViewById(R.id.loginMyPageEmailTv);
        TextView loginMyPagePWTv = findViewById(R.id.loginMyPagePWTv);
        TextView loginMyPageBirth1Tv = findViewById(R.id.loginMyPageBirth1Tv);
        TextView loginMyPageBirth2Tv = findViewById(R.id.loginMyPageBirth2Tv);
        TextView loginMyPageBirth3Tv = findViewById(R.id.loginMyPageBirth3Tv);
        TextView loginMyPageAddressTv = findViewById(R.id.loginMyPageAddressTv);
        TextView loginMyPagePhoneNBTv = findViewById(R.id.loginMyPagePhoneNBTv);
        Button loginMyPageCheck = findViewById(R.id.loginMyPageCheck);

        //가져오기
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userServiceID = intent.getStringExtra("userServiceID");

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        String userID_result = jsonResponse.getString("userID");
                        String userPassword_result = jsonResponse.getString("userPassword");
                        String userName_result = jsonResponse.getString("userName");
                        String userMail_result = jsonResponse.getString("userMail");
                        String userBirthday_result = jsonResponse.getString("userBirthday");
                        String userBirthday2_result = jsonResponse.getString("userBirthday2");
                        String userBirthday3_result = jsonResponse.getString("userBirthday3");
                        String userGender_result = jsonResponse.getString("userGender");
                        String userServiceID_result = jsonResponse.getString("userServiceID");
                        String userPhoneNB_result = jsonResponse.getString("userPhoneNB");
                        String userAddress_result = jsonResponse.getString("userAddress");

                        loginMyPageNameTv.setText(userName_result);
                        loginMyPageWhatTv.setText(userServiceID_result);
                        loginMyPageIDTv.setText(userID_result);
                        loginMyPageEmailTv.setText(userMail_result);
                        loginMyPagePWTv.setText(userPassword_result);
                        loginMyPageBirth1Tv.setText(userBirthday_result);
                        loginMyPageBirth2Tv.setText(userBirthday2_result);
                        loginMyPageBirth3Tv.setText(userBirthday3_result);
                        loginMyPageAddressTv.setText(userAddress_result);
                        loginMyPagePhoneNBTv.setText("0"+userPhoneNB_result);
                    } else {
                        Toast.makeText(getApplicationContext(), "정보를 찾을수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        mypageList mypageList = new mypageList(userID, userServiceID, responseListener);
        RequestQueue queue = Volley.newRequestQueue(loginMyPage.this);
        queue.add(mypageList);



    }
}