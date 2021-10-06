package com.sm.healthy_man;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
import java.util.Objects;


public class WaterActivity extends AppCompatActivity {

    private double Water1;
    private double Water2;
    private FirebaseDatabase firebaseDatabase;

    private String id;
    private String userName;

    private  double Weight;
    private  double Height;
    private int Age;
    private String Gender;


    private double Kcal1;
    private double Kcal2;

    private double BMI;

    private int Diet1;
    private int Training1;
    private int GenderInt;
    private int Connected;
    private int Connection;
    private int newDay;
    private double newWeight;
    private boolean NewWeightBoolean;
    private ArrayList<Entry> dataVals;
    ImageView waterProgress;

    TextView waterText;

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        dataVals = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            getNameAndId();
            ReadOrInitFromFirebase1();
        }

        Water2 = 2;


        ImageButton watterButton = findViewById(R.id.onClickAddWatter);

        watterButton.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.water_icon_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.water_icon);
                    break;
                }
            }
            return false;
        });
        watterButton.setOnClickListener(view -> {
            Water1 = Water1 + 0.25;

            waterText = findViewById(R.id.waterText);
            waterText.setText("Wypito: \n" + Water1 + " / " + Water2 + " litrów.");

            SaveInFirebase();

            waterProgress();
        });
    }



    private void SaveInFirebase() {
        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Person person = new Person(userName, id, Weight, Height, Age, Gender, Diet1, Training1, Kcal1, Kcal2, BMI, Connected, Connection, GenderInt, Water1, newDay, newWeight, NewWeightBoolean, dataVals);
                    firebaseDatabase.getReference().child("users").child(id).setValue(person);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        } catch (Exception e) {
            Toast.makeText(WaterActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();
        }
    }

    private void getNameAndId() {
        String  idNumber;
        String firebaseEmail = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
        userName = StringUtils.substringBefore(firebaseEmail, "@");
        idNumber = FirebaseAuth.getInstance().getCurrentUser().getUid();
        id =userName + idNumber;
    }

    private void ReadOrInitFromFirebase1() {

        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if ((int) dataSnapshot.getChildrenCount() != 0) {
                        Person newPerson = dataSnapshot.getValue(Person.class);
                        assert newPerson != null;
                        Connected = newPerson.Connected;
                        Connection = newPerson.Connection;
                        Water1 = newPerson.Water;
                        GenderInt = newPerson.GenderId;
                        BMI = newPerson.BMI;
                        Kcal2 = newPerson.KcalTraining;
                        Kcal1 = newPerson.KcalNormal;
                        Training1 = newPerson.Training;
                        Diet1 = newPerson.Diet;
                        Gender = newPerson.Gender;
                        Age = newPerson.Age;
                        Weight = newPerson.Weight;
                        Height = newPerson.Height;
                        newDay = newPerson.Day;
                        newWeight = newPerson.NewWeight;
                        NewWeightBoolean = newPerson.NewWeightBoolean;
                        dataVals = newPerson.dataVals;

                        waterProgress();

                        waterText = findViewById(R.id.waterText);
                        waterText.setText("Wypito: \n" + Water1 + " / " + Water2 + " litrów.");

                    } else {
                        Toast.makeText(WaterActivity.this, "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        } catch (Exception e) {
            Toast.makeText(WaterActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();
        }
    }

    private void waterProgress () {
        waterProgress = findViewById(R.id.water_progress);
        if (Water1 < 0.25)
        {
            waterProgress.setBackgroundResource(R.drawable.water0);
        }
        else if (Water1 >= 0.25 && Water1 <0.5)
        {
            waterProgress.setBackgroundResource(R.drawable.water0_5);
        }
        else if (Water1 >= 0.5 && Water1 <0.75)
        {
            waterProgress.setBackgroundResource(R.drawable.water1);
        }
        else if (Water1 >= 0.75 && Water1 <1)
        {
            waterProgress.setBackgroundResource(R.drawable.water1_5);
        }
        else if (Water1 >= 1 && Water1 <1.25)
        {
            waterProgress.setBackgroundResource(R.drawable.water2);
        }
         else if (Water1 >= 1.25 && Water1 <1.5)
        {
            waterProgress.setBackgroundResource(R.drawable.water2_5);

        }
        else if (Water1 >= 1.5 && Water1 <1.75)
        {
            waterProgress.setBackgroundResource(R.drawable.water3);
        }
        else if (Water1 >= 1.75 && Water1 <2)
        {
            waterProgress.setBackgroundResource(R.drawable.water3_5);
        }
        else if (Water1 >= 2)
        {
            waterProgress.setBackgroundResource(R.drawable.water4);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(WaterActivity.this, R.raw.click);
        clickAlert.start();
    }
}