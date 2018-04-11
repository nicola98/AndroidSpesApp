package com.example.corsista.androidspesapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.data.DatabaseManager;
import com.example.corsista.androidspesapp.data.User;

/**
 * Created by davide on 09/04/2018.
 */

public class SignInActivity extends Activity {

    EditText editTextname;
    EditText editTextsurname;
    ImageView imageViewurlImage;
    EditText editTextemail ;
    EditText editTextusername;
    EditText editTextpassword;
    Button signInButton;
    TextView backToLogin;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        databaseManager = new DatabaseManager(this);
        editTextname = (EditText) findViewById(R.id.name);
        editTextsurname = (EditText)findViewById(R.id.surname);
        imageViewurlImage = (ImageView) findViewById(R.id.MyImage);
        editTextemail = (EditText)findViewById(R.id.email);
        editTextusername = (EditText)findViewById(R.id.username);
        editTextpassword = (EditText)findViewById(R.id.password);
        signInButton = (Button)findViewById(R.id.signIn);
        backToLogin = (TextView)findViewById(R.id.backToLogin);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user;
                if(imageViewurlImage==null)
                user = new User(editTextname.getText().toString(), editTextsurname.getText().toString(), imageViewurlImage.toString(),editTextemail.getText().toString(),editTextusername.getText().toString(),editTextpassword.getText().toString());
                else
                user = new User(editTextname.getText().toString(), editTextsurname.getText().toString(),editTextemail.getText().toString(),editTextusername.getText().toString(),editTextpassword.getText().toString());

                databaseManager.createUser(user);
            }
        });
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(SignInActivity.this,Login.class);
               startActivity(intent);
            }
        });

    }
}
