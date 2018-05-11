package com.perusudroid.objectprefpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.EditText et1;
    private android.widget.EditText et2;
    private android.widget.Button btnLogin, btnView, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setAssets();
    }

    private void setAssets() {
        btnView.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }

    private void bindViews() {
        this.btnLogin = findViewById(R.id.btnLogin);
        this.btnView = findViewById(R.id.btnView);
        this.btnList = findViewById(R.id.btnList);
        this.et2 = findViewById(R.id.et2);
        this.et1 = findViewById(R.id.et1);
    }

    private boolean isValidated() {
        return et1.getText().toString().trim().length() > 0 && et2.getText().toString().trim().length() > 0;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                if (isValidated()) {
                    if (et1.getText().toString().equals("Perusudroid") || et1.getText().toString().equals("Android")) {
                        User user = new User(et1.getText().toString().trim(), et2.getText().toString().trim());
                        SharedPref.getInstance().setSharedValue("User", user);
                        Toast.makeText(LoginActivity.this, "Ok.. TAP view to See", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid user/password", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnView:
                User mUser = (User) SharedPref.getObject("User", User.class);
                if (mUser != null)
                    Toast.makeText(LoginActivity.this, mUser.getUserName() + "\n " + mUser.getPassWord(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnList:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
