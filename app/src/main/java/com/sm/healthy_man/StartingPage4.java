package com.sm.healthy_man;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class StartingPage4 extends AppCompatActivity {



    private  double Weight;
    private  double Height;
    private int Age;
    private String Gender;

    private double Kcal1;
    private double Kcal2;

    private double BMI;

    private FirebaseDatabase firebaseDatabase;

    private String id;
    private String userName;
    private int Diet1;
    private int Training1;
    private int GenderInt;

    private double BMR;

    private int Day;
    private ArrayList<Entry> dataVals;
    private int WeightInt;




    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        firebaseDatabase = FirebaseDatabase.getInstance();


        dataVals = new ArrayList<>();

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        try {

            TextView submitWeight = (TextView) findViewById(R.id.Weight_submit);
            TextView submitHeight= (TextView) findViewById(R.id.Height_submit);
            TextView submitAge = (TextView) findViewById(R.id.Age_submit);
            TextView submitGender = (TextView) findViewById(R.id.Gender_submit);

            TextView submitTraining = (TextView) findViewById(R.id.training_submit);
            TextView submitDiet = (TextView) findViewById(R.id.diet_submit);
            TextView submitkcal2 = (TextView) findViewById(R.id.kcal_training_submit);
            TextView submitkcal1 = (TextView) findViewById(R.id.kcal_freeDay_submit);
            TextView submitBMI = (TextView) findViewById(R.id.BMI_submit);

            SQLiteOpenHelper questionDatabaseHelper = new QuestionsDatabaseHelper(this);
            SQLiteDatabase db = questionDatabaseHelper.getWritableDatabase();
            int id1 = 1;
            Cursor cursor = db.query("INFO1", new String[]{"WAGA, WZROST, WIEK, PLEC, DIETA, TRENING, KCAL1, KCAL2, TRAINING1, DIET1, BMI, GENDER1"},
                    "_id = ?",
                    new String[]{Integer.toString(id1)}, null, null, null);

            if (cursor.moveToFirst())
            {
                Weight = cursor.getDouble(0);
                Height = cursor.getDouble(1);
                Age = cursor.getInt(2);
                Gender = cursor.getString(3);
                String diet = cursor.getString(4);
                String training = cursor.getString(5);
                Kcal1 = cursor.getDouble(6);
                Kcal2 = cursor.getDouble(7);
                Training1 = cursor.getInt(8);
                Diet1 = cursor.getInt(9);
                BMI = cursor.getDouble(10);
                GenderInt = cursor.getInt(11);

                submitWeight.setText(Weight + " KG.");
                submitHeight.setText(Height + " cm.");
                submitAge.setText(Age + " lat/a.");
                submitGender.setText(Gender + ".");

                submitDiet.setText(diet + ".");
                submitTraining.setText(training + ".");



                BMI = Weight/((Height/100)*(Height/100));
                BMI = Math.round(BMI*100);
                BMI = BMI/100;

                WeightInt = (int) Weight;

                if (GenderInt==1)
                {
                        BMR = (9.99 * Weight) + (6.25 * Height) - (4.92 * Age) + 5;
                        BMR = Math.round(BMR*100);
                        BMR = BMR/100;
                }
                else if (GenderInt==2)
                {
                    BMR = (9.99 * Weight) + (6.25 * Height) - (4.92 * Age) -161;
                    BMR = Math.round(BMR*100);
                    BMR = BMR/100;
                }

                if (Diet1 ==1)
                {
                    Kcal1 = BMR*1.2;


                    if (Training1 ==1)
                    {
                        Kcal2 = BMR*1.3;
                    }
                    else if (Training1 ==2)
                    {
                        Kcal2 = BMR*1.35;
                    }
                    else if (Training1 ==3)
                    {
                        Kcal2 = BMR*1.4;
                    }
                }

                else  if (Diet1 ==2)
                {
                    Kcal1 = BMR*1.3;

                    if (Training1 ==1)
                    {
                        Kcal2 = BMR*1.4;
                    }
                    else if (Training1 ==2)
                    {
                        Kcal2 = BMR*1.5;
                    }
                    else if (Training1 ==3)
                    {
                        Kcal2 = BMR*1.6;
                    }
                }

                Kcal1 = Math.round(Kcal1*100);
                Kcal1 = Kcal1/100;
                Kcal2 = Math.round(Kcal2*100);
                Kcal2= Kcal2/100;


                submitkcal1.setText(Kcal1 + " Kcal.");
                submitkcal2.setText(Kcal2 + " Kcal.");
                submitBMI.setText(BMI + ".");

                ContentValues BMIValues = new ContentValues();
                BMIValues.put("BMI", BMI);

                ContentValues KCAL1Values = new ContentValues();
                KCAL1Values.put("KCAL1", Kcal1);

                ContentValues KCAL2Values = new ContentValues();
                KCAL2Values.put("KCAL2", Kcal2);

                db.update("INFO1", BMIValues, "_id = ?", new String[]{Integer.toString(1)});
                db.update("INFO1", KCAL1Values, "_id = ?", new String[]{Integer.toString(1)});
                db.update("INFO1", KCAL2Values, "_id = ?", new String[]{Integer.toString(1)});




                db.close();
                cursor.close();

            }



        }

        catch (SQLiteException e)
        {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        Button goNext = findViewById(R.id.goNext);

        goNext.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.next_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.next);
                    break;
                }
            }
            return false;
        });

        goNext.setOnClickListener(view -> {
            getNameAndId();
            ReadOrInitFromFirebase();
        });
    }






    private void ReadOrInitFromFirebase()
    {
        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    getDay();

                    dataVals.add(new Entry(1,WeightInt));

                        Person person = new Person(userName, id, Weight, Height, Age, Gender, Diet1, Training1, Kcal1, Kcal2, BMI, 1, 1, GenderInt, 0, Day, Weight, false, dataVals);
                        firebaseDatabase.getReference().child("users").child(id).setValue(person);

                    Intent intent = new Intent(StartingPage4.this, MenuActivity.class);
                    startActivity(intent);
                    finishAffinity();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(StartingPage4.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

        }
    }

    private void getNameAndId()
    {
        String  idNumber;
        String firebaseEmail = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
        userName = StringUtils.substringBefore(firebaseEmail, "@");
        idNumber = FirebaseAuth.getInstance().getCurrentUser().getUid();
        id =userName + idNumber;

    }

    private void getDay()
    {
        Calendar calendar = Calendar.getInstance();
        Day = calendar.get(Calendar.DAY_OF_WEEK);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(StartingPage4.this, R.raw.click);
        clickAlert.start();
    }

}