package me.roy.collect.entry;

import android.os.Bundle;

import me.roy.collect.app.libraries.SubActivity;
import me.roy.collect.common.base.BaseActivity;
import me.roy.collect.util.LauncherHelper;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class IndexActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LauncherHelper.toActivity(this, SubActivity.class);
    }
}
