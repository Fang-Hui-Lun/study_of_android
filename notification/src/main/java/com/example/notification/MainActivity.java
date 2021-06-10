package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationManager manager;
    private NotificationChannel channel;
    private Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取系统通知服务对象
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        // 判断系统版本是否高于8.0
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            channel = new NotificationChannel("test", "测试通知", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
        // 创建通知点击跳转意图
        Intent intent = new Intent(this, MainActivity.class);

        // 创建通知点击跳转目标
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        // 创建通知对象
        notification = new NotificationCompat
                .Builder(this, "test")
                .setContentTitle("测试通知") // 设置通知标题
                .setContentText("世界很大,去看看吧") // 设置通知内容
                .setSmallIcon(R.drawable.ic_baseline_all_inclusive_24) // 设置通知小图标
                .setColor(Color.parseColor("#FF88DDFF")) // 设置通知小图标颜色
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.cat)) // 设置通知大图标
                .setContentIntent(pendingIntent) // 设置通知点击跳转目标
                .setAutoCancel(true) // 设置点击通知后关闭通知
                .build();
    }

    public void send(View view) {
        manager.notify(1,notification);
    }

    public void cancel(View view) {
        manager.cancel(1);
    }

}