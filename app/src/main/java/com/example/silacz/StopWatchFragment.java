package com.example.silacz;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class StopWatchFragment extends Fragment implements View.OnClickListener{

    private int seconds = 0;
    private  boolean running;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.fragment_stop_watch, container, false);
        runTimer(layout);
        Button StartButton = (Button)layout.findViewById(R.id.start_button);
        StartButton.setOnClickListener(this);
        Button StopButton = (Button)layout.findViewById(R.id.stop_button);
        StopButton.setOnClickListener(this);
        Button ResetButton = (Button)layout.findViewById(R.id.reset_button);
        ResetButton.setOnClickListener(this);
        return layout;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.start_button:
                onClickStart();
                break;
            case R.id.stop_button:
                onClickStop();
                break;
            case R.id.reset_button:
                onClickReset();
                break;
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
    }

    private void onClickStart()
    {
        running = true;
    }

    private void onClickStop ()
    {
        running = false;
    }

    private void onClickReset ()
    {
        running = false;
        seconds = 0;
    }

    private void runTimer(View view)
    {
        final TextView timeView = (TextView) view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable()
        {

            @Override
            public void run() {

                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                @SuppressLint("DefaultLocale") String time = String.format("%d:%02d:%02d",hours, minutes, secs);

                timeView.setText(time);
                if (running)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }

        });

    }


}
