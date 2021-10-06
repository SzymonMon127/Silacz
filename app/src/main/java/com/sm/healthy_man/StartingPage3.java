package com.sm.healthy_man;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class StartingPage3 extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ImageButton trainingamator = findViewById(R.id.training_amator);
        ImageButton trainingsemi = findViewById(R.id.training_semi_professional);
        ImageButton trainingpro = findViewById(R.id.training_professional);


        trainingamator.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.training_amator_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.training_amator);
                    break;
                }
            }
            return false;
        });

        trainingsemi.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.training_semi_professional_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.training_semi_professional);
                    break;
                }
            }
            return false;
        });
        trainingpro.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.training_professional_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.training_professional);
                    break;
                }
            }
            return false;
        });

        trainingamator.setOnClickListener(view -> {
            SQLiteOpenHelper questionsDatabaseHelper = new QuestionsDatabaseHelper(this);
            SQLiteDatabase db = questionsDatabaseHelper.getWritableDatabase();

            ContentValues Info1 = new ContentValues();
            Info1.put("TRENING", "Początkujący");

            db.update("INFO1", Info1, "_id = ?", new String[]{Integer.toString(1)});

            ContentValues Info2 = new ContentValues();
            Info2.put("TRAINING1", 1);

            db.update("INFO1", Info2, "_id = ?", new String[]{Integer.toString(1)});


            db.close();


            Intent intent = new Intent(StartingPage3.this, StartingPage4.class);
            startActivity(intent);
        });


        trainingsemi.setOnClickListener(view -> {
            SQLiteOpenHelper questionsDatabaseHelper = new QuestionsDatabaseHelper(this);
            SQLiteDatabase db = questionsDatabaseHelper.getWritableDatabase();

            ContentValues Info1 = new ContentValues();
            Info1.put("TRENING", "Pół profesjonalny");

            db.update("INFO1", Info1, "_id = ?", new String[]{Integer.toString(1)});

            ContentValues Info2 = new ContentValues();
            Info2.put("TRAINING1", 2);

            db.update("INFO1", Info2, "_id = ?", new String[]{Integer.toString(1)});


            db.close();

            Intent intent = new Intent(StartingPage3.this, StartingPage4.class);
            startActivity(intent);
        });
        trainingpro.setOnClickListener(view -> {
            SQLiteOpenHelper questionsDatabaseHelper = new QuestionsDatabaseHelper(this);
            SQLiteDatabase db = questionsDatabaseHelper.getWritableDatabase();

            ContentValues Info1 = new ContentValues();
            Info1.put("TRENING", "Professionalny");

            db.update("INFO1", Info1, "_id = ?", new String[]{Integer.toString(1)});

            ContentValues Info2 = new ContentValues();
            Info2.put("TRAINING1", 3);

            db.update("INFO1", Info2, "_id = ?", new String[]{Integer.toString(1)});


            db.close();

            Intent intent = new Intent(StartingPage3.this, StartingPage4.class);
            startActivity(intent);

        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(StartingPage3.this, R.raw.click);
        clickAlert.start();
    }


}