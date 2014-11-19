package com.example.mike.ashiesfitnesstrainer.PageAdapter;

import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.example.mike.ashiesfitnesstrainer.R;


/**
 * Created by Mike on 16/10/2014.
 */
public class ViewPagerFragmentActivity extends SherlockFragmentActivity {

    // Declare Variables
    ActionBar mActionBar;
    ViewPager mPager;
    ActionBar.Tab tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.viewpager_layout);



        // Activate Navigation Mode Tabs
        mActionBar = getSupportActionBar();
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Locate ViewPager in activity_main.xml
        mPager = (ViewPager) findViewById(R.id.pager);

        // Set Page Transfomer
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        // Activate Fragment Manager
        FragmentManager fm = getSupportFragmentManager();

        // Capture ViewPager page swipes
        ViewPager.SimpleOnPageChangeListener ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Find the ViewPager Position
                mActionBar.setSelectedNavigationItem(position);
            }
        };

        mPager.setOnPageChangeListener(ViewPagerListener);
        // Locate the adapter class called ViewPagerAdapter.java
        CustomPageAdapter viewpageradapter = new CustomPageAdapter(fm);
        // Set the View Pager Adapter into ViewPager
        mPager.setAdapter(viewpageradapter);

        // Capture tab button clicks
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                // Pass the position on tab click to ViewPager
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }

        };

        // Create first Tab
        tab = mActionBar.newTab().setText("Home").setTabListener(tabListener);
        mActionBar.addTab(tab);

        // Create second Tab
        tab = mActionBar.newTab().setText("Cardio").setTabListener(tabListener);
        mActionBar.addTab(tab);

        // Create third Tab
        tab = mActionBar.newTab().setText("Weights").setTabListener(tabListener);
        mActionBar.addTab(tab);

        // Create fourth Tab
        tab = mActionBar.newTab().setText("Activity Log").setTabListener(tabListener);
        mActionBar.addTab(tab);
    }

}