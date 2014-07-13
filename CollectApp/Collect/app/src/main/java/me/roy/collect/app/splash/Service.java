package me.roy.collect.app.splash;

import android.content.Context;

import me.roy.collect.app.entity.LibInfo;
import me.roy.collect.app.entity.LibType;
import me.roy.collect.util.DebugLog;
import me.roy.collect.util.FileUtil;
import me.roy.collect.util.JsonUtil;

/**
 * Created by chenupt@gmail.com on 2014/7/11.
 * Description : TODO
 */
public class Service {

    private final String LIBS_MSG_PATH = "LibsMsg";
    private final String LIBS_TYPE_PATH = "LibsType";

    public void writeLibsDataToDB(Context context){
        writeLibsMsg(context);
        writeLibsType(context);
    }

    public void reWriteLibsDataToDB(Context context){
        deleteLibsMsg();
        writeLibsDataToDB(context);
    }

    private void writeLibsMsg(Context context){
        String[] fileNameArray = FileUtil.getFileNameArray(context, LIBS_MSG_PATH);
        DebugLog.d("fileSize:" + fileNameArray.length);
        for(String fileName : fileNameArray){
            DebugLog.d("fileName:" + fileName);
            String result = FileUtil.readAssets(context, LIBS_MSG_PATH + "/" + fileName);
            LibInfo libInfo = JsonUtil.fromJsonToObject(result, LibInfo.class);
            libInfo.save();
        }
    }

    private void writeLibsType(Context context){
        String[] fileNameArray = FileUtil.getFileNameArray(context, LIBS_TYPE_PATH);
        DebugLog.d("fileSize:" + fileNameArray.length);
        for(String fileName : fileNameArray){
            DebugLog.d("fileName:" + fileName);
            String result = FileUtil.readAssets(context, LIBS_TYPE_PATH + "/" + fileName);
            LibType libType = JsonUtil.fromJsonToObject(result, LibType.class);
            libType.save();
        }
    }


    public void deleteLibsMsg(){
        LibInfo.deleteAll(LibInfo.class);
        LibType.deleteAll(LibType.class);
    }


    private static volatile Service instance = null;

    private Service(){
    }

    public static Service getInstance() {
        if (instance == null) {
            synchronized (Service.class) {
                if (instance == null) {
                    instance = new Service();
                }
            }
        }
        return instance;
    }

}
