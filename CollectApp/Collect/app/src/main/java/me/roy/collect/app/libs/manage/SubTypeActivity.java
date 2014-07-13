package me.roy.collect.app.libs.manage;

import android.os.Bundle;

import me.roy.collect.R;
import me.roy.collect.common.base.BaseActivity;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class SubTypeActivity extends BaseActivity{

    private SubTypeFragment fragment;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_libraries_activity_sub_type);

        type = getIntent().getIntExtra("type", -1);
        initView();
        action();
    }

    private void initView(){
        fragment = new SubTypeFragment();
        fragment.setType(type);
    }

    private void action(){
        replaceContentFragment();
    }

    private void replaceContentFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }


}
