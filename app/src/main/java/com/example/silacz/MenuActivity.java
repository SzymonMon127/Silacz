package com.example.silacz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
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

public class MenuActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    private int Connected;
    private String id;
    private String userName;

    private FirebaseDatabase firebaseDatabase;

    private double Water1;

    private boolean fail;

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
    private int Connection;
    private int Day;
    private int newDay;
    private double newWeight;
    private boolean newWeightBoolean;
    private ArrayList<Entry> dataVals;
    private int size;
    private int newWeightInt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        dataVals = new ArrayList<>();


        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {

            Toast toast = Toast.makeText(MenuActivity.this, "Wylogowano", Toast.LENGTH_SHORT);
            toast.show();




            FirebaseAuth.getInstance().signOut();
            goToLogin();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void goToLogin()
    {
        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void getNameAndId()
    {
        String  idNumber;
        String firebaseEmail = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
        userName = StringUtils.substringBefore(firebaseEmail, "@");
        idNumber = FirebaseAuth.getInstance().getCurrentUser().getUid();
        id =userName + idNumber;

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
                        Day = newPerson.Day;
                        newWeight = newPerson.NewWeight;
                        newWeightBoolean = newPerson.NewWeightBoolean;
                        dataVals = newPerson.dataVals;





                             getDay();

                             if (Day != newDay)
                             {
                                 Water1 =0;
                                 kgAlert();



                             }




                        if (Connected == 0) {
                            Intent intent = new Intent(MenuActivity.this, StartingPage1.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else
                    {

                        Toast.makeText(MenuActivity.this, "Problem z bazą. Włącz internet/spróbuj ponownie.", Toast.LENGTH_LONG).show();




                        FirebaseAuth.getInstance().signOut();
                        goToLogin();
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(MenuActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

        }



    }

    private void getDay()
    {
        Calendar calendar = Calendar.getInstance();
        newDay = calendar.get(Calendar.DAY_OF_WEEK);

    }

    private void SaveInFirebase()
    {





        try {
            firebaseDatabase.getReference().child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                    Person person = new Person(userName, id, newWeight, Height, Age, Gender, Diet1, Training1, Kcal1, Kcal2, BMI, Connected, Connection, GenderInt, Water1, newDay, newWeight, newWeightBoolean, dataVals);
                    firebaseDatabase.getReference().child("users").child(id).setValue(person);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(MenuActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

        }
    }

    private void kgAlert()
    {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(this);
        edittext.setInputType(3);
        alert.setMessage("Podaj ją w kg.");
        alert.setTitle("Wpisz dzisiejszą wagę.");

        alert.setView(edittext);

        alert.setPositiveButton("Kontynuuj", (dialog, whichButton) -> {

            try {
                String YouEditTextValue = edittext.getText().toString();
                newWeight = Double.parseDouble(YouEditTextValue);

                fail=false;

                BMI = newWeight/((Height/100)*(Height/100));
                BMI = Math.round(BMI*100);
                BMI = BMI/100;

                double BMR = 0;

                if (GenderInt==1)
                {
                    BMR = (9.99 * newWeight) + (6.25 * Height) - (4.92 * Age) + 5;
                    BMR = Math.round(BMR*100);
                    BMR = BMR/100;
                }
                else if (GenderInt==2)
                {
                    BMR = (9.99 * newWeight) + (6.25 * Height) - (4.92 * Age) -161;
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

            }
            catch (Exception e)
            {


                Toast toast = Toast.makeText(MenuActivity.this, "Wprowadź poprawnne liczby", Toast.LENGTH_SHORT);
                toast.show();
                fail = true;
                kgAlert();
            }

            if (!fail)
            {
                ReadOrInitFromFirebaseChart();
                SaveInFirebase();

            }



        });
        AlertDialog dialog = alert.create();
        dialog.setIcon(R.mipmap.icon_launcher);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.password_background);
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {

            getNameAndId();
            ReadOrInitFromFirebase1();


        }
        else
        {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void ReadOrInitFromFirebaseChart() {

        try {

            firebaseDatabase.getReference().child("users").child(id).child("dataVals").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    if ((int) dataSnapshot.getChildrenCount() != 0) {


                        size = (int) dataSnapshot.getChildrenCount();


                        newWeightInt = (int) newWeight;



                            dataVals.add(new Entry(size+1, newWeightInt));
                            SaveInFirebase();


                    }
                    else
                    {



                        Toast.makeText(MenuActivity.this, "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        } catch (Exception e) {

            dataVals.add(new Entry(1, newWeightInt));
            if (Weight != newWeight)
            {
                Weight = newWeight;
            }

            Person person = new Person(userName, id, Weight, Height, Age, Gender, Diet1, Training1, Kcal1, Kcal2, BMI, Connected, Connection, GenderInt, Water1, newDay, newWeight, newWeightBoolean, dataVals);
            firebaseDatabase.getReference().child("users").child(id).setValue(person);
            Toast.makeText(MenuActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

        }

    }


}