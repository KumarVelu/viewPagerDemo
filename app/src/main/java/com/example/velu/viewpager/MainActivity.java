package com.example.velu.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mData;
    private ViewPager mViewPager;
    private MyPagerAdapter mMyPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = new ArrayList<>();
        mData.add("Page 1");
        mData.add("Page 2");
        mData.add("Page 3");
        mData.add("Page 4");

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyPagerAdapter);
        mViewPager.setCurrentItem(2);
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            String data = mData.get(position);
            DetailFragment df = DetailFragment.newInstance(data);
            return df;
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }
}
