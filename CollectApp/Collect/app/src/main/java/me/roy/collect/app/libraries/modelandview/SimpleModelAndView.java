package me.roy.collect.app.libraries.modelandview;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.Map;

import me.roy.collect.app.R;
import me.roy.collect.common.base.BaseModelAndView;
import me.roy.collect.util.DebugLog;


/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : TODO
 */
public class SimpleModelAndView extends BaseModelAndView {



	public SimpleModelAndView(Context context) {
		super(context);
		onFinishInflate();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.libraries_item_view_simple, this);
		
	}

	@Override
	public void bindView() {
		Map<String, Object> map = (Map<String, Object>) model;

        DebugLog.d("map:" + map);
	}

}
