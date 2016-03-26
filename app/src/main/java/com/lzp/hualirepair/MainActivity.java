package com.lzp.hualirepair;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lzp.hualirepair.fragments.RepairQueryFragment;
import com.lzp.hualirepair.fragments.WebViewFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager repairViewPager;
    private TabLayout tabLayout;

//    android:background="@drawable/library_selector"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设定状态栏的颜色，当版本大于4.4时起作用
        setSystemBarTint();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("在线报修");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        repairViewPager = (ViewPager) findViewById(R.id.repairViewPager);
        onlineRepairPagerAdapter pagerAdapter = new onlineRepairPagerAdapter(getSupportFragmentManager());
        repairViewPager.setOffscreenPageLimit(2);
        repairViewPager.setAdapter(pagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(repairViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }
    public void setSystemBarTint(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            //此处可以重新指定状态栏颜色
            tintManager.setStatusBarTintResource(R.color.material_blue);
        }
    }

    private class onlineRepairPagerAdapter extends FragmentPagerAdapter {

        public onlineRepairPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new RepairQueryFragment();
                    break;
                case 1:
                    fragment = WebViewFragment.newInstance("http://58.62.159.26/WeiXin/RepairModule/RepairAdd.aspx");
                    break;
                default:
                    return null;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = new String();
            switch (position) {
                case 0:
                    title = "查询报修";
                    break;
                case 1:
                    title = "申请报修";
                    break;
            }
            return title;
        }
    }
}
