package com.example.android.capstoneprojectr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btn_log;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_log = (Button)findViewById(R.id.btn_login);
        username = (EditText)findViewById(R.id.editUname);
        password = (EditText)findViewById(R.id.editPass);

    }

    public void login(View view){
        String uname = username.getText().toString();
        String pass = password.getText().toString();
        String type = "login";

        BackgroundWorker bgWorker = new BackgroundWorker(this);
        bgWorker.execute(type, uname, pass);

        startActivity(new Intent(this, BerandaManagerActivity.class));


    }
}
