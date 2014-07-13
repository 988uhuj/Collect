package me.roy.collect.test;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import me.roy.collect.R;
import me.roy.collect.util.DebugLog;

/**
 * Created by chenupt@gmail.com on 2014/7/10.
 * Description : TODO
 */
public class TestNotify {

    private NotificationManager notificationManager = null;

    public void notify(Context context) {

        final PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle(
                new NotificationCompat.Builder(context).setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setTicker("aaa")
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher))
                        .setContentTitle("sdfsdf")
                        .setContentText("dsfs")
                        .setDefaults(0)
//                        .setSound(sound)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(contentIntent));
        localBigTextStyle.bigText("ddd");

        notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, localBigTextStyle.build());

        DebugLog.d("notify");
    }

}
