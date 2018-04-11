package com.example.corsista.androidspesapp.ui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.data.DatabaseManager;
import com.example.corsista.androidspesapp.logic.SharedPreferenceUtility;
import com.example.corsista.androidspesapp.ui.activity.MainActivity;

import static java.lang.String.valueOf;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameGet = SharedPreferenceUtility.readUserFromSharedPreferences(getApplicationContext());
        if( usernameGet == null) {
            setContentView(R.layout.login_layout);
            Button detailButton = (Button) findViewById(R.id.loginButton);
            detailButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText username = (EditText) findViewById(R.id.editTextUser);
                    String usernameString = valueOf(username.getText());
                    EditText password = (EditText) findViewById(R.id.editTextPasw);
                    String passwordString = valueOf(password.getText());
                    DatabaseManager dbManager = new DatabaseManager(getApplicationContext());
                    dbManager.open();
                    Cursor cursor = dbManager.readUser(usernameString);
                    Log.d("cursor", String.valueOf(cursor.moveToFirst()));
                    if (!String.valueOf(cursor.moveToFirst()).equals("false")) {
                        SharedPreferenceUtility.setUserOnSharedPreferences(usernameString, Login.this);
                        Intent intent = new Intent(Login.this,MainActivity.class);
                        intent.putExtra("username", usernameString);
                        startActivity(intent);
                    }
                    else {
                        TextView notReg = (TextView) findViewById(R.id.notreg);
                        notReg.setVisibility(View.VISIBLE);
                        password.setText("");
                    }
                    dbManager.close();
                }
            });
            TextView registrati = (TextView) findViewById(R.id.goToSignIn);
            registrati.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this,SignInActivity.class);
                    startActivity(intent);
                }
            });
        }
        else {
            Intent intent = new Intent(Login.this,MainActivity.class);
            intent.putExtra("username", usernameGet);
            startActivity(intent);
        }
    }
}