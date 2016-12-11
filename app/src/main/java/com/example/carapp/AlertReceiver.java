package com.example.carapp;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Eric on 12/8/2016.
 */

public class AlertReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ALERT", "You Entered the AlertReceiver");

        createNotification(context, "Car Calendar", "Your car has a pending service",
                "Alert");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void createNotification(Context context, String msg, String msgText, String msgAlert) {
        //tell it where to go if the notification is clicked
        PendingIntent notificIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), 0);

        //build the actual notification
        NotificationCompat.Builder myBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.tire)
                .setContentTitle(msg)
                .setTicker(msgAlert)
                .setContentText(msgText);

        myBuilder.setContentIntent(notificIntent);

        myBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);

        myBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1,myBuilder.build());

    }
}
