package com.example.vk;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.StringTokenizer;

/**
 * Created by админ on 12.07.2017.
 */

public class CustomWebViewClient extends WebViewClient {

    public final String host_vk = "https://api.vk.com/method/friends.get",
            fields = "fields=photo_100",
            order = "order=name";
    public static String response;
    public static String JSON_response;
    public static String access_token;

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url){
        view.loadUrl(url);

        Uri inquiry = Uri.parse(url);
        response = inquiry.getFragment();

        if(response != null)
        {
            StringTokenizer access = new StringTokenizer(response, "&");

             access_token = access.nextToken();
             JSON_response = host_vk + "?" + fields + "&" + order + "&" + access_token;
             view.setVisibility(view.GONE);

            new GetContacts().execute();


            Log.d("", "");

            return true;
        }

        return true;
    }
}
