package me.roy.common.module.about;

import android.os.Bundle;

import me.roy.common.R;
import me.roy.common.base.BaseActivity;


/**
 * Created by chenupt@gmail.com on 2014/7/11.
 * Description : TODO
 */
public class AboutActivity extends BaseActivity {

    private AboutFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_about);

        initView();
        action();
    }

    private void initView(){
        fragment = new AboutFragment();

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
