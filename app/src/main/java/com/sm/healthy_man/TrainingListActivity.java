package com.sm.healthy_man;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.MediaPlayer;
import android.os.Bundle;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class TrainingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(TrainingListActivity.this, R.raw.click);
        clickAlert.start();
    }
}