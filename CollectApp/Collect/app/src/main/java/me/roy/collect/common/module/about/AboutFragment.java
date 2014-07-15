package me.roy.collect.common.module.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.roy.collect.R;
import me.roy.collect.common.base.BaseFragment;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class AboutFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.common_fragment_about, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findViewById();
        initData();
        initView();

        action();
    }

    private void findViewById(){
    }

    private void initData(){
    }

    private void initView(){
    }

    private void action(){
    }




}
