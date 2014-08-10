package me.roy.common.module.imageviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.List;

import me.roy.common.R;
import me.roy.common.base.BaseActivity;
import me.roy.common.multiplefragment.ModelFactory;
import me.roy.common.multiplefragment.SimplePagerAdapter;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description TODO
 */
public class PagerActivity extends BaseActivity {

    private ViewPager viewPager;
    private SimplePagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_pager);
        findViewById();
        initData();
        initView();
        action();

        getSupportActionBar().hide();
    }

    private void findViewById(){
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    private void initData(){
        List<Fragment> list = PagerService.getFragmentList(viewPager);
        ModelFactory modelFactory = new ModelFactory();
        modelFactory.addCommonFragment(list);
        adapter = new SimplePagerAdapter(getSupportFragmentManager(), modelFactory);
    }

    private void initView(){
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void action(){


    }


    public void onEvent(Integer i){
        // TODO
    }
}
