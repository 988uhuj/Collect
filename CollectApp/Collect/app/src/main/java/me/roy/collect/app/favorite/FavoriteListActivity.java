package me.roy.collect.app.favorite;

import android.os.Bundle;

import me.roy.collect.R;
import me.roy.collect.common.base.BaseActivity;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class FavoriteListActivity extends BaseActivity{

    private FavoriteFragment fragment;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_libraries_activity_detail);

        id = getIntent().getLongExtra("id", -1);

        initView();
        action();
    }

    private void initView(){
        fragment = new FavoriteFragment();
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
