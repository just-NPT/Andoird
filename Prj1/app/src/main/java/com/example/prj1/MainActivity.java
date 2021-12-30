package com.example.prj1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;


import com.example.prj1.fragment.ProgrammerFragment;
import com.example.prj1.fragment.ScienceFragment;
import com.example.prj1.fragment.StandardFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final int FRAGMENT_STANDARD = 0;
    private static final int FRAGMENT_SCIENCE = 1;
    private static final int FRAGMENT_GRAPH = 2;
    private static final int FRAGMENT_DEV = 3;
    private static final int FRAGMENT_DATE = 4;

    private int curr_fragment = FRAGMENT_STANDARD;

    DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.navi_open,R.string.navi_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navi_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null) {
            replaceFragment(new StandardFragment());
            navigationView.getMenu().findItem(R.id.nav_standard).setChecked(true);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_standard:
                if(curr_fragment != FRAGMENT_STANDARD){
                    replaceFragment(new StandardFragment());
                    curr_fragment = FRAGMENT_STANDARD;
                }
            case R.id.nav_science:
                if(curr_fragment != FRAGMENT_SCIENCE){
                    replaceFragment(new ScienceFragment());
                    curr_fragment = FRAGMENT_SCIENCE;
                }
                case R.id.nav_dev:
                if(curr_fragment != FRAGMENT_DEV){
                    replaceFragment(new ProgrammerFragment());
                    curr_fragment = FRAGMENT_DEV;
                }
            /*case R.id.nav_graphs:
                if(curr_fragment != FRAGMENT_GRAPH){
                    replaceFragment(new GraphFragment());
                    curr_fragment = FRAGMENT_GRAPH;
                }

            case R.id.nav_date:
                if(curr_fragment != FRAGMENT_DATE){
                    replaceFragment(new DateFragment());
                    curr_fragment = FRAGMENT_DATE;
                }*/
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,fragment);
        fragmentTransaction.commit();
    }
}