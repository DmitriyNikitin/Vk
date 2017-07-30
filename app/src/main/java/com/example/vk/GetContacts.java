package com.example.vk;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

/**
 * Created by админ on 12.07.2017.
 */


public class GetContacts extends AsyncTask<Void, Void , ArrayList<UserInform>> {

    private static final String TAG = "Error";
    public static ArrayList<UserInform> arrayList;
    public static ArrayList<UserInform> userInform = new ArrayList<UserInform>();
    public static CustomListAdapter listAdapter;

    @Override
    protected ArrayList<UserInform> doInBackground(Void... params) {
        JsonHendler jsonHendler = new JsonHendler();
        jsonHendler.decodeJSON();
        Log.d("", "");
       return JsonHendler.arrayInfoForList;

    }

    @Override
    protected void onPostExecute(ArrayList<UserInform> result) {
        WebActivity.userInform = result;
        WebActivity.makeList.getArrayList(result);
        WebActivity.makeList.getList();

    }
}
