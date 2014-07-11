package me.roy.collect.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

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
		notify(context, smallIcon, bigIcon, title, message, sound, intent, defaults, DEFAULT_ID);
	}
	
	public void notify(Context context, int smallIcon, int bigIcon, CharSequence title,
			CharSequence message, Uri sound, Intent intent, int defaults, int id) {
		
		final PendingIntent contentIntent = PendingIntent.getActivity(context,
				0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				
		NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle(
				new NotificationCompat.Builder(context).setAutoCancel(true)
						.setSmallIcon(smallIcon).setTicker(message)
						.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), bigIcon))
						.setContentTitle(title)
						.setContentText(message)
						.setDefaults(defaults)
						.setSound(sound)
						.setWhen(System.currentTimeMillis())
						.setContentIntent(contentIntent));
		localBigTextStyle.bigText(message);		
		
		notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(id, localBigTextStyle.build());		
		
	}
}
