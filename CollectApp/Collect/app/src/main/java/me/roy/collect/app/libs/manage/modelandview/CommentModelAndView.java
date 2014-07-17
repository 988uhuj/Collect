package me.roy.collect.app.libs.manage.modelandview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.umeng.socialize.controller.RequestType;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;

import java.util.Map;

import me.roy.collect.R;
import me.roy.collect.app.entity.LibInfo;
import me.roy.collect.common.base.BaseModelAndView;
import me.roy.collect.util.DebugLog;


/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : TODO
 */
public class CommentModelAndView extends BaseModelAndView {

    private View container;

    private LibInfo libInfo;

	public CommentModelAndView(Context context) {
		super(context);
		onFinishInflate();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.app_libraries_item_view_comment, this);
		container = findViewById(R.id.container);
        container.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                UMSocialService controller = UMServiceFactory.getUMSocialService(libInfo.getUrl(), RequestType.SOCIAL);
                controller.openComment(getContext(), false);
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
