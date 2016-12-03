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
    Node next;

    public node () {
        nameSpecialRequest = "";
        dateFormat = new SimpleDateFormat("MM/dd/yy");
        next = null;
    }

    public node (String name, SimpleDateFormat date, Node next) {
        this.nameSpecialRequest = name;
        this.dateFormat = date;
        this.next = next;
    }

    public DateFormat getDateFormat(){
        return dateFormat;
    }

    public String getNameSpecialRequest(){
        return nameSpecialRequest;
    }

    public void setDateFormat(){ this.dateFormat = dateFormat;}

    public void setNameSpecialRequest(){
        this.nameSpecialRequest = nameSpecialRequest;
    }

    public String toString(){
        return nameSpecialRequest;
    }
}