package com.example.shiza.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

/**
 * Created by Shiza on 16-06-2015.
 */
public class AlertReciver extends BroadcastReceiver {
    int notificationID = 123452;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context,"I am here in alert reciever",Toast.LENGTH_LONG).show();

        createNotification(context, intent);

    }

    public void createNotification(Context context, Intent intent)
    {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("This is the notification from alertReciever");
        mBuilder.setContentText("Hi, This is Android Notification Detail!");

        Intent resultIntent = new Intent(context, NotificationClass.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context );
        stackBuilder.addParentStack(NotificationClass.class);

// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        mBuilder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        mBuilder.setAutoCancel(true);
// notificationID allows you to update the notification later on.
        mNotificationManager.notify(notificationID, mBuilder.build());
    }
}
