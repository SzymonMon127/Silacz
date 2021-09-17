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

public class StartingPage3 extends AppCompatActivity {

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

    }

    public void OnClickSwitchAmator(View view) {

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

    }

    public void OnClickSwitchSemiProfessional(View view) {

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

    }

    public void OnClickSwitchProfessional(View view) {

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

    }


}