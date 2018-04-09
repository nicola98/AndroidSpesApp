package com.example.corsista.androidspesapp.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.ui.fragment.firstTutorialPage;
import com.example.corsista.androidspesapp.ui.fragment.secondTutorialPage;
import com.example.corsista.androidspesapp.ui.fragment.threeTutorialPage;

/**
 * Created by Corsista on 14/03/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new firstTutorialPage();
        } else if (position == 1){
            return new secondTutorialPage();
        } else{
            return new threeTutorialPage();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.uno);
            case 1:
                return mContext.getString(R.string.due);
            case 2:
                return mContext.getString(R.string.tre);
            default:
                return null;
        }
    }

}
