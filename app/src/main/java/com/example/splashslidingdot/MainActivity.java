package com.example.splashslidingdot;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.slidingdot.SlidingDot;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SlidingDot slidingDot  = findViewById(R.id.splash);
        slidingDot.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("OnPageScrolled", String.valueOf(position));
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("OnPageSelected", String.valueOf(position));

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d("PageScrollStateChanged", String.valueOf(state));

    }
}