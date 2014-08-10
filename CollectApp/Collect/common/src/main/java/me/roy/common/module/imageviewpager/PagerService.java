package me.roy.common.module.imageviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description TODO
 */
public class PagerService {

    public static List<Fragment> getFragmentList(ViewPager viewPager){
        List<Fragment> list = new ArrayList<Fragment>();
        for(int i = 0; i < 3; i ++){
            PagerImageFragment fragment = new PagerImageFragment();
            fragment.setViewPager(viewPager);
            list.add(fragment);
        }
        return list;
    }
}
