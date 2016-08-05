package com.ecoffee.ecoffee.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ecoffee.ecoffee.R;
import com.ecoffee.ecoffee.util.AppUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText password;
    Button loginButton;
    CheckBox rememberMeCheckBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);

        password = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);

        rememberMeCheckBox = (CheckBox) findViewById(R.id.rememberMeCheckBox);

    }




    public void validateCredentials() {
        username.setError(null);
        password.setError(null);

        String u = username.getText().toString();
        String p = password.getText().toString();

        if (u.equals("")) {
            username.setError("This field is required!");
        }

        if (p.equals("")) {
            password.setError("This field is required!");
        }

        if (AppUtil.checkUserExist(u, p)) {
            Intent intent = new Intent(MainActivity.this, TableActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "The username or password you have entered is invalid.", Toast.LENGTH_LONG).show();

        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.loginButton:
                validateCredentials();
                break;
        }
    }
}
