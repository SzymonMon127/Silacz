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
import android.widget.ImageButton;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class StartingPage2 extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page2);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ImageButton trainingamator = findViewById(R.id.Mass_diet);
        ImageButton dietReduction = findViewById(R.id.reduction_diet);

        dietReduction.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.dieta_redukcja_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.dieta_redukcja);
                    break;
                }
            }
            return false;
        });

        trainingamator.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.dieta_moc_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.dieta_moc);
                    break;
                }
            }
            return false;
        });
        trainingamator.setOnClickListener(view -> {
            SQLiteOpenHelper questionsDatabaseHelper = new QuestionsDatabaseHelper(StartingPage2.this);
            SQLiteDatabase db = questionsDatabaseHelper.getWritableDatabase();

            ContentValues Info1 = new ContentValues();
            Info1.put("DIETA", "Masa mięśniowa");

            db.update("INFO1", Info1, "_id = ?", new String[]{Integer.toString(1)});

            ContentValues Info2 = new ContentValues();
            Info2.put("DIET1", 2);

            db.update("INFO1", Info2, "_id = ?", new String[]{Integer.toString(1)});


            db.close();

            Intent intent = new Intent(StartingPage2.this, StartingPage3.class);
            startActivity(intent);
        });


        dietReduction.setOnClickListener(view -> {
            SQLiteOpenHelper questionsDatabaseHelper = new QuestionsDatabaseHelper(this);
            SQLiteDatabase db = questionsDatabaseHelper.getWritableDatabase();

            ContentValues Info1 = new ContentValues();
            Info1.put("DIETA", "Redukcja");

            db.update("INFO1", Info1, "_id = ?", new String[]{Integer.toString(1)});

            ContentValues Info2 = new ContentValues();
            Info2.put("DIET1", 1);

            db.update("INFO1", Info2, "_id = ?", new String[]{Integer.toString(1)});



            db.close();



            Intent intent = new Intent(StartingPage2.this, StartingPage3.class);
            startActivity(intent);

        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(StartingPage2.this, R.raw.click);
        clickAlert.start();
    }

}