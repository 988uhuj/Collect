package me.roy.collect.app.splash;

import android.os.Bundle;
import android.os.Handler;

import me.roy.collect.R;
import me.roy.collect.app.MainActivity;
import me.roy.collect.common.base.BaseActivity;
import me.roy.collect.util.Config;
import me.roy.collect.util.Exec;
import me.roy.collect.util.LauncherHelper;
import me.roy.collect.util.PreferenceHelper;
import me.roy.collect.util.Task;

/**
 * Created by chenupt@gmail.com on 2014/7/11.
 * Description : TODO
 */
public class SplashActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_splash_activity_main);

        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Exec.exe(new Task<Void>() {
                    @Override
                    public Void call() throws Exception {
                        writeToDb();
                        return null;
                    }

                    @Override
                    public void onComplete(Void result) {
                        super.onComplete(result);
                        LauncherHelper.toActivity(SplashActivity.this, MainActivity.class);
                        finish();
                    }
                });

            }
        }, 1000);

    }

    private void writeToDb(){
        if( ! PreferenceHelper.getInstance(this).isWriteToDB() || Config.DEBUG){
            Service.getInstance().reWriteLibsDataToDB(this);
            PreferenceHelper.getInstance(this).setWriteToDB(true);
        }
    }
}
