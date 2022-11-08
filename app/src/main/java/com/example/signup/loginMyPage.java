package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        String userName = intent.getStringExtra("userName");
        String userPW =intent.getStringExtra("userPW");

        String userBirthday = intent.getStringExtra("userBirthday");
        String userBirthday2 = intent.getStringExtra("userBirthday2");
        String userBirthday3 = intent.getStringExtra("userBirthday3");
        String userMail = intent.getStringExtra("userMail");
        String userAddress = intent.getStringExtra("userAddress");
        String userPhoneNB = intent.getStringExtra("userPhoneNB");







        //넣기

        loginMyPageIDTv.setText(userID);
        loginMyPageWhatTv.setText(userServiceID);
        loginMyPageNameTv.setText(userName);
        loginMyPageEmailTv.setText(userMail);
        loginMyPagePWTv.setText(userPW);
        loginMyPageBirth1Tv.setText(userBirthday);
        loginMyPageBirth2Tv.setText(userBirthday2);
        loginMyPageBirth3Tv.setText(userBirthday3);
        loginMyPageAddressTv.setText(userAddress);
        loginMyPagePhoneNBTv.setText("0"+userPhoneNB);


        loginMyPageCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                StringRequest request = new StringRequest(Request.Method.POST, "http://favor531.ivyro.net/loginmypage.php",
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Toast.makeText(loginMyPage.this, response, Toast.LENGTH_SHORT).show();
//
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(loginMyPage.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                }){
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String,String> params = new HashMap<>();
//                        String tvID = loginMyPageIDTv.getText().toString();
//
//
//
//
//                        params.put("userID",tvID);
//                        params.put("userServiceID", userServiceID);
//                        params.put("userName", userName);
//                        params.put("userMail", userMail);
//                        params.put("userPW", userPW);
//                        params.put("userBirthday", userBirthday);
//                        params.put("userBirthday2", userBirthday2);
//                        params.put("userBirthday3", userBirthday3);
//                        params.put("userAddress", userAddress);
//                        params.put("userPhoneNB", userPhoneNB);
//
//                        return super.getParams();
//                    }
//                };
//
//                RequestQueue requestQueue = Volley.newRequestQueue(loginMyPage.this);
//                requestQueue.add(request);


                finish();

            }
        });
    }
}