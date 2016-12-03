package com.example.carapp;

import org.w3c.dom.Node;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Mike on 12/2/2016.
 */

public class node {

    private String nameSpecialRequest;

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

    public node () {
        nameSpecialRequest = "";
        dateFormat = new SimpleDateFormat("MM/dd/yy");
    }

    public node (String name, SimpleDateFormat date, Node next) {
        this.nameSpecialRequest = name;
        this.dateFormat = date;
    }

    public DateFormat getDateFormat(){
        return dateFormat;
    }

    public String getNameSpecialRequest(){
        return nameSpecialRequest;
    }

    public void setDateFormat(SimpleDateFormat tempDate){ this.dateFormat = tempDate;}

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