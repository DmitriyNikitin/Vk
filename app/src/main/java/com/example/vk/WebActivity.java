package com.example.vk;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WebActivity extends AppCompatActivity {

    public  final String host_authorize = "https://oauth.vk.com/authorize",
            client_id = "client_id=6043385",
            display = "display=mobile",
            redirect_uri = "redirect_uri=https://oauth.vk.com/blank.html",
            scope = "scope=friends,offline",
            response_type = "response_type=token",
            version = "v=5.65",
            revoke = "revoke=1";

     public ListView listView;
     public static ArrayList<UserInform> userInform;
     public static Context context;
     public static  MakeList makeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        context = this;


        WebView webView = (WebView)findViewById(R.id.web);
        webView.setWebViewClient(new CustomWebViewClient());

        listView = (ListView)findViewById(R.id.list);

        String authorize = host_authorize + "?" + client_id + "&" + display + "&" + redirect_uri + "&" + scope + "&" + response_type + "&" + version + "&" + revoke;

           webView.loadUrl(authorize);

        userInform = new ArrayList<UserInform>();


        makeList = new MakeList(context, listView);
        Log.d("","");



    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }





}
