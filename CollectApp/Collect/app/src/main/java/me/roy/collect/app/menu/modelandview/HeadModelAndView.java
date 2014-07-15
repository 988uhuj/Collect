package me.roy.collect.app.menu.modelandview;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.MenuEntity;
import me.roy.collect.common.base.BaseModelAndView;
import me.roy.collect.util.DebugLog;


/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : TODO
 */
public class HeadModelAndView extends BaseModelAndView {

    private MenuEntity menuEntity;

//    private View container;

	public HeadModelAndView(Context context) {
		super(context);
		onFinishInflate();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.app_menu_item_view_head, this);
//		container = findViewById(R.id.container);
//        container.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LauncherHelper.toActivity(getContext(), menuEntity.getTargetClass());
//            }
//        });
	}

	@Override
	public void bindView() {
		Map<String, Object> map = (Map<String, Object>) model;

        DebugLog.d("map:" + map);

	}

}
