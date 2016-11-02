package com.example.carapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mike on 11/2/2016.
 */

public class calendar {

    public String getCurrentDate(){
        String currentDate;
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        Calendar calobj = Calendar.getInstance();
        System.out.println(df.format(calobj.getTime()));
        currentDate = df.format(calobj.getTime());
        return currentDate;
    }
}
