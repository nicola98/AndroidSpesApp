package com.example.corsista.androidspesapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.data.DatabaseManager;
import com.example.corsista.androidspesapp.logic.SharedPreferenceUtility;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getApplicationContext().
                        getSharedPreferences("Username", Context.MODE_PRIVATE );
                SharedPreferences.Editor editor = sharedPref.edit();

                editor.remove("User");
                Toast.makeText(getApplicationContext(), SharedPreferenceUtility.readUserFromSharedPreferences(MainActivity.this), Toast.LENGTH_LONG).show();
                finish();

                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);


            }
        });





    }
}
