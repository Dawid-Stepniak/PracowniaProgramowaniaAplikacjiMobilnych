package com.example.zad_5_02_2025;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2;

    private static final String CHANNEL_ID_HIGH = "high_priority_channel";
    private static final String CHANNEL_ID_LOW = "low_priority_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(v -> sendHighPriorityNotification());
        button2.setOnClickListener(v -> sendLowPriorityNotification());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence highChannelName = "High Priority Notifications";
            String highChannelDescription = "This channel is used for high priority notifications.";
            int importanceHigh = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel highChannel = new NotificationChannel(CHANNEL_ID_HIGH, highChannelName, importanceHigh);
            highChannel.setDescription(highChannelDescription);

            CharSequence lowChannelName = "Low Priority Notifications";
            String lowChannelDescription = "This channel is used for low priority notifications.";
            int importanceLow = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel lowChannel = new NotificationChannel(CHANNEL_ID_LOW, lowChannelName, importanceLow);
            lowChannel.setDescription(lowChannelDescription);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(highChannel);
            notificationManager.createNotificationChannel(lowChannel);
        }
    }

    private void sendHighPriorityNotification() {
        Intent intent = new Intent(this, Activity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_HIGH)
                .setContentTitle("High Priority Notification")
                .setContentText("Click to go to Activity 2")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    private void sendLowPriorityNotification() {
        Intent intent = new Intent(this, Activity3.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_LOW)
                .setContentTitle("Low Priority Notification")
                .setContentText("Click to go to Activity 3")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setPriority(Notification.PRIORITY_LOW)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }
}