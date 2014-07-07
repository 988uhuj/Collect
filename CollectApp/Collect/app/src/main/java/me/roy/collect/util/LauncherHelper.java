package me.roy.collect.util;

import android.content.Context;
import android.content.Intent;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class LauncherHelper {

    public static void toActivity(Context context, Class<?> c){
        Intent intent = new Intent();
        intent.setClass(context, c);
        context.startActivity(intent);
    }

}
