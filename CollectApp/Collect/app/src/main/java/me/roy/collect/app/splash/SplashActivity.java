package me.roy.collect.app.splash;

import android.os.Bundle;

import me.roy.collect.R;
import me.roy.collect.app.MainActivity;
import me.roy.collect.common.base.BaseActivity;
import me.roy.collect.util.Config;
import me.roy.collect.util.LauncherHelper;
import me.roy.collect.util.PreferenceHelper;

/**
 * Created by chenupt@gmail.com on 2014/7/11.
 * Description : TODO
 */
public class SplashActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_splash_activity_main);

        if( ! PreferenceHelper.getInstance(this).isWriteToDB() || Config.DEBUG){
            Service.getInstance().reWriteLibsDataToDB(this);
            PreferenceHelper.getInstance(this).setWriteToDB(true);
        }

        LauncherHelper.toActivity(this, MainActivity.class);
        finish();
    }
}
