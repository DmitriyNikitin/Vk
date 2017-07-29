package com.example.vk;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class JsonHendler {

    public JsonHendler() {
    }

    public static ArrayList<UserInform> arrayInfoForList;
    private static final String TAG = "Error";
    public String jsonStr;



    public ArrayList<UserInform> decodeJSON() {

        HttpHandler sh = new HttpHandler();


        // Making a request to url and getting response
        jsonStr = sh.makeCall(CustomWebViewClient.JSON_response);
        arrayInfoForList = new ArrayList<>();
        if (jsonStr != null) {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject contact = jsonArray.getJSONObject(i);

                    String firstName = contact.getString("first_name");
                    String lastName = contact.getString("last_name");


                    UserInform friend = new UserInform();
                    friend.saveInfo(firstName, lastName);


                    arrayInfoForList.add(friend);

                }
                Log.d("", "");
            } catch (final JSONException e) {

            }


        }

        return arrayInfoForList;
    }
}

