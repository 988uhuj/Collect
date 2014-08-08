package me.roy.common.multiplemodel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Base model view can show different item views.
 */
public abstract class BaseItemModel extends FrameLayout {
    public static final String TAG = "MonthViewAdapter";

    protected Context context;
    protected Object model;
    protected Object modelList;
    protected int position;

    public BaseItemModel(Context context){
        this(context, null);
    }

    public BaseItemModel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public abstract void bindView();
    public void setModel(Object model, Object modelList){
        this.model = model;
        this.modelList = modelList;
        bindView();
    };

    public void setViewPosition(int position){
        this.position = position;
    }


}
