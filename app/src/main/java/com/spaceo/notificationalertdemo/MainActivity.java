package com.spaceo.notificationalertdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.spaceo.notificationalertdemo.NotifyMessage;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ME_ID=1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notification.Builder builder = new Notification.Builder(MainActivity.this);
        Intent notificationIntent = new Intent(this,NotifyMessage.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,notificationIntent, 0);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getResources().getString(R.string.tvTitleofnotification))
                .setContentText(getResources().getString(R.string.tvBodyofNotification))
                .setContentIntent(pendingIntent);
        builder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;
        builder.setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = builder.getNotification();
        notificationManager.notify(R.mipmap.ic_launcher, notification);




    }
}