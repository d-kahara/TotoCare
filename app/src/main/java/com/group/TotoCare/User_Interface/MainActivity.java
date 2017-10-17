package com.group.TotoCare.User_Interface;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.group.TotoCare.R;

public class
MainActivity extends AppCompatActivity {
    private MenuInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
