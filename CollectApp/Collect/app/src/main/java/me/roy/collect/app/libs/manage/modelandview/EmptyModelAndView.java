package me.roy.collect.app.libs.manage.modelandview;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.common.base.BaseModelAndView;


/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : TODO
 */
public class EmptyModelAndView extends BaseModelAndView {


	public EmptyModelAndView(Context context) {
		super(context);
		onFinishInflate();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.common_item_view_empty, this);
		
	}

	@Override
	public void bindView() {
		Map<String, Object> map = (Map<String, Object>) model;
	}

}
