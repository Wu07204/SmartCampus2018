package com.edu.ntou.smartcampus.Theme;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.edu.ntou.smartcampus.NightMap.nMapFragment;
import com.edu.ntou.smartcampus.R;
import com.qozix.tileview.TileView;


import java.util.ArrayList;
import java.util.List;

public class NightMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
    }

    /*
        建立CampusMap畫面，並使用ViewPager(包含三個Fragment)和TabLayout
        */
    private void setupView(){
        setContentView(R.layout.activity_night_map);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);//設定沒有陰影

        //ViewPager代表滑動頁面
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        //設定開始時所在位置，1代表第二個位置(地圖)
        viewPager.setCurrentItem(1);

        //TabLayout代表上排功能欄位(例如:圖標、地圖、路線)
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    /*
        利用Adapter連接ViewPager和Fragment
        */
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new NightMapActivity.Adapter(getSupportFragmentManager());
        adapter.addFragment(new nMapFragment(),"地圖");
        viewPager.setAdapter(adapter);
    }

    /*
        定義Adapter類別繼承FragmentPagerAdapter，來串接Fragment替換頁面。
        */
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
