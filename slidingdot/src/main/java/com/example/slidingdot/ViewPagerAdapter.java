package com.example.slidingdot;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

public abstract class ViewPagerAdapter extends PagerAdapter {



    public abstract View getItem(int position);


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View mItemView = getItem(position);
        container.addView(mItemView);
        return mItemView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==  object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}