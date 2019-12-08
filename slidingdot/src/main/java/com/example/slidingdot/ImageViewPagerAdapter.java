package com.example.slidingdot;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Size;

public class ImageViewPagerAdapter extends ViewPagerAdapter {

    private Context mContext;
    private OnItemClickListener mOnPagerItemClick;
    private OnSetImageListener mOnSetImageListener;
    private Bitmap mImageResources[];

    public ImageViewPagerAdapter(Context context,@NonNull OnSetImageListener onSetImageListener ) {
        mContext = context;
        mOnSetImageListener = onSetImageListener;
        mImageResources = new Bitmap[]{};
    }

    @Override
    public View getItem(final int position) {
        ImageView imageView = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.item_view_pager_image,null);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnPagerItemClick != null){
                    mOnPagerItemClick.onPagerItemClick(v,position);
                }
            }
        });
        if(mOnSetImageListener != null){

            mOnSetImageListener.setImage(imageView,position);
        }
        else{
            imageView.setImageBitmap(mImageResources[position]);
        }
        return imageView;
    }


    @Override
    public int getCount() {
        return mImageResources.length;
    }

    public void setImageResources(@NonNull  @Size(min = 2) Bitmap[] imageResources){
        mImageResources = imageResources;
        notifyDataSetChanged();
    }

    public void setOnPagerItemClick(@NonNull OnItemClickListener onPagerItemClickListener){
        mOnPagerItemClick = onPagerItemClickListener;
    }
}