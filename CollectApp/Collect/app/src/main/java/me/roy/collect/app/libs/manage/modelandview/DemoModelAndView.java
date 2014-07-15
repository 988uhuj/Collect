package me.roy.collect.app.libs.manage.modelandview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.LibInfo;
import me.roy.collect.common.base.BaseModelAndView;
import me.roy.collect.util.DebugLog;
import me.roy.collect.util.LauncherHelper;


/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : TODO
 */
public class DemoModelAndView extends BaseModelAndView {

    private View container;

    private LibInfo libInfo;

	public DemoModelAndView(Context context) {
		super(context);
		onFinishInflate();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.app_libraries_item_view_demo, this);
		container = findViewById(R.id.container);
        container.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Class<?> c = Class.forName(libInfo.getSample());
                    LauncherHelper.toActivity(getContext(), c);
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
	}

	@Override
	public void bindView() {
		Map<String, Object> map = (Map<String, Object>) model;

        DebugLog.d("map:" + map);
        libInfo = (LibInfo) map.get("value");

	}

}
