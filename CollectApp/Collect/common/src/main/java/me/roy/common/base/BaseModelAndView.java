package me.roy.common.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : TODO
 */
public abstract class BaseModelAndView extends FrameLayout {

	public static final String TAG = "MonthViewAdapter";
	
	protected Context context;
	protected Object model;
    protected int position;

    public BaseModelAndView(Context context){
        this(context, null);
    }
    
    public BaseModelAndView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
    
    private void init(Context context) {
		this.context = context;
	}

    public abstract void bindView();
    public void setModel(Object model){
    	this.model = model;
    	bindView();
    	
    	Log.d(TAG, "setModel");
    };

    public void setPosition(int position){
        this.position = position;
    }
    
}
