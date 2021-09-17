package com.example.silacz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class StartingPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void OnClickGoNext(View view) {
        Intent intent = new Intent(StartingPage2.this, StartingPage3.class);
        startActivity(intent);

    }

    public void OnClickSwitchReduction(View view) {

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


    }

    public void OnClickSwitchMass(View view) {

        SQLiteOpenHelper questionsDatabaseHelper = new QuestionsDatabaseHelper(this);
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


    }
}