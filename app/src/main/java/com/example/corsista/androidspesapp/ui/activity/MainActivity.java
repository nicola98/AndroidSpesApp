package com.example.corsista.androidspesapp.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.ui.adapter.SimpleFragmentPagerAdapter;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(true)
        {
            Intent intent = new Intent(getApplicationContext(), Tutorial.class);
            startActivity(intent);
        }
    }
}
