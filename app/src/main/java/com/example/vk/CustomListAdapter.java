package com.example.vk;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by админ on 28.07.2017.
 */

public class CustomListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater lInflater;
    ArrayList<UserInform> friend;

     CustomListAdapter(Context context, ArrayList<UserInform> friend){
        this.context = context;
        this.friend = friend;


        lInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         Log.d("","");
    }

    @Override
    public int getCount() {
        return friend.size();
    }

    @Override
    public Object getItem(int position) {
        return friend.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item, parent, false);
        }

        UserInform friend = userInform(position);

        ((TextView) view.findViewById(R.id.first_name)).setText(friend.firstName);
        ((TextView) view.findViewById(R.id.last_name)).setText(friend.lastName);
        return view;
    }

    UserInform userInform(int position) {
        return ((UserInform) getItem(position));
    }
}
