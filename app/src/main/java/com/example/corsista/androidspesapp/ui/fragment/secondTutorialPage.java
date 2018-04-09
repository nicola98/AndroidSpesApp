package com.example.corsista.androidspesapp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.ui.activity.MainActivity;

import static com.example.corsista.androidspesapp.ui.activity.Tutorial.viewPager;

/**
 * Created by Corsista on 09/04/2018.
 */

public class secondTutorialPage extends Fragment {

    TextView next2;
    TextView skip2;
    public secondTutorialPage(){    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.second_tutorial_page_layout, container, false);

        next2 = (TextView) root.findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondTutorialPage fragment = new secondTutorialPage();
                viewPager.setCurrentItem(2);
            }
        });

        skip2 = (TextView) root.findViewById(R.id.skip2);
        skip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
