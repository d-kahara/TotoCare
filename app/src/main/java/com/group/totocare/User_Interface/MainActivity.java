package com.group.totocare.User_Interface;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.group.totocare.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout_MainActivityxml;
    ViewPager viewPager_MainActivityxml;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Initialize our instantiated variables
         */
        tabLayout_MainActivityxml = (TabLayout) findViewById(R.id.tabLayout_MainActivityxml);
        viewPager_MainActivityxml = (ViewPager) findViewById(R.id.viewPager_MainActivityxml);
        /*
        set icons for each tab
         */
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.mipmap.ic_home_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.mipmap.ic_face_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.mipmap.ic_check_circle_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.mipmap.ic_people_white_24dp));
        /*
        use our adapter to view each screen
         */
        pagerAdapter = new com.group.totocare.Adapter.PagerAdapter(getSupportFragmentManager(), tabLayout_MainActivityxml.getTabCount());
        viewPager_MainActivityxml.setAdapter(pagerAdapter);
        /*
        listen for clicks
         */
        viewPager_MainActivityxml.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_MainActivityxml));
        tabLayout_MainActivityxml.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_MainActivityxml.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    /*
    onOptionsMenu for Main Activity
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        instantiate a Menu Inflater
         */
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_mainactivity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
