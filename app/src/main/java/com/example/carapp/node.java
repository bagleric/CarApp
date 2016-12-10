package com.example.carapp;

import org.w3c.dom.Node;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Mike on 12/2/2016.
 */
//this node is designed to hold one service for the user
public class node {

    private String nameSpecialRequest;
    Calendar setCalEvent;
    private String miles;
    //node initialization
    public node () {
        nameSpecialRequest = "";
        setCalEvent = Calendar.getInstance();
        miles = "0";
    }
    //set node values
    public node (String name, Calendar date, String miles) {
        this.nameSpecialRequest = name;
        this.setCalEvent = date;
        this.miles = miles;
    }

    public Calendar getDateFormat(){
        return setCalEvent;
    }
    //sets the calendar event to a specific format
    public String getDateInStringFormat(){
        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
        String formatted = format1.format(setCalEvent.getTime());
        System.out.println(formatted);
        return formatted;
    }
    //setters
    public String getMiles(){return miles;}

    public String getNameSpecialRequest(){
        return nameSpecialRequest;
    }

    public void setDateFormat(Calendar tempDate){ this.setCalEvent = tempDate;}

    public void setNameSpecialRequest(String tempSpecialRequest){
        this.nameSpecialRequest = tempSpecialRequest;
    }

    public void setMiles(String miles) {this.miles = miles;}

    public String toString(){
        return nameSpecialRequest;
    }
    //a compare for sorting this node with others
    //we sort by date
    public boolean isDateOneLaterThanDateTwo(node Date1, node Date2){
       return Date1.getDateFormat().after(Date2.getDateFormat());
    }
}