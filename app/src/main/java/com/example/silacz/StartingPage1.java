package com.example.silacz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class StartingPage1 extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    int Id = 1;
    private double Weight;
    private double Height;
    private int Age;
    private boolean fail;
    private int GengerInt =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        NumberPicker numberPickerAge = (NumberPicker) findViewById(R.id.numberPickerAge);
        numberPickerAge.setMinValue(0);
        numberPickerAge.setMaxValue(99);
        numberPickerAge.setValue(18);
        numberPickerAge.setOnValueChangedListener(this);

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }

    @SuppressLint("NonConstantResourceId")
    public void OnClickGoNext(View view) {

        try {
            EditText editTextWeight = (EditText) findViewById(R.id.Weight);
            EditText editTextHeight = (EditText) findViewById(R.id.Height);



            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Gender_radio_group);
            int idD = radioGroup.getCheckedRadioButtonId();


            try {
                String value1 = editTextWeight.getText().toString();
                Weight=Double.parseDouble(value1);

                String value2 = editTextHeight.getText().toString();
                Height=Double.parseDouble(value2);



                fail = false;
            }
            catch (Exception e)
            {
                fail = true;

                Toast toast = Toast.makeText(StartingPage1.this, "Wprowadź poprawnne liczby", Toast.LENGTH_SHORT);
                toast.show();
            }


            String gender = "Brak";

            switch (idD)
            {
                case R.id.Gender_radio_button_man:
                    gender = "Mężczyzna";
                    GengerInt = 1;
                    break;
                case R.id.Gender_radio_button_wowem:
                    gender = "Kobieta";
                    GengerInt = 2;
                    break;
            }


            if (GengerInt==0)
            {
                fail = true;
                Toast.makeText(StartingPage1.this, "Wybierz płeć", Toast.LENGTH_SHORT).show();
            }



            SQLiteOpenHelper questionsDatabaseHelper = new QuestionsDatabaseHelper(this);
            SQLiteDatabase db = questionsDatabaseHelper.getWritableDatabase();

            ContentValues Info1 = new ContentValues();
            Info1.put("WAGA", Weight);

            ContentValues Info2 = new ContentValues();
            Info2.put("WZROST", Height);

            ContentValues Info3 = new ContentValues();
            Info3.put("WIEK", Age);

            ContentValues Info4 = new ContentValues();
            Info4.put("PLEC", gender);



            ContentValues Info5 = new ContentValues();
            Info5.put("GENDER1", GengerInt);




            db.update("INFO1", Info1, "_id = ?", new String[]{Integer.toString(Id)});
            db.update("INFO1", Info2, "_id = ?", new String[]{Integer.toString(Id)});
            db.update("INFO1", Info3, "_id = ?", new String[]{Integer.toString(Id)});
            db.update("INFO1", Info4, "_id = ?", new String[]{Integer.toString(Id)});
            db.update("INFO1", Info5, "_id = ?", new String[]{Integer.toString(Id)});

            db.close();

        }
        catch (Exception e)
        {
            Toast toast = Toast.makeText(StartingPage1.this, "Brak połączenia z bazą", Toast.LENGTH_SHORT);
            toast.show();
        }








        if (!fail)
        {
            Intent intent = new Intent(StartingPage1.this, StartingPage2.class);
            startActivity(intent);
        }




    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Age = newVal;
    }
}