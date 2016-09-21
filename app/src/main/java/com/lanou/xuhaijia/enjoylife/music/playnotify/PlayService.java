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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.activity.MainActivity;
import com.lanou.xuhaijia.enjoylife.music.hotsingle.HotSingleBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


/**
 * Created by 徐海佳 on 16/9/18.
 */
public class PlayService extends Service {
    MediaPlayer mediaPlayer;
    private NotificationManager notificationManager;
    private NotificationManagerCompat notificationManagerCompat;
    private final static String play = "enjoy.life.PLAY";
    private final static String close = "enjoy.life.CLOSE";
    private final static String next = "enjoy.life.NEXT";
    private RemoteViews remoteViews;
    private Notification notify;
    private int position;
    private List<HotSingleBean.SongsBean> songsBeen;
    private String sec;
    private CountDownTimer countDownTimer;


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
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        IntentFilter filter = new IntentFilter();
        filter.addAction(play);
        filter.addAction(close);
        filter.addAction(next);
        registerReceiver(mReceiver, filter);
    }

    @Override
    public void onDestroy() {
        // EventBus 在使用完成后需要取消注册
        EventBus.getDefault().unregister(this);
        unregisterReceiver(mReceiver);
        super.onDestroy();

    }

    // 获取int 需要定义为Integer格式
    @Subscribe
    public void getPosition(Integer position) {
        this.position = position;
    }

    @Subscribe
    public void getData(final List<HotSingleBean.SongsBean> songs) {
        try {
            songsBeen = songs;
            mediaPlayer.reset();
            mediaPlayer.setDataSource(PlayService.this, Uri.parse(songs.get(position).getSrc()));
            mediaPlayer.prepare();
            mediaPlayer.start();
            showNotify();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    try {
                        int a = position;
                        if (a + 1 < songs.size()) {
                            mediaPlayer.reset();
                            mediaPlayer.setDataSource(PlayService.this, Uri.parse(songs.get(a + 1).getSrc()));
                            getPosition(a + 1);
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                            showNotify();
                        } else {
                            mediaPlayer.reset();
                            mediaPlayer.setDataSource(PlayService.this, Uri.parse(songs.get(0).getSrc()));
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                            getPosition(0);
                            showNotify();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        remoteViews.setTextViewText(R.id.remote_notify_songname, songsBeen.get(position).getName());
        remoteViews.setImageViewResource(R.id.remote_notify_playorstop, R.mipmap.music_notify_stop);
        PendingIntent preIntentPlay = PendingIntent.getBroadcast(this, 101, new Intent(play), PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.remote_notify_playorstop, preIntentPlay);
        PendingIntent preIntentClose = PendingIntent.getBroadcast(this, 102, new Intent(close), PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.remote_notify_close, preIntentClose);
        PendingIntent preIntentNext = PendingIntent.getBroadcast(this, 103, new Intent(next), PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.remote_notify_next, preIntentNext);
        getTimeNow();
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
                        countDownTimer.cancel();
                    } else {
                        mediaPlayer.start();
                        countDownTimer.start();
                        remoteViews.setImageViewResource(R.id.remote_notify_playorstop, R.mipmap.music_notify_stop);
                    }
                    startForeground(7, notify);
                    break;
                case next:
                    try {
                        int a = position;
                        if (a + 1 < songsBeen.size()) {
                            mediaPlayer.reset();
                            mediaPlayer.setDataSource(PlayService.this, Uri.parse(songsBeen.get(a + 1).getSrc()));
                            getPosition(a + 1);
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                        } else {
                            mediaPlayer.reset();
                            mediaPlayer.setDataSource(PlayService.this, Uri.parse(songsBeen.get(0).getSrc()));
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                            getPosition(0);

                        }
                        showNotify();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    break;
                case close:
                    mediaPlayer.stop();
                    stopSelf();
                    break;
            }
        }
    };

    private void getTimeNow() {
        countDownTimer = new CountDownTimer(Integer.MAX_VALUE , 1000) {
            @Override
            public void onTick(long l) {
                String time = songsBeen.get(position).getLength();
                int seek = mediaPlayer.getCurrentPosition();
                int minute = (int) (seek / 1000 / 60);
                String min = String.valueOf(minute);
                int second = (int) (seek / 1000 % 60);
                if (second >= 10) {
                    sec = String.valueOf(second);
                } else {
                    sec = "0" + String.valueOf(second);
                }
                String remainderTime = min + ":" + sec;
                remoteViews.setTextViewText(R.id.remote_notify_time ,   remainderTime + " / " + time);
                startForeground(7, notify);
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }


}
