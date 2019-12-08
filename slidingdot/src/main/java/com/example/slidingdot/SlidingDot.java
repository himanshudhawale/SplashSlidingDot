package com.example.slidingdot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import androidx.annotation.NonNull;

import androidx.viewpager.widget.ViewPager;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;


public class SlidingDot extends FrameLayout {

    private ViewPager mViewPager;
    private ImageViewPagerAdapter mViewPagerAdapter;
    private OnSetImageListener mOnSetImageListener;
    ViewPager.OnPageChangeListener mOnPageChangeListener;
    private Context mContext;


    public SlidingDot(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(context,attrs);
    }
    public SlidingDot(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @SuppressLint("Range")
    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.activity_sliding_dot,this);
        mViewPager = findViewById(R.id.pager_splash);
        mViewPagerAdapter = new ImageViewPagerAdapter(context,mOnSetImageListener);
        if(!isInEditMode())
            if(attrs != null){
                TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SlidingSplashView, 0,
                        0);
                int id = typedArray.getResourceId(R.styleable.SlidingSplashView_imageResources,0);
                if(id != 0){
                    TypedArray typed = context.getResources().obtainTypedArray(id);
                    Bitmap[] drawables = new Bitmap[typed.length()];
                    for(int i = 0 ; i < drawables.length ; ++i){
                        drawables[i] = BitmapFactory.decodeResource(mContext.getResources(), typed.getResourceId(i,0));
                    }
                    typed.recycle();
                    mViewPagerAdapter.setImageResources(drawables);
                }
                typedArray.recycle();
            }
        mViewPager.setAdapter(mViewPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mViewPager,true);
    }


    public void setImageResources(@NonNull Bitmap[] imageResources){
        mViewPagerAdapter.setImageResources(imageResources);
    }



    public void setOnShowImageListener(OnSetImageListener onShowImageListener){
        mOnSetImageListener = onShowImageListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mViewPagerAdapter.setOnPagerItemClick(onItemClickListener);
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener){
        mViewPager.addOnPageChangeListener(mOnPageChangeListener = onPageChangeListener);
    }

    public void removeOnPageChangeListener(){
        mViewPager.removeOnPageChangeListener(mOnPageChangeListener);
    }



}


