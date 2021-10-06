package com.sm.healthy_man;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Thor Odynson on 18.02.2021.
 */
public class UpdateHpService extends Service {

    private Toast toast;
    private Timer timer;
    private TimerTask timerTask;
    private static final String CHANNEL_ID = "2";
    private NotificationManager notificationManager;
    private int[] musicId;
    private String[] titleId;
    public static MediaPlayer musicPlayer;
    public static final String EXTRA_SONG_ID = "songId";
    public static final String EXTRA_TRAINING_ID = "trainingId";
    private int trainingId =0;



    public static boolean running;
    public static int songId;
    private class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            if (!MusicFragment.PAUSE)
            {
                showNotification();
                if (!musicPlayer.isPlaying())
                {
                    musicPlayer.start();
                }
            }
            else {
                if (musicPlayer.isPlaying())
                {
                    musicPlayer.pause();
                }
            }

        }
    }

    private void showToast(String text) {
        toast.setText(text);
        toast.show();
    }

    private void writeToLogs(String message) {
        Log.d("HelloServices", message);
        timer = new Timer();
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    }

    @Override
    public void onCreate() {
        super.onCreate();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.CHANNEL_NEWS);
            String description = getString(R.string.CHANNEL_DESCRIPTION);
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
        else
        {
            notificationManager = getSystemService(NotificationManager.class);
        }
        writeToLogs("Called onCreate() method.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        writeToLogs("Called onStartCommand() methond");
        clearTimerSchedule();
        initTask();
        timer.scheduleAtFixedRate(timerTask,  1 * 1000, 1 * 1000);
        running = true;
        musicId= new int[Musics.musicsList.length];
        for (int i = 0; i < musicId.length; i++) {
            musicId[i] = Musics.musicsList[i].getImageId();
        }
        titleId= new String[Musics.musicsList.length];
        for (int i = 0; i < titleId.length; i++) {
            titleId[i] = Musics.musicsList[i].getTitle();
        }
        songId = (Integer)intent.getExtras().get(EXTRA_SONG_ID);
        try
        {
            trainingId = (Integer)intent.getExtras().get(EXTRA_TRAINING_ID);
        }
        catch (Exception e)
        {

        }


        musicPlayer=MediaPlayer.create(getApplicationContext(),musicId[songId] );
        musicPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        writeToLogs("Called onDestroy() method");
        clearTimerSchedule();
        running = false;

        if (musicPlayer.isPlaying())
        {
            musicPlayer.stop();
        }
        super.onDestroy();
    }



    private void clearTimerSchedule() {
        if(timerTask != null) {
            timerTask.cancel();
            timer.purge();
        }
    }

    private void initTask() {
        timerTask = new MyTimerTask();
    }



    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void showNotification() {
        RemoteViews collapsedView = new RemoteViews(this.getPackageName(),
                R.layout.notification_collapsed);


        final double current = musicPlayer.getCurrentPosition();
        final String elapsedTime = milisecondsToString((int) current);
        final String duration = milisecondsToString(musicPlayer.getDuration());


        collapsedView.setTextViewText(R.id.text_view_collapsed_1, (songId+1) +". " + titleId[songId]);
        collapsedView.setProgressBar(R.id.mf_progress_bar, musicPlayer.getDuration(), (int) current, false);
        collapsedView.setTextViewText(R.id.timeMaxTextqq, duration);
        collapsedView.setTextViewText(R.id.timeText, elapsedTime);



        Intent notifyIntent = new Intent(this, TrainingActivity.class);

        notifyIntent.putExtra(TrainingActivity.EXTRA_TRAINING_ID, trainingId);

        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);

      PendingIntent notifyPendingIntent = PendingIntent.getActivity(
                this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
        );


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.music_icon)
                .setCustomContentView(collapsedView)
        .setContentIntent(notifyPendingIntent).setPriority(NotificationCompat.PRIORITY_MIN)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .build();

        notificationManager.notify(2, notification);

        musicPlayer.start();
    }

    public String milisecondsToString(int time)
    {
        String elapsedTime = "";
        int minutes =  time /1000 / 60;
        int seconds = time /1000 %60;
        elapsedTime = minutes+":";
        if (seconds <10)
        {
            elapsedTime +="0";
        }
        elapsedTime +=seconds;

        return elapsedTime;
    }
}
