package com.perusudroid.objectprefpro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Intel on 01-03-2018.
 */

public class MyAdapter extends ArrayAdapter<User> {

    private List<User> users;

    public MyAdapter(Context context, int inflater_list, List<User> users) {
        super(context, inflater_list, users);
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User data = users.get(position);

        View localView = convertView;

        if (localView == null) {
            localView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflater_list, null);
        }

        if (localView != null) {
            TextView tv1 = localView.findViewById(R.id.tv1);
            TextView tv2 = localView.findViewById(R.id.tv2);
            tv1.setText(data.getUserName());
            tv2.setText(data.getPassWord());
        }

        return localView;
    }


}
