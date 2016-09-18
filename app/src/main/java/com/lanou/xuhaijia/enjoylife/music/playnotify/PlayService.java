package com.lanou.xuhaijia.enjoylife.music.playnotify;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                   \\`.
//        .'//            为什么坚持  想一想当初             \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-.  \\`.
//    .'//.-"                 `-.  |  .-'                 "-. \\`.
//  .'//______.============-..   \ | /   ..-============._______\\`.
//.'//____________________________\|/_____________________________\\`.
// 
//                             

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.activity.MainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;


/**
 * Created by 徐海佳 on 16/9/18.
 */
public class PlayService extends Service {
    MediaPlayer mediaPlayer;
    private NotificationManager notificationManager;
    private NotificationManagerCompat notificationManagerCompat;
    private final static String play = "enjoy.life.PLAY";
    private final static String close = "enjoy.life.CLOSE";
    private RemoteViews remoteViews;
    private Notification notify;
    private String songName;
    private boolean playing = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        mediaPlayer = new MediaPlayer();
        IntentFilter filter = new IntentFilter();
        filter.addAction(play);
        filter.addAction(close);
        registerReceiver(mReceiver, filter);
    }

    @Override
    public void onDestroy() {
        // EventBus 在使用完成后需要取消注册
        EventBus.getDefault().unregister(this);
        unregisterReceiver(mReceiver);
        super.onDestroy();

    }

    @Subscribe()
    public void getData(PlayEvent playEvent) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(PlayService.this, Uri.parse(playEvent.getUrlPlay()));
            songName = playEvent.getName();
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(this, "开始播放", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showNotify();
    }

    private void showNotify() {
        notify = createNotify();
        startForeground(7, notify);
    }

    private Notification createNotify() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        // builder 可用链式 写法 因为返回值都是this;
        builder.setSmallIcon(R.mipmap.enjoy_life);
        // 设置点击Notification之后, 通知消失
        builder.setAutoCancel(true);
        // 为Notification设置点击事件
        PendingIntent intent = getPendingIntent();
        builder.setContentIntent(intent);
        //  为通知设置自定义布局
        RemoteViews views = getViews();
        builder.setContent(views);
        return builder.build();

    }

    public RemoteViews getViews() {
        remoteViews = new RemoteViews(getPackageName(), R.layout.remote_notify);
        remoteViews.setTextViewText(R.id.remote_notify_songname, songName);
        PendingIntent preIntentPlay = PendingIntent.getBroadcast(this, 101, new Intent(play), PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.remote_notify_playorstop, preIntentPlay);
        PendingIntent preIntentClose = PendingIntent.getBroadcast(this, 102, new Intent(close), PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.remote_notify_close, preIntentClose);
        return remoteViews;
    }

    public PendingIntent getPendingIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity
                (this, 100, intent, PendingIntent.FLAG_ONE_SHOT);
        return pending;
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case play:
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        remoteViews.setImageViewResource(R.id.remote_notify_playorstop, R.mipmap.music_notify_play);
                        remoteViews.setTextViewText(R.id.remote_notify_playnow , "暂停播放");
                    } else {
                        mediaPlayer.start();
                        remoteViews.setImageViewResource(R.id.remote_notify_playorstop, R.mipmap.music_notify_stop);
                        remoteViews.setTextViewText(R.id.remote_notify_playnow , "正在播放");

                    }
                    startForeground(7, notify);
                    break;
                case close:
                    stopSelf();
                    break;
            }
        }
    };
}
