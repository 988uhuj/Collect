package me.roy.collect.common.view;

import com.wisorg.wisedu.activity.calendar.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenupt@gmail.com on 2014/7/4.
 * Description : TODO
 */
public class CustomProgressView extends View {

    private CircularProgressDrawable mDrawable;

    public CustomProgressView(Context context) {
        this(context, null);
    }

    public CustomProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mDrawable = new CircularProgressDrawable(getResources().getColor(R.color.cb5b5b5), 5);
        mDrawable.setCallback(this);
        
        mDrawable.start();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == VISIBLE) {
            mDrawable.start();
        } else {
            mDrawable.stop();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mDrawable.setBounds(0, 0, w, h);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mDrawable.draw(canvas);
    }

    @Override
    protected boolean verifyDrawable(Drawable who) {
        return who == mDrawable || super.verifyDrawable(who);
    }
}
