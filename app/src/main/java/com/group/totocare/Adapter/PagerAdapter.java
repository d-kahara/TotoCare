package com.group.totocare.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.group.totocare.Fragments.BabyFragment;
import com.group.totocare.Fragments.CheckUpsFragment;
import com.group.totocare.Fragments.CommunityFragment;
import com.group.totocare.Fragments.HomeFragment;

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
                return new CommunityFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
