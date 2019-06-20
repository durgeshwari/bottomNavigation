package com.example.bottomnav;

import android.os.Bundle;

import com.example.bottomnav.fragments.AttractionFragment;
import com.example.bottomnav.fragments.EventFragment;
import com.example.bottomnav.fragments.HomeFragment;
import com.example.bottomnav.fragments.ScheduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment=null;
        switch ((menuItem.getItemId())){
            case R.id.navigation_home:
                fragment=new HomeFragment();
                break;
            case R.id.navigation_event:
                fragment=new EventFragment();
                break;

            case R.id.navigation_attraction:
                fragment=new AttractionFragment();
                break;
            case R.id.navigation_schedule:
                fragment=new ScheduleFragment();
                break;

        }

        return loadFragment(fragment);
    }
}
