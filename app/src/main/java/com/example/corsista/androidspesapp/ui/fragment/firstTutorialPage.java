package com.example.corsista.androidspesapp.ui.fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.ui.activity.MainActivity;
import com.example.corsista.androidspesapp.ui.activity.Tutorial;
import com.example.corsista.androidspesapp.ui.adapter.SimpleFragmentPagerAdapter;

import static com.example.corsista.androidspesapp.ui.activity.Tutorial.viewPager;

/**
 * Created by Corsista on 09/04/2018.
 */

public class firstTutorialPage extends Fragment {

    public firstTutorialPage(){    }
    TextView next1;
    TextView skip1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.first_tutorial_page_layout, container, false);

        next1 = (TextView) root.findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondTutorialPage fragment = new secondTutorialPage();
                viewPager.setCurrentItem(1
                );
            }
        });

        skip1 = (TextView) root.findViewById(R.id.skip1);
        skip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
