package me.roy.collect.app.libs.manage.modelandview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.LibType;
import me.roy.collect.app.libs.manage.SubTypeActivity;
import me.roy.collect.app.libs.manage.service.TypeService;
import me.roy.collect.common.base.BaseModelAndView;
import me.roy.collect.util.DebugLog;
import me.roy.collect.util.LauncherHelper;


/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : TODO
 */
public class SimpleModelAndView extends BaseModelAndView {

    private View container;

    private LibType libType;
    private TextView titleTextView;
    private TextView descriptionTextView;

    private double height;

	public SimpleModelAndView(Context context) {
		super(context);
        if(height == 0){
            height = TypeService.getInstance().getRandomHeightRatio();
        }
		onFinishInflate();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.app_libraries_item_view_simple, this);
        titleTextView = (TextView) findViewById(R.id.title);
        descriptionTextView = (TextView) findViewById(R.id.description);
		container = findViewById(R.id.container);
        container.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LauncherHelper.toActivity(getContext(), SubTypeActivity.class, "type", libType.getType());
            }
        });
	}

	@Override
	public void bindView() {
		Map<String, Object> map = (Map<String, Object>) model;

        DebugLog.d("map:" + map);
        libType = (LibType) map.get("value");
        titleTextView.setText(libType.getTitle());
        descriptionTextView.setText("# " + libType.getDescription());
//        titleTextView.setHeightRatio(height);
	}





}
