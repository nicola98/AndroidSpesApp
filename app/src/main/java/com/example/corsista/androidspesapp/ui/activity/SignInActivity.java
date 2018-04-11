package com.example.corsista.androidspesapp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.data.DatabaseManager;
import com.example.corsista.androidspesapp.data.User;

/**
 * Created by davide on 09/04/2018.
 */

public class SignInActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        DatabaseManager databaseManager = new DatabaseManager(this);
        EditText editTextname = (EditText) findViewById(R.id.name);
        EditText editTextsurname = (EditText)findViewById(R.id.surname);
        ImageView imageViewurlImage = (ImageView) findViewById(R.id.MyImage);
        EditText editTextemail = (EditText)findViewById(R.id.email);
        EditText editTextusername = (EditText)findViewById(R.id.username);
        EditText editTextpassword = (EditText)findViewById(R.id.password);

        
        User user = new User(editTextname.getText().toString(), editTextsurname.getText().toString(), imageViewurlImage.toString(),editTextemail.getText().toString(),editTextusername.getText().toString(),editTextpassword.getText().toString());


        databaseManager.createUser(user);
    }
}
