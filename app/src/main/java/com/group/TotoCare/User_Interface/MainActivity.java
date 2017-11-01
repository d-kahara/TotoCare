package com.group.TotoCare.User_Interface;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.group.TotoCare.Adapter.PagerAdapter;
import com.group.TotoCare.R;

public class

MainActivity extends AppCompatActivity {
    TabLayout tabLayout_MainActivityxml;
    ViewPager viewPager_MainActivityxml;
    PagerAdapter pagerAdapter;
    private MenuInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//  Initialize our instantiated variables
        tabLayout_MainActivityxml = (TabLayout) findViewById(R.id.tabLayout_MainActivityxml);
        viewPager_MainActivityxml = (ViewPager) findViewById(R.id.viewPager_MainActivityxml);

        /*set icons for each tab*/

        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.drawable.ic_pregnant_woman_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.drawable.ic_child_friendly_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.drawable.ic_assignment_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.drawable.ic_local_dining_white_24dp));
        /*use our adapter to view each screen*/

        pagerAdapter = new com.group.TotoCare.Adapter.PagerAdapter(getSupportFragmentManager(), tabLayout_MainActivityxml.getTabCount());
        viewPager_MainActivityxml.setAdapter(pagerAdapter);

        /*listen for clicks*/

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
        if (Build.VERSION.SDK_INT > 15)
            inflater = getMenuInflater();
        else
            inflater = new MenuInflater(this);
     inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;

            case R.id.community:
                Intent intent1 = new Intent(MainActivity.this, CommunityActivity.class);
                startActivity(intent1);
                return true;

            case R.id.logout:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                // user is now signed out
                                startActivity(new Intent(MainActivity.this, StartActivity.class));
                                finish();
                            }
                        });
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
