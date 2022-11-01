package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class activity_mkd3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkd3);
        final EditText signID = findViewById(R.id.signID);
        final EditText signPW = findViewById(R.id.signPW);
        final Button signUpBtn = findViewById(R.id.signUpBtn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userID = signID.getText().toString();
                final String userPassword = signPW.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String userID = jsonResponse.getString("userID");
                                String userPassword = jsonResponse.getString("userPassword");

                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(activity_mkd3.this, MainPage1.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPassword", userPassword);
                                activity_mkd3.this.startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(activity_mkd3.this);
                queue.add(loginRequest);

            }

        });

    }
}









