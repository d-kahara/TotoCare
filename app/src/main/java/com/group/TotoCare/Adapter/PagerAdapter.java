package com.group.TotoCare.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.group.TotoCare.Fragments.BabyFragment;
import com.group.TotoCare.Fragments.CheckUpsFragment;

import com.group.TotoCare.Fragments.HomeFragment;
import com.group.TotoCare.Fragments.RecipeFragment;

/**
 * Created by rahmak on 10/12/17
 */

public class PagerAdapter extends FragmentStatePagerAdapter{

    int mNumberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.mNumberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new BabyFragment();
            case 2:
                return new CheckUpsFragment();
            case 3:
                return new RecipeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
