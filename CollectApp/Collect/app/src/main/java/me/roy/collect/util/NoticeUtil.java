package me.roy.collect.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 消息通知管理类
 */
public class NoticeUtil {

	public final static int DEFAULT_ID = 1;

	private static NoticeUtil mNotice = null;

	private NotificationManager notificationManager = null;

	private NoticeUtil() {

	}

	public synchronized static NoticeUtil newInstance() {
		if (mNotice == null)
			mNotice = new NoticeUtil();
		return mNotice;
	}

	public void notify(Context context, int smallIcon, CharSequence title) {
		notify(context, smallIcon, -1, title, null, null, null, Notification.DEFAULT_ALL);
	}

	public void notify(Context context, int smallIcon, CharSequence title,
			CharSequence message) {
		notify(context, smallIcon, -1, title, message, null, null, Notification.DEFAULT_ALL);
	}

	public void notify(Context context, int smallIcon, CharSequence title,
			CharSequence message, Uri sound) {
		notify(context, smallIcon, -1, title, message, sound, null, Notification.DEFAULT_ALL);
	}

	public void notify(Context context, int smallIcon, CharSequence title,
			CharSequence message, Intent intent) {
		notify(context, smallIcon, -1, title, message, null, intent, Notification.DEFAULT_ALL);
	}

	public void notify(Context context, int smallIcon, int bigIcon,
			CharSequence title, CharSequence message, Intent intent) {
		notify(context, smallIcon, bigIcon, title, message, null, intent, Notification.DEFAULT_ALL);
	}
	
	public void notify(Context context, int smallIcon, int bigIcon, CharSequence title,
			CharSequence message, Uri sound, Intent intent) {
		notify(context, smallIcon, bigIcon, title, message, null, intent, Notification.DEFAULT_ALL);
	}
	
	public void notify(Context context, int smallIcon, int bigIcon,
			CharSequence title, CharSequence message, Intent intent, int defaults) {
		notify(context, smallIcon, bigIcon, title, message, null, intent, defaults);
	}

	public void notify(Context context, int smallIcon, int bigIcon, CharSequence title,
			CharSequence message, Uri sound, Intent intent, int defaults) {
	}
	

}
