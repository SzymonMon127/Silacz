package com.sm.healthy_man;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.media.MediaPlayer;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.os.Handler;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;



public class MusicFragment extends Fragment {

    public static boolean PAUSE = false;

    private  String[] title;
    private int countMusic =0;
    private Button nextMusicButton;
    private Button startMusicButton;
    private Button pauseMusicbutotn;
    private Button stopMusicButton;
    private TextView titleTextView, idTextView;
    private Handler handler;
    private Runnable runnable;
    private boolean firstLoadUi = false;
    private TextView textViewTime, textViewDuration;
    private SeekBar timeBar;
    private boolean firstRunSek = false;
    private int progressInt;
    private int trainingId=0;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState)
    {

        View layout = inflater.inflate(R.layout.fragment_music, container, false);


        Button previousMusicButton = layout.findViewById(R.id.buttonPrevious);
        nextMusicButton = layout.findViewById(R.id.buttonNext);
        startMusicButton = layout.findViewById(R.id.buttonStart);
        pauseMusicbutotn = layout.findViewById(R.id.buttonPause);
        stopMusicButton = layout.findViewById(R.id.buttonClose);
        titleTextView = layout.findViewById(R.id.titleTextView);
        idTextView = layout.findViewById(R.id.pisitionTextView);

        textViewTime = layout.findViewById(R.id.tvTime);
        textViewDuration = layout.findViewById(R.id.tvDuration);
        timeBar = layout.findViewById(R.id.timeBar);
        firstLoadUi = true;
        InitTables();
        updateUiAndMusic(countMusic);


        previousMusicButton.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(getContext(), R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.music_previous_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.music_previous);
                    break;
                }
            }
            return false;
        });

        nextMusicButton.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(getContext(), R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.music_next_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.music_next);
                    break;
                }
            }
            return false;
        });

        startMusicButton.setOnTouchListener((v, event) -> {


            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(getContext(), R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.music_play_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.music_play);
                    break;
                }
            }
            return false;
        });

        pauseMusicbutotn.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(getContext(), R.raw.click);
                    clickAlert.start();
                    if (!PAUSE)
                    {
                        v.setBackgroundResource(R.drawable.music_pause_clicked);
                    }
                    else
                    {
                        v.setBackgroundResource(R.drawable.button_pause_1_clicked);
                    }
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    if (!PAUSE)
                    {
                        v.setBackgroundResource(R.drawable.music_pause);
                    }
                    else
                    {
                        v.setBackgroundResource(R.drawable.button_pause_1);
                    }
                    break;
                }
            }
            return false;
        });

        stopMusicButton.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(getContext(), R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.music_stop_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.music_stop);
                    break;
                }
            }
            return false;
        });

        previousMusicButton.setOnClickListener(view -> {
            countMusic--;
            if (countMusic<0)
            {
                countMusic=Musics.musicsList.length-1;
            }
            boolean fail = false;

            try {
                if (UpdateHpService.running)
                {
                    stopMyService();
                }
                Intent serviceIntent = new Intent(getContext(), UpdateHpService.class);
                serviceIntent.putExtra(UpdateHpService.EXTRA_SONG_ID, countMusic);
                requireActivity().startService(serviceIntent);
                fail = false;
            }
            catch (Exception e)
            {
                countMusic++;
                fail = true;
            }
            finally {
                if (!fail)
                {
                    if(startMusicButton.getVisibility() == View.VISIBLE)
                    {
                        startMusicButton.setVisibility(View.GONE);
                        pauseMusicbutotn.setVisibility(View.VISIBLE);
                    }
                    if (PAUSE)
                    {
                        PAUSE= false;
                        pauseMusicbutotn.setBackgroundResource(R.drawable.music_pause);
                    }
                    firstLoadUi=true;
                    handler.postDelayed(runnable, 1000);
                }
            }

        });
        nextMusicButton.setOnClickListener(view -> {
            countMusic++;
            if (countMusic>Musics.musicsList.length-1)
            {
                countMusic = 0;
            }

                boolean fail = false;

                try {
                    if (UpdateHpService.running)
                    {
                        stopMyService();
                    }
                    Intent serviceIntent = new Intent(getContext(), UpdateHpService.class);
                    serviceIntent.putExtra(UpdateHpService.EXTRA_SONG_ID, countMusic);
                    requireActivity().startService(serviceIntent);
                    fail = false;
                }
                catch (Exception e)
                {
                    countMusic--;
                    fail = true;
                }
                finally {
                    if (!fail)
                    {
                        if(startMusicButton.getVisibility() == View.VISIBLE)
                        {
                            startMusicButton.setVisibility(View.GONE);
                            pauseMusicbutotn.setVisibility(View.VISIBLE);
                        }
                        if (PAUSE)
                        {
                            PAUSE= false;
                            pauseMusicbutotn.setBackgroundResource(R.drawable.music_pause);
                        }
                        firstLoadUi=true;
                        handler.postDelayed(runnable, 1000);
                    }
                }




        });

        startMusicButton.setOnClickListener(view -> {
            boolean fail = false;
            try {
                if (!UpdateHpService.running)
                {
                    startMyService();
                }
            }
            catch (Exception e)
            {
                fail = true;
            }
            finally {
                if (!fail)
                {
                    pauseMusicbutotn.setVisibility(View.VISIBLE);
                    startMusicButton.setVisibility(View.GONE);
                    firstLoadUi=true;
                    handler.postDelayed(runnable, 1000);
                }
            }

        });

        pauseMusicbutotn.setOnClickListener(view -> {
            PAUSE =!PAUSE;
            if (PAUSE)
            {
                Toast.makeText(getContext(), "PAUSE", Toast.LENGTH_SHORT).show();
                pauseMusicbutotn.setBackgroundResource(R.drawable.button_pause_1);
            }
            else
            {
                Toast.makeText(getContext(), "RESUME", Toast.LENGTH_SHORT).show();
                pauseMusicbutotn.setBackgroundResource(R.drawable.music_pause);

            }
        });

        stopMusicButton.setOnClickListener(view -> {
            boolean fail = false;
            try {
                if (UpdateHpService.running)
                {
                    stopMyService();
                }
            }
            catch (Exception e)
            {
                fail = true;
            }
            finally {
                if (!fail)
                {

                    timeBar.setProgress(0);
                    textViewTime.setText("00:00");
                    pauseMusicbutotn.setVisibility(View.GONE);
                    startMusicButton.setVisibility(View.VISIBLE);
                }
            }


        });


        runLooper();

        return layout;
    }



    private void runLooper() {

        handler = new Handler();
        runnable = new Runnable() {
            @SuppressLint("DefaultLocale")
            @Override
            public void run() {

                if (UpdateHpService.running)
                {

                        final double current = UpdateHpService.musicPlayer.getCurrentPosition();
                        final String elapsedTime = milisecondsToString((int) current);
                        textViewTime.setText(elapsedTime);


                        if (firstLoadUi)
                        {
                            updateUiAndMusic(countMusic);
                            firstLoadUi = false;

                        }
                        if (firstRunSek)
                        {
                            UpdateHpService.musicPlayer.seekTo(progressInt);
                            timeBar.setProgress(progressInt);
                            firstRunSek=false;
                        }
                    if ((int)current >= UpdateHpService.musicPlayer.getDuration() -1000)
                    {
                        nextMusicButton.performClick();
                    }
                    timeBar.setProgress((int) current);
                    handler.postDelayed(this, 1000);
                }



            }
        };
        handler.post(runnable);

    }

    @Override
    public void onResume() {

        super.onResume();
        if(UpdateHpService.running)
        {
            startMusicButton.setVisibility(View.GONE);
            pauseMusicbutotn.setVisibility(View.VISIBLE);
        }
        if (pauseMusicbutotn.getVisibility() == View.VISIBLE)
        {
            if (PAUSE)
            {
                pauseMusicbutotn.setBackgroundResource(R.drawable.button_pause_1);
            }
            else
            {
                pauseMusicbutotn.setBackgroundResource(R.drawable.music_pause);
            }
        }
    }

    private void InitTables()
    {
        title = new String[Musics.musicsList.length];
        for (int i = 0; i < title.length; i++) {
            title[i] =Musics.musicsList[i].getTitle();
        }

    }

    @SuppressLint("SetTextI18n")
    private void updateUiAndMusic(int Count)
    {
        if (firstLoadUi)
        {
         if (UpdateHpService.running)
         {
             countMusic = UpdateHpService.songId;
         }
            int musicPosition = countMusic+1;
            idTextView.setText(musicPosition+". ");
            titleTextView.setText(title[countMusic]);
            titleTextView.setSelected(true);
            firstLoadUi=false;
        }
        else
        {
            int musicPosition = Count+1;
            idTextView.setText(musicPosition+". ");
            titleTextView.setText(title[Count]);
            titleTextView.setSelected(true);

        }

        if (UpdateHpService.running) {
            String duration = milisecondsToString(UpdateHpService.musicPlayer.getDuration());
            textViewDuration.setText(duration);
            timeBar.setMax(UpdateHpService.musicPlayer.getDuration());
        }
            timeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean isFromUser) {
                    if (isFromUser)
                    {

                        if (UpdateHpService.running)
                        {
                            if (timeBar.getProgress() >= UpdateHpService.musicPlayer.getDuration()-1000)
                            {
                                final double current = UpdateHpService.musicPlayer.getCurrentPosition();
                                final String elapsedTime = milisecondsToString((int) current);
                                textViewTime.setText(elapsedTime);
                                stopMusicButton.performClick();

                            }
                            UpdateHpService.musicPlayer.seekTo(progress);
                            seekBar.setProgress(progress);
                        }
                        else {
                            startMusicButton.performClick();
                            firstRunSek = true;
                            progressInt = progress;
                        }

                        }





                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


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




    private void startMyService() {
        if (!UpdateHpService.running)
        {
            TrainingActivity activity = (TrainingActivity) getActivity();
            try {
                trainingId = activity.getTrainingId();
            }
            catch (Exception e)
            {

            }

            Intent serviceIntent = new Intent(getContext(), UpdateHpService.class);
            serviceIntent.putExtra(UpdateHpService.EXTRA_SONG_ID, countMusic);
            serviceIntent.putExtra(UpdateHpService.EXTRA_TRAINING_ID, trainingId);
            requireActivity().startService(serviceIntent);
        }
    }

    private void stopMyService() {
        Intent serviceIntent = new Intent(getContext(), UpdateHpService.class);
        requireActivity().stopService(serviceIntent);
    }

}
