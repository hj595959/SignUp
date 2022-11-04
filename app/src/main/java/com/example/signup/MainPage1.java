package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainPage1 extends AppCompatActivity {

    public Spinner gender_spinner,location_spinner,home_care_spinner;
    private ImageButton bottomMyPageBtn, bottomBackBtn;
    private Button info3_button,info4_button , find_matching ,choiceBtn1 ,choiceBtn2;
    private long backKeyPressedTime = 0;
    private Toast toast;
    private TextView cardName , cardGender , cardLocation,cardDate,cardCareer,cardLicense,cardID;
    private static final String TAG_JSON = "result";
    private static final String json_userID = "userID";
    private static final String json_userName = "userName";
    private static final String json_userGender = "userGender";
    private static final String json_lovation_work = "lovation_work";
    private static final String json_Ucareer = "Ucareer";
    private static final String json_Ulicense = "Ulicense";
    private static final String json_uWorkTime = "uWorkTime";
    int count = 0;

    ArrayList<String> gender_list,location_list,home_care_list;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page1);

        member member = new member();
        ArrayList<matchingDTO> matchList = new ArrayList<matchingDTO>();
        caregiver caregiver = new caregiver();
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userServiceID = intent.getStringExtra("userServiceID");

        info3_button = findViewById(R.id.info3_button);
        info4_button = findViewById(R.id.info4_button);
        choiceBtn1 = findViewById(R.id.choiceBtn1);
        choiceBtn2 = findViewById(R.id.choiceBtn2);
        cardName = findViewById(R.id.cardName);
        cardGender = findViewById(R.id.cardGender);
        cardLocation = findViewById(R.id.cardLocation);
        cardDate = findViewById(R.id.cardDate);
        cardCareer =  findViewById(R.id.cardCareer);
        cardLicense = findViewById(R.id.cardLicense);
        cardID = findViewById(R.id.cardID);


        if(userServiceID.equals("간병인")){
            info4_button.setVisibility(View.GONE);
        }else if(userServiceID.equals("환자")){
            info3_button.setVisibility(View.GONE);
        }

        info3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage1.this,user_info2.class);
                intent.putExtra("userID",userID);
                intent.putExtra("userServiceID",userServiceID);
                startActivity(intent);

            }
        });

        info4_button.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainPage1.this,user_info.class);
               intent.putExtra("userID",userID);
               intent.putExtra("userServiceID",userServiceID);
               startActivity(intent);
            }
        });


        gender_list = new ArrayList<>();
        gender_list.add("남성");
        gender_list.add("여성");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                gender_list);
        gender_spinner = (Spinner) findViewById(R.id.gender_spinner);
        gender_spinner.setAdapter(arrayAdapter);
        gender_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String gender = gender_spinner.getSelectedItem().toString();
                member.setGender(gender);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        location_list = new ArrayList<>();
        location_list.add("인천시");
        location_list.add("경기시");
        location_list.add("서울시");
        location_list.add("전북시");
        location_list.add("전남시");
        location_list.add("충남시");
        location_list.add("충북시");
        location_list.add("제주시");
        location_list.add("부산시");
        location_list.add("대구시");
        location_list.add("대전시");
        location_list.add("울산시");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                location_list);
        location_spinner = (Spinner) findViewById(R.id.location_spinner);
        location_spinner.setAdapter(arrayAdapter);
        location_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 String location = location_spinner.getSelectedItem().toString();
                member.setSignAddress(location);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        home_care_list = new ArrayList<>();
        home_care_list.add("재택 간병");
        home_care_list.add("병원 간병");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                home_care_list);
        home_care_spinner = (Spinner) findViewById(R.id.home_care_spinner);
        home_care_spinner.setAdapter(arrayAdapter);
        home_care_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()



        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String home_care = home_care_spinner.getSelectedItem().toString();
                caregiver.setLocation_work(home_care);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        bottomMyPageBtn=findViewById(R.id.bottomMyPageBtn);
        bottomMyPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage1.this, Mypage.class);
                startActivity(intent);
            }
        });


        bottomBackBtn=findViewById(R.id.bottomBackBtn);
        bottomBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
                    backKeyPressedTime = System.currentTimeMillis();
                    Toast.makeText(getApplicationContext(),"한번 더 누르면 종료됩니다.", Toast.LENGTH_LONG).show();
                    return;
                }
                // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
                // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지나지 않았으면 종료
                if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
                    finishAffinity();
                    System.exit(0);
                    Toast.makeText(getApplicationContext(),"이용해주셔서 감사합니다.", Toast.LENGTH_LONG).show();

            }}
        });


        find_matching = findViewById(R.id.find_matching);
        find_matching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                 String gender = member.getGender();
                 String location = member.getSignAddress();
                 String location_work  = caregiver.getLocation_work();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String result) {
                        try{
                            JSONObject jsonObject = new JSONObject(result);
                            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
                            matchList.clear();
                            Log.v("count jsonArray",String.valueOf(jsonArray.length()));
                            for(int i =0; i<jsonArray.length(); i++){
                                JSONObject item = jsonArray.getJSONObject(i);

                                String userID = item.getString(json_userID);
                                String userName = item.getString(json_userName);
                                String userGender = item.getString(json_userGender);
                                String lovation_work = item.getString(json_lovation_work);
                                String Ucareer = item.getString(json_Ucareer);
                                String Ulicense = item.getString(json_Ulicense);
                                String uWorkTime = item.getString(json_uWorkTime);

                                matchingDTO matchingDTO = new matchingDTO();
                                matchingDTO.setUserID(userID);
                                matchingDTO.setUserName(userName);
                                matchingDTO.setUserGender(userGender);
                                matchingDTO.setLovation_work(lovation_work);
                                matchingDTO.setUcareer(Ucareer);
                                matchingDTO.setUlicense(Ulicense);
                                matchingDTO.setUworkTime(uWorkTime);
                                matchList.add(matchingDTO);
                               Log.v("count userID",matchList.get(i).getUserID());
                            }

                        }catch(Exception e){
                           e.printStackTrace();
                        }
                        if( matchList.size() > 0){
                            cardName.setText(matchList.get(count).getUserName());
                            cardGender.setText(matchList.get(count).getUserGender());
                            cardLocation.setText(matchList.get(count).getLovation_work());
                            cardDate.setText(matchList.get(count).getUworkTime());
                            cardCareer.setText(matchList.get(count).getUcareer());
                            cardLicense.setText(matchList.get(count).getUlicense());
                            cardID.setText(matchList.get(count).getUserID());
                        }else{
                            Toast.makeText(getApplicationContext(),"조건에 맞는 간병인이 없습니다.", Toast.LENGTH_LONG).show();
                        }

                    }

                };

                matchingList matchingList = new matchingList(gender,location,location_work,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainPage1.this);
                queue.add(matchingList);

            }
        });

        choiceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if(count == matchList.size()) {

                    Toast.makeText(getApplicationContext(),"마지막페이지입니다.", Toast.LENGTH_LONG).show();
                    count--;
                }else{
                    cardName.setText(matchList.get(count).getUserName());
                    cardGender.setText(matchList.get(count).getUserGender());
                    cardLocation.setText(matchList.get(count).getLovation_work());
                    cardDate.setText(matchList.get(count).getUworkTime());
                    cardCareer.setText(matchList.get(count).getUcareer());
                    cardLicense.setText(matchList.get(count).getUlicense());
                    cardID.setText(matchList.get(count).getUserID());
                }
            }
        });

        choiceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                if(count >=  0) {
                    cardName.setText(matchList.get(count).getUserName());
                    cardGender.setText(matchList.get(count).getUserGender());
                    cardLocation.setText(matchList.get(count).getLovation_work());
                    cardDate.setText(matchList.get(count).getUworkTime());
                    cardCareer.setText(matchList.get(count).getUcareer());
                    cardLicense.setText(matchList.get(count).getUlicense());
                    cardID.setText(matchList.get(count).getUserID());
                }else{
                    Toast.makeText(getApplicationContext()," 처음페이지입니다.", Toast.LENGTH_LONG).show();
                    count = 0;
                }
            }
        });


    }
}
