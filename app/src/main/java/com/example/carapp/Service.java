package com.example.carapp;

/**
 * Created by Eric on 11/2/2016.
 */

public class Service {
    MainActivity main = new MainActivity();
    private static int milesToNext = 5000;
    private static int timeToNext;
    private int lastMiles = 100000;
    private int nextServiceMiles;
    private int currentMiles = 105000;
    private String currentDate;
    private String nextServiceDate;
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
    public String getNextServiceDate(){
        return nextServiceDate;
    }
    public void setCurrentMiles(){
        currentMiles = main.getDriverMiles();
    }
    public void setCurrentDate(){
    }
    private Boolean timeForService(){
        nextServiceMiles = lastMiles + milesToNext;
        if (nextServiceMiles == currentMiles)
            isTime = true;
return isTime;
    }
}

