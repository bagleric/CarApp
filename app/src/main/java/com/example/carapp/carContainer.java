package com.example.carapp;

import android.content.SharedPreferences;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Mike on 11/25/2016.
 */

public class carContainer {



    public int milesTillNextService;


    String nameSpecialRequest;
    String miles;
    String CurrentOdometer;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    private static int milesToNext;
    private static int timeToNext;
    private int lastMiles = 0;
    private int nextServiceMiles;
    private String nextServiceDate;
    private Boolean isTime = false;




}
