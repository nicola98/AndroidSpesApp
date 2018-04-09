package com.example.corsista.androidspesapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.corsista.androidspesapp.R;

/**
 * Created by Corsista on 09/04/2018.
 */

public class secondTutorialPage extends Fragment {

    public secondTutorialPage(){    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.second_tutorial_page_layout, container, false);
    }
}
