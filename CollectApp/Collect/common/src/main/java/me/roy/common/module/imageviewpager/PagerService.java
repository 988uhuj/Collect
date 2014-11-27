package me.roy.common.module.imageviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.roy.common.multiplefragment.ModelFactory;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description TODO
 */
public class PagerService {

    private static String[] strings = new String[]{
            "http://geekcar.net/wp-content/uploads/2014/07/image001-675x442.jpg",
            "http://img.anzhuo.im/public/picture/2012122401/1348137920992.jpg",
            "http://www.kkdesk.com/d/file/99043e600dc6dc2ea9242cca49b7422d.jpg",
            "http://pic1.win4000.com/wallpaper/b/50a06956560a6.jpg",
            "http://t10.baidu.com/it/u=3465796203,1415156598&fm=56",
//            "http://t3.qpic.cn/mblogpic/7314e3a05fd7eb5533cc/2000",
            "http://t2.qpic.cn/mblogpic/81feadbaabcc042d90ae/2000",
            "http://t2.qpic.cn/mblogpic/8d0431068738e6db026c/2000",
            "http://t1.qpic.cn/mblogpic/9aa6d80d1512b35a47c2/2000"
        };

    public static List<Fragment> getFragmentList(ViewPager viewPager, List<ImageEntity> imageEntityList){
        List<Fragment> list = new ArrayList<Fragment>();
        for(int i = 0; i < 30; i ++){
            PagerImageFragment fragment = new PagerImageFragment();
            fragment.setViewPager(viewPager);
            Bundle bundle = new Bundle();
            bundle.putSerializable(ModelFactory.DATA, imageEntityList.get(i));
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        return list;
    }

    public static List<ImageEntity> getImageEntityList(){
        List<ImageEntity> list = new ArrayList<ImageEntity>();
        for(int i = 0; i < 30; i ++){
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setId(i);
            imageEntity.setTitle("asdf打算发撒旦法师法飞洒发顺丰的" + i);
            imageEntity.setContent("松asdfas枫打算发撒旦法师算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发法飞算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发算发撒旦法师法飞洒发洒发顺丰的sdfasdfasdfasfafsd" + i);
            imageEntity.setImageUrl(strings[i % strings.length]);
            list.add(imageEntity);
        }
        return list;
    }
}
