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

     ArrayList<UserInform> userInform = new ArrayList<UserInform>();
    public CustomListAdapter adapter;
    Context cnt;
    ListView listView;

    public MakeList(Context context, ListView listView){
        this.cnt = context;
        this.listView = listView;
    }

    public  void getArrayList(ArrayList<UserInform> array){
        this.userInform = array;
    }

    public void getList(){

        adapter = new CustomListAdapter(cnt, userInform);
        listView.setAdapter(adapter);
        Log.d("","");

    }
}
