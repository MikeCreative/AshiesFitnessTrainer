package com.example.mike.ashiesfitnesstrainer.PageAdapter;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mike.ashiesfitnesstrainer.Tabs.Tab1Fragment;
import com.example.mike.ashiesfitnesstrainer.Tabs.Tab2Fragment;
import com.example.mike.ashiesfitnesstrainer.Tabs.Tab3Fragment;
import com.example.mike.ashiesfitnesstrainer.Tabs.Tab4Fragment;


/**
 * Created by Mike on 16/10/2014.
 */
public class CustomPageAdapter extends FragmentPagerAdapter {

    // Declare the number of ViewPager pages
    final int PAGE_COUNT = 4;

    public CustomPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {

            // Open FragmentTab1.java
            case 0:
                Tab1Fragment fragmenttab1 = new Tab1Fragment();
                return fragmenttab1;

            // Open FragmentTab2.java
            case 1:
                Tab2Fragment fragmenttab2 = new Tab2Fragment();
                return fragmenttab2;

            // Open FragmentTab3.java
            case 2:
                Tab3Fragment fragmenttab3 = new Tab3Fragment();
            return fragmenttab3;

            // Open FragmentTab3.java
            case 3:
                Tab4Fragment fragmenttab4 = new Tab4Fragment();
            return fragmenttab4;
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return PAGE_COUNT;
    }

}
