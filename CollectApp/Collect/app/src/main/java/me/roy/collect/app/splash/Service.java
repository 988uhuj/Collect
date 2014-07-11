package me.roy.collect.app.splash;

import android.content.Context;

import me.roy.collect.util.FileUtil;

/**
 * Created by chenupt@gmail.com on 2014/7/11.
 * Description : TODO
 */
public class Service {

    private final String LIBS_MSG_PATH = "LibsMsg";

    public void writeLibsDataToDB(Context context){
        String[] fileNameArray = FileUtil.getFileNameArray(context, LIBS_MSG_PATH);
        for(String fileName : fileNameArray){
            String result = FileUtil.readAssets(context, fileName);


        }

    }

}
