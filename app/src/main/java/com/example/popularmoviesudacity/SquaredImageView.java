package com.example.popularmoviesudacity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by servando on 9/27/2015.
 */
final class SquaredImageView extends ImageView {
    public SquaredImageView(Context context) {
        super(context);
    }

    public SquaredImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }
}
