package me.roy.collect.app.libs.manage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.roy.collect.util.Constants;

/**
 * Created by chenupt@gmail.com on 2014/7/10.
 * Description : TODO
 */
public class TypeService {

    private final Random mRandom;

    public List<Map<String, Object>> addTest(){

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < 10; i ++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", Constants.DEF_LIBS_LIST_TYPE.SIMPLE);
            list.add(map);
        }
        return list;

    }


    public double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5 the width
    }

    private static volatile TypeService instance = null;

    private TypeService(){
        mRandom = new Random();
    }

    public static TypeService getInstance() {
        if (instance == null) {
            synchronized (TypeService.class) {
                if (instance == null) {
                    instance = new TypeService();
                }
            }
        }
        return instance;
    }

}
