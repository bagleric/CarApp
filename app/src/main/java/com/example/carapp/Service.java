package com.example.carapp;

import java.util.Date;

/**
 * Created by Eric on 11/2/2016.
 */

public class Service {
    MainActivity main = new MainActivity();

    Service(){
        milesToNext = 5000;
        timeToNext = 3;
    }

    private int Odemeter = 0;
    private String currentDate;

    private static int milesToNext;
    private static int timeToNext;
    private int lastMiles = 0;
    private int nextServiceMiles;
    private Date ServiceDate;
    private Boolean isTime = false;


    public int getNextServiceMiles(){
        return milesToNext;
    }
    public int getNextServiceTime(){
        return timeToNext;
    }
    public String getCurrentDate(){
        return currentDate;
    }
    public Date getNextServiceDate(){
        return ServiceDate;
    }
    public void setCurrentMiles(){
        Odemeter = main.getDriverMiles();
    }
    public void setCurrentDate(){
    }
    private Boolean timeForService(){
        nextServiceMiles = lastMiles + milesToNext;
        if (nextServiceMiles == Odemeter)
            isTime = true;
return isTime;
    }
}

