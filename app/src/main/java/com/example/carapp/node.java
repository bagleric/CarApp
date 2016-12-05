package com.example.carapp;

import org.w3c.dom.Node;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Mike on 12/2/2016.
 */

public class node {

    private String nameSpecialRequest;
    Calendar setCalEvent;

    public node () {
        nameSpecialRequest = "";
        setCalEvent = Calendar.getInstance();
    }

    public node (String name, Calendar date) {
        this.nameSpecialRequest = name;
        this.setCalEvent = date;
    }

    public Calendar getDateFormat(){
        return setCalEvent;
    }

    public String getNameSpecialRequest(){
        return nameSpecialRequest;
    }

    public void setDateFormat(Calendar tempDate){ this.setCalEvent = tempDate;}

    public void setNameSpecialRequest(String tempSpecialRequest){
        this.nameSpecialRequest = tempSpecialRequest;
    }

    public String toString(){
        return nameSpecialRequest;
    }

    public void setNode(Calendar valueDate, String ValueSpecialRequest){
        setDateFormat(valueDate);
        setNameSpecialRequest(ValueSpecialRequest);
    }
    public boolean isDateOneLaterThanDateTwo(node Date1, node Date2){
       return Date1.getDateFormat().after(Date2.getDateFormat());
    }
}