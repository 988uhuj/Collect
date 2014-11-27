package me.roy.common.module.imageviewpager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.WindowCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    private TextView contentTextView;
    private TextView titleTextView;
    private TextView pageNumTextView;
    private ViewGroup contentLayout;
    private ViewPager viewPager;


    private SimplePagerAdapter adapter;
    private List<Fragment> fragmentList;
    private List<ImageEntity> imageEntityList;

    public static final String TOGGLE_ACTION_BAR = "toggleActionBar";
    public static final String TITLE = "title";
    public static final String DATA = "data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(WindowCompat.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.common_activity_pager);
        findViewById();
        initData();
        initView();
        action();
    }

    private void findViewById(){
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        contentTextView = (TextView) findViewById(R.id.content_text);
        contentLayout = (ViewGroup) findViewById(R.id.content_layout);
    }

    private void initData(){
        imageEntityList = PagerService.getImageEntityList();
        fragmentList = PagerService.getFragmentList(viewPager, imageEntityList);
        ModelFactory modelFactory = new ModelFactory();
        modelFactory.addCommonFragment(fragmentList);
        adapter = new SimplePagerAdapter(getSupportFragmentManager(), modelFactory);

    }

    private void initView(){
        getSupportActionBar().setTitle("");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent_dark)));
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setText(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void action(){
        setText(0);
    }

    private void setText(int position){
        ImageEntity imageEntity = imageEntityList.get(position);
        contentTextView.setText(imageEntity.getContent());

    }



    public void onEvent(String action){
        if(action.equals(TOGGLE_ACTION_BAR)){
            if (getSupportActionBar().isShowing()) {
                getSupportActionBar().hide();
                contentLayout.setVisibility(View.GONE);
            } else {
                getSupportActionBar().show();
                contentLayout.setVisibility(View.VISIBLE);
            }
        }
    }

}
