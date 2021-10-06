package com.sm.healthy_man;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class QuestionsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "User Info";
    private static final int DB_VERSION = 1;

    QuestionsDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        updateMyDatabase(db,oldVersion, newVersion);
    }


    public static void insertINFO1(SQLiteDatabase db, double Waga,
                                              double Wzrost, int Wiek, String Plec,
                                              String Dieta, String Trening, double Kcal1, double Kcal2, int Training1, int Diet1, double BMI, int GenderInt)
    {
        ContentValues  questionValues = new ContentValues();
        questionValues.put("WAGA", Waga);
        questionValues.put("WZROST", Wzrost);
        questionValues.put("WIEK", Wiek);
        questionValues.put("PLEC", Plec);
        questionValues.put("DIETA", Dieta);
        questionValues.put("TRENING", Trening);
        questionValues.put("KCAL1", Kcal1);
        questionValues.put("KCAL2", Kcal2);
        questionValues.put("TRAINING1", Training1);
        questionValues.put("DIET1", Diet1);
        questionValues.put("BMI", BMI);
        questionValues.put("GENDER1", GenderInt);
        db.insert("INFO1", null, questionValues);

    }




    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion < 2) {
            db.execSQL("CREATE TABLE INFO1 (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "WAGA DOUBLE,"
                    + "WZROST DOUBLE,"
                    + "WIEK INTEGER,"
                    + "PLEC TEXT,"
                    + "DIETA TEXT,"
                    + "TRENING TEXT,"
                    + "KCAL1 DOUBLE,"
                    + "KCAL2 DOUBLE,"
                    + "TRAINING1 INTEGER,"
                    + "DIET1 INTEGER,"
                    + "BMI DOUBLE,"
                    + "GENDER1 INTEGER);");


            //Created By Szymon Moń

            //SERIAL S1

            insertINFO1(db, 0,0,0,"-", "-", "-", 0, 0, 0, 0, 0, 0);

        }
    }
}


