package com.example.silacz;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class Person {

    public String name;
    public String Id;
    public double Weight;
    public double Height;
    public int Age;
    public String Gender;

    public int Diet;
    public int Training;

    public double KcalNormal;
    public double KcalTraining;
    public double BMI;

    public int Connected;
    public  int Connection;

    public int GenderId;

    public double Water;

    public int Day;
    public double NewWeight;
    public  boolean NewWeightBoolean;

    public ArrayList<Entry> dataVals;


    public Person() {
    }


    public Person(String name, String id, double weight, double height, int age, String gender, int diet, int training, double kcalNormal, double kcalTraining, double BMI, int connected, int connection, int genderId, double water, int day, double newWeight, boolean newWeightBoolean, ArrayList<Entry> dataVals) {
        this.name = name;
        Id = id;
        Weight = weight;
        Height = height;
        Age = age;
        Gender = gender;
        Diet = diet;
        Training = training;
        KcalNormal = kcalNormal;
        KcalTraining = kcalTraining;
        this.BMI = BMI;
        Connected = connected;
        Connection = connection;
        GenderId = genderId;
        Water = water;
        Day = day;
        NewWeight = newWeight;
        NewWeightBoolean = newWeightBoolean;
        this.dataVals = dataVals;
    }
}
