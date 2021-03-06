package com.example.tabproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import static com.kakao.util.helper.Utility.getKeyHash;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tab1 = findViewById(R.id.tab1);
        TabItem tab2 = findViewById(R.id.tab2);
        TabItem tab3 = findViewById(R.id.tab3);
        final ViewPager viewPager = findViewById(R.id.viewPager);

        /*
        PagerAdapter: pass data from the tabs and display them into the view pager
         */
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        // 여기
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        Intent intent = getIntent();
        int gotothree = intent.getIntExtra("tab3", 0);
        if(gotothree == 2){
            viewPager.setCurrentItem(2);
        }
        /*
        Change the tabs view when the tab is selected
         */
        TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };

        onTabSelectedListener.onTabSelected(tabLayout.getTabAt(tabLayout.getSelectedTabPosition()));
        tabLayout.addOnTabSelectedListener(onTabSelectedListener);
    }
}