package com.sm.healthy_man;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.MotionEvent;
import android.widget.Button;


import android.widget.TextView;
import android.widget.Toast;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
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

public class ChartActivity extends AppCompatActivity {

    LineChart lineChart;

    private FirebaseDatabase firebaseDatabase;

    private String id;
    private String userName;

    private  double Weight;
    private  double Height;
    private int Age;
    private String Gender;


    private double KcalNormal;
    private double KcalDiet;

    private double BMI;

    private int Diet1;
    private int Training1;
    private int GenderInt;
    private int newDay;
    private double newWeight;

    private int WeightInt;

    private int WeightMax;
    private int WeightMin;

    ArrayList<Entry> dataVals;
    ArrayList<Entry> cityList;

    TextView weightMax;
    TextView weightMin;
    TextView weightCurrent;

    TextView kcal1;
    TextView kcal2;

    TextView height;

    TextView BMIEditTExt;

    Button deleteChartButton;

    private ArrayList<Entry> dataVals1;



    @SuppressLint("ClickableViewAccessibility")
    @Override


    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        firebaseDatabase = FirebaseDatabase.getInstance();

        deleteChartButton = findViewById(R.id.chartDeleteButton);

        deleteChartButton.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    MediaPlayer clickAlert =MediaPlayer.create(this, R.raw.click);
                    clickAlert.start();
                    v.setBackgroundResource(R.drawable.table_small_clicked);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.setBackgroundResource(R.drawable.table_small);
                    break;
                }
            }
            return false;
        });

        deleteChartButton.setOnClickListener(view -> {
            boolean fail = false;
            try {
                firebaseDatabase.getReference().child("users").child(id).child("dataVals").removeValue();

                dataVals1 = new ArrayList<>();
                dataVals1.add(new Entry(1,WeightInt));

                Person person = new Person(userName, id, Weight, Height, Age, Gender, Diet1, Training1, KcalNormal, KcalDiet, BMI, 1, 1, GenderInt, 0, newDay, Weight, false, dataVals1);
                firebaseDatabase.getReference().child("users").child(id).setValue(person);
                firebaseDatabase.getReference().child("users").child(id).setValue(person);
                fail = false;
            }
            catch (Exception e)
            {
                fail = true;
                Toast.makeText(ChartActivity.this, "Błąd usuwania", Toast.LENGTH_SHORT).show();
            }
            finally {
                if (!fail)
                {
                    Toast.makeText(ChartActivity.this, "Usunięto pomyślnie", Toast.LENGTH_SHORT).show();
                    ReadOrInitFromFirebase1();
                }
            }
        });

        dataVals = new ArrayList<>();
        cityList = new ArrayList<>();


        weightCurrent = findViewById(R.id.currentWeight);
        weightMax = findViewById(R.id.maxWeight);
        weightMin = findViewById(R.id.minWeight);

        BMIEditTExt = findViewById(R.id.BMI);

        kcal1 = findViewById(R.id.kcal1);
        kcal2 = findViewById(R.id.kcal2);
        height = findViewById(R.id.height_current);

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        if (FirebaseAuth.getInstance().getCurrentUser() != null) {

            getNameAndId();
            ReadOrInitFromFirebase1();

        }


        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);





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
                        GenderInt = newPerson.GenderId;
                        BMI = newPerson.BMI;
                        KcalDiet = newPerson.KcalTraining;
                        KcalNormal = newPerson.KcalNormal;
                        Training1 = newPerson.Training;
                        Diet1 = newPerson.Diet;
                        Gender = newPerson.Gender;
                        Age = newPerson.Age;
                        Weight = newPerson.Weight;
                        Height = newPerson.Height;
                        newDay = newPerson.Day;
                        newWeight = newPerson.NewWeight;
                        dataVals = newPerson.dataVals;

                        Entry[] dataValsTable = new Entry[dataVals.size()];

                            for (int i =0; i < dataVals.size(); i++)
                            {
                                dataValsTable[i] = dataVals.get(i);
                            }

                        int[] dataValsTable1 = new int[dataVals.size()];



                            for (int i =0; i < dataValsTable.length; i ++)
                            {
                                Entry entry;
                                entry = dataValsTable[i];
                                int j;
                                j = (int) entry.getY();
                                dataValsTable1[i] = j;
                            }


                            Sort(dataValsTable1);

                            WeightMax = dataValsTable1[dataValsTable1.length-1];
                            WeightMin = dataValsTable1[0];



                        weightMin.setText(String.valueOf(WeightMin));
                        weightMax.setText(String.valueOf(WeightMax));

                        height.setText(String.valueOf(Height));



                        weightCurrent.setText(String.valueOf(newWeight));

                        BMIEditTExt.setText(String.valueOf(BMI));
                        kcal1.setText(String.valueOf(KcalNormal) );
                        kcal2.setText(String.valueOf(KcalDiet));



                        WeightInt = (int) Weight;
                        Chart();

                    }
                    else
                    {
                        Toast.makeText(ChartActivity.this, "Problem z bazą. Włącz internet/wyloguj i zaloguj ponownie.", Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(ChartActivity.this, "Błąd z bazą danych", Toast.LENGTH_SHORT).show();

        }

    }

    private void Chart()
    {


        lineChart = findViewById(R.id.linearChart);
        LineDataSet lineDataSet1 = new LineDataSet(dataVals, "x(Dzień), y(Waga)");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);

        lineChart.setData(data);
        lineChart.invalidate();
    }





    public static void Sort(int[] table)
    {
        for (int j = 1; j < table.length; j++)
        {
            for (int i =0; i < table.length -1; i++)
            {
                if (table[i] > table[i+1])
                {
                 int p = table[i];
                 table[i] = table[i +1];
                 table[i+1] = p;
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MediaPlayer clickAlert =MediaPlayer.create(ChartActivity.this, R.raw.click);
        clickAlert.start();
    }

}