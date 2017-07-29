package com.example.vk;

import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by админ on 28.07.2017.
 */

public class MakeList {

    public static ArrayList<UserInform> userInform = new ArrayList<UserInform>();
    public CustomListAdapter listAdapter;
    Context cnt;
    public MakeList(Context context){
        this.cnt = context;

        listAdapter = new CustomListAdapter(cnt, userInform);
        WebActivity webActivity = new WebActivity();
       ListView listView = (ListView)webActivity.findViewById(R.id.list);
        listView.setAdapter(listAdapter);
    }
}
