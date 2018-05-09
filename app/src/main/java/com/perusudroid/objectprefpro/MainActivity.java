package com.perusudroid.objectprefpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<User> userList;
    private ListView mListView;
    private EditText editText;
    private Button btnSave;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setAssets();
        doSetLocalData();
    }

    private void bindViews() {
        mListView = findViewById(R.id.listView);
        editText = findViewById(R.id.et1);
    }

    private void setAssets() {
        userList = new ArrayList<>();
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    public void saveClicked() {

        userList.clear();

        List<User> mData = SharedPref.getSharedList(User[].class, "userList");

        if (mData != null) {
            userList.addAll(mData);
        }

        userList.add(new User(editText.getText().toString().trim(), ""));

        SharedPref.setSharedList("userList", userList);

        doSetLocalData();

        editText.setText("");
    }

    private void doSetLocalData() {

        Log.d(TAG, "doSetLocalData: ");

        List<User> mList = SharedPref.getSharedList(User[].class, "userList");

        if (mList != null) {
            if (mList.size() > 0) {
                myAdapter = new MyAdapter(this, R.layout.inflater_list, mList);
                mListView.setAdapter(myAdapter);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                if (!editText.getText().toString().isEmpty()) {
                    saveClicked();
                }
                break;
        }
    }
}
