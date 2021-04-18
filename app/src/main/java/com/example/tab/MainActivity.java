package com.example.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tl1;
    private ViewPager vp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl1 = (TabLayout)findViewById(R.id.tl1);
        tl1.addTab(tl1.newTab().setText("Tab 1"));
        tl1.addTab(tl1.newTab().setText("Tab 2"));
        tl1.addTab(tl1.newTab().setText("Tab 3"));
        tl1.setTabGravity(TabLayout.GRAVITY_FILL);

        vp1 = (ViewPager)findViewById(R.id.vp1);
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tl1.getTabCount());
        vp1.setAdapter(adapter);
        vp1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl1));
        tl1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//
            }
        });




    }
    public class PageAdapter extends FragmentStatePagerAdapter {
        int countTab;

        public PageAdapter(@NonNull FragmentManager fm, int countTab) {
            super(fm);
            this.countTab = countTab;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return new TabOne();
                case 1: return new TabTwo();
                case 2: return new TabThree();
            }
            return new TabOne();
        }

        @Override
        public int getCount() {

            return countTab;
        }
    }
}