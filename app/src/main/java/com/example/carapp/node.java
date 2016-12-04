package com.example.carapp;

import org.w3c.dom.Node;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mike on 12/2/2016.
 */

public class node {

    private String nameSpecialRequest;
    Calendar setCalEvent;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

    public node () {
        nameSpecialRequest = "";
        dateFormat = new SimpleDateFormat("MM/dd/yy");
    }

    public node (String name, SimpleDateFormat date, Node next) {
        this.nameSpecialRequest = name;
        this.dateFormat = date;
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

    public void setNode(SimpleDateFormat valueDate, String ValueSpecialRequest){
        setDateFormat(valueDate);
        setNameSpecialRequest(ValueSpecialRequest);
    }

}