package com.example.andrey.yourfreetime.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.andrey.yourfreetime.R;
import com.example.andrey.yourfreetime.fragments.PensionerFragment;
import com.example.andrey.yourfreetime.fragments.StudentFragment;
import com.example.andrey.yourfreetime.fragments.WorkerFragment;

public class ThirdActivity extends ActionBarActivity {
    static final String TAG = "myLogs";
    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(getIntent().getIntExtra("page", 0));
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new StudentFragment();
                case 1:
                    return new WorkerFragment();
                case 2:
                    return new PensionerFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

    }

}
