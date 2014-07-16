package me.roy.collect.app.menu.modelandview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.MenuEntity;
import me.roy.collect.common.base.BaseModelAndView;
import me.roy.collect.util.DebugLog;


/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : TODO
 */
public class MenuModelAndView extends BaseModelAndView {

    private MenuEntity menuEntity;

    private View container;
    private TextView titleTextView;

	public MenuModelAndView(Context context) {
		super(context);
		onFinishInflate();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.app_menu_item_view_simple, this);
        titleTextView = (TextView) findViewById(R.id.title);
		container = findViewById(R.id.container);
//        container.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                changeContent();
//            }
//        });
	}

	@Override
	public void bindView() {
		Map<String, Object> map = (Map<String, Object>) model;

        DebugLog.d("map:" + map);
        menuEntity = (MenuEntity) map.get("value");
        titleTextView.setText(menuEntity.getMenuStr());

        Drawable drawable = getContext().getResources().getDrawable(menuEntity.getIcon());
        titleTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
	}

//    private void changeContent(){
//        if(menuEntity.getId() == 1){
//
//        }
//        LauncherHelper.toActivity(getContext(), menuEntity.getTargetClass());
//    }

}
