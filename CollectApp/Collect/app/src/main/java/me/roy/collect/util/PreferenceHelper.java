package me.roy.collect.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import info.metadude.android.typedpreferences.BooleanPreference;

/**
 * Created by chenupt@gmail.com on 2014/7/12.
 * Description : TODO
 */
public class PreferenceHelper {

    protected final SharedPreferences mSharedPreferences;
    protected static final String KEY_IS_WRITE_TO_DB ="key_is_write_to_db";

    private PreferenceHelper(Context applicationContext) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }

    public boolean isWriteToDB(){
        BooleanPreference pref = new BooleanPreference(mSharedPreferences, KEY_IS_WRITE_TO_DB);
        return pref.isSet();
    }

    public void setWriteToDB(boolean b){
        BooleanPreference pref = new BooleanPreference(mSharedPreferences, KEY_IS_WRITE_TO_DB);
        pref.set(b);
    }




    private static volatile PreferenceHelper instance = null;

    public static PreferenceHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (PreferenceHelper.class) {
                if (instance == null) {
                    instance = new PreferenceHelper(context);
                }
            }
        }
        return instance;
    }
}
