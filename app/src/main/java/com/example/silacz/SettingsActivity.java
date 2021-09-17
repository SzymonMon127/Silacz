package com.example.silacz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.NumberPicker;
import android.widget.Spinner;

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

public class SettingsActivity extends AppCompatActivity  {


    private double Water1;
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
    private NumberPicker numberPickerAge;
    private NumberPicker numberPickerHeight;
    private int HeightInt;

    Spinner spinnerTraining;

    Spinner spinnerDiet;

    Spinner spinnerGender;

    ArrayList<Entry> dataVals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        firebaseDatabase = FirebaseDatabase.getInstance();

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        dataVals = new ArrayList<>();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {

            getNameAndId();
            ReadOrInitFromFirebase1();

        }

        spinnerTraining = (Spinner) findViewById(R.id.trainingList);
        spinnerTraining.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        break;
                    case 1:
                        Training1 = 1;
                        break;
                    case 2:
                        Training1 = 2;
                        break;
                    case 3:
                        Training1 = 3;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerDiet = (Spinner) findViewById(R.id.dietList);
        spinnerDiet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        break;
                    case 1:
                        Diet1 = 1;
                        break;
                    case 2:
                        Diet1 = 2;
                        break;
                    case 3:
                        Diet1 = 3;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerGender = (Spinner) findViewById(R.id.genderList);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        break;
                    case 1:
                        GenderInt = 1;
                        break;
                    case 2:
                        GenderInt = 2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        numberPickerAge = (NumberPicker) findViewById(R.id.numberPickerAge);
        numberPickerHeight = (NumberPicker) findViewById(R.id.numberPickerHeight);

        numberPickerAge.setOnValueChangedListener((picker, oldVal, newVal) -> Age = newVal);
        numberPickerHeight.setOnValueChangedListener((picker, oldVal, newVal) -> HeightInt = newVal);




    }



    private void ReadOrInitFromFirebase1() {

        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
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

                         HeightInt = (int) Height;

                        numberPickerAge.setMinValue(0);
                        numberPickerAge.setMaxValue(99);
                        numberPickerAge.setValue(Age);

                        numberPickerHeight.setMinValue(0);
                        numberPickerHeight.setMaxValue(250);
                        numberPickerHeight.setValue(HeightInt);



                    }
                    else
                    {
                        Toast.makeText(SettingsActivity.this, "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(SettingsActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

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

    private void SaveInFirebase()
    {
        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Height = HeightInt;
                    BMI = Weight/((Height/100)*(Height/100));
                    BMI = Math.round(BMI*100);
                    BMI = BMI/100;

                    double BMR = 0;

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

                    Person person = new Person(userName, id, Weight, Height, Age, Gender, Diet1, Training1, Kcal1, Kcal2, BMI, Connected, Connection, GenderInt, Water1, newDay, newWeight, NewWeightBoolean, dataVals);
                    firebaseDatabase.getReference().child("users").child(id).setValue(person);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(SettingsActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

        }
    }


    public void onClickSave(View view) {



        SaveInFirebase();

        Toast.makeText(SettingsActivity.this, "Zatwierdzono zmianę", Toast.LENGTH_SHORT).show();
    }

}