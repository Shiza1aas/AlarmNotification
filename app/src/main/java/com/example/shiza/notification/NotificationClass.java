package com.example.shiza.notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class NotificationClass extends ActionBarActivity {
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_class);
        Toast.makeText(this,"I am going to call add alarm",Toast.LENGTH_LONG).show();
        addAlarm();
    }

    public void addAlarm()
    {
        Toast.makeText(this,"Hello from add alarm",Toast.LENGTH_LONG).show();
//
//        Long alertTime = new GregorianCalendar().getTimeInMillis() + 5 * 1000;
//
//        Calendar c = Calendar.getInstance() ;
//        int seconds = c.get(Calendar.SECOND) ;

        //Set the alarm to 10 seconds from now
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 10);
        long alertTime = c.getTimeInMillis();
        Toast.makeText(this,"The alarm time is " + alertTime,Toast.LENGTH_LONG).show();

        // Define our intention of executing AlertReceiver
        Intent alertIntent = new Intent(this, AlertReciver.class);

        // Allows you to schedule for your application to do something at a later date
        // even if it is in he background or isn't active
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // set() schedules an alarm to trigger
        // Trigger for alertIntent to fire in 5 seconds
        // FLAG_UPDATE_CURRENT : Update the Intent if active
        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this,"I have called the alarm",Toast.LENGTH_LONG).show();

    }
}
