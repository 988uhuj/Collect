package me.roy.collect.common.base;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import me.roy.collect.util.Constants;

public class BaseActivity extends ActionBarActivity {

	protected boolean isActive;
	protected boolean isDataChanged;
	private OnSyncDataListener onSyncDataListener;
	
	private Intent intentReceived;

	protected BroadcastReceiver syncDataReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (onSyncDataListener != null) {
				if(isActive){
					onSyncDataListener.onReceive(context, intent);
				}else{
					intentReceived = intent;
					isDataChanged = true;
				}
			}
		}

	};

	@Override
	protected void onResume() {
		isActive = true;
		if(isDataChanged && onSyncDataListener != null){
			onSyncDataListener.onReceive(this, intentReceived);
			isDataChanged = false;
		}
		super.onResume();
	}

	@Override
	protected void onPause() {
		isActive = false;
		super.onPause();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Constants.CHANGE_DATA＿ACTION);
		registerReceiver(syncDataReceiver, intentFilter);
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(syncDataReceiver);
		super.onDestroy();
	}

	protected void setOnSyncDataListener(OnSyncDataListener i) {
		this.onSyncDataListener = i;
	}

	protected interface OnSyncDataListener {
		public void onReceive(Context context, Intent intent);
	}

}
