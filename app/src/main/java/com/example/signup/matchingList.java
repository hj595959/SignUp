package com.example.signup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class matchingList extends StringRequest {

    final static private String URL = "http://favor531.ivyro.net/matchingList.php";
    private Map<String, String> map;

    public matchingList(String gender,String location,String location_work,Response.Listener<String> listener)
    {
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userGender",gender);
        map.put("userAddress", location);
        map.put("lovation_work", location_work);

    }

    @Override
    protected Map<String, String> getParams()
    {

        return map;
    }
}
