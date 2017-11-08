package com.group.TotoCare.User_Interface;

import android.content.Intent;
import android.icu.util.DateInterval;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.group.TotoCare.Adapter.PagerAdapter;
import com.group.TotoCare.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class

MainActivity extends AppCompatActivity {
    TabLayout tabLayout_MainActivityxml;
    ViewPager viewPager_MainActivityxml;
    PagerAdapter pagerAdapter;
    private MenuInflater inflater;
    private DatabaseReference mMotherDatabase;
    private ImageView mProfileImage;
    private FirebaseAuth mAuth;
    private String userID;
    private String mProfileImageUrl;
    private String mDueDate;
    private Date mDueDate2;
    private TextView mDueDateField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProfileImage = findViewById(R.id.profileImageCardView);
        mDueDateField =  findViewById(R.id.ctdTimer);


//        Setting Profile pic on image View
        mAuth = FirebaseAuth.getInstance();
//     Creating a node for mothers under users in the database for a specific user
        userID = mAuth.getCurrentUser().getUid();

        mMotherDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("Mothers").child(userID);

        getUserInfo();

//  Initialize our instantiated variables
        tabLayout_MainActivityxml = (TabLayout) findViewById(R.id.tabLayout_MainActivityxml);
        viewPager_MainActivityxml = (ViewPager) findViewById(R.id.viewPager_MainActivityxml);

        /*set icons for each tab*/

        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.drawable.ic_pregnant_woman_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.drawable.ic_local_dining_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.drawable.ic_assignment_white_24dp));
        tabLayout_MainActivityxml.addTab(tabLayout_MainActivityxml.newTab().setIcon(R.drawable.ic_child_friendly_white_24dp));
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

    private void getUserInfo(){
        mMotherDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists() && dataSnapshot.getChildrenCount()>0){
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    if(map.get("profileImageUrl")!=null){
                        mProfileImageUrl = map.get("profileImageUrl").toString();
                        Glide.with(getApplication()).load(mProfileImageUrl).into(mProfileImage);
                    }
                    if(map.get("dueDate")!=null) {
                        mDueDate = map.get("dueDate").toString();
                        Log.d("onDataChange: ", mDueDate);
                        String myFormat = "dd/MM/yyyy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                        try {
                            Log.d("LOGG",String.valueOf(mDueDate));
                            mDueDate2 = sdf.parse(mDueDate);

                        }catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date date = new Date();

                        long diff = Math.abs(mDueDate2.getTime()-date.getTime());



                        // 10 = November, month start at 0 = January

                        //1000 = 1 second interval
                        CountDownTimer cdt = new CountDownTimer(diff, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                                millisUntilFinished -= TimeUnit.DAYS.toMillis(days);

                                long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                                millisUntilFinished -= TimeUnit.HOURS.toMillis(hours);

                                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                                millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes);

                                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);

                                mDueDateField.setText(days + "days:" + hours + "hours:" + minutes + "minutes:" + seconds + "seconds"); //You can compute the millisUntilFinished on hours/minutes/seconds
                            }

                            @Override
                            public void onFinish() {
                                mDueDateField.setText("Congratulations! Your bundle of joy has arrived");
                            }
                        };
                        cdt.start();




                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
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
            case R.id.recipe:
                Intent intent2 = new Intent(MainActivity.this, RecipeActivity.class);
                startActivity(intent2);
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
