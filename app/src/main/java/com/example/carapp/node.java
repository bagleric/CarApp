package com.example.carapp;

import org.w3c.dom.Node;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Mike on 12/2/2016.
 */

public class node {

    private String nameSpecialRequest;
    private String milesTill;
    // DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    Node next;

    public node () {
        nameSpecialRequest = "";
        milesTill = "";
        next = null;
    }

    public node (String name, String mi, Node next) {
        this.nameSpecialRequest = name;
        this.milesTill = mi;
        this.next = next;
    }

    public String getMilesTill(){
        return milesTill;
    }

    public String getNameSpecialRequest(){
        return nameSpecialRequest;
    }

    public void setMilesTill(){
        this.milesTill = milesTill;
    }

    public void setNameSpecialRequest(){
        this.nameSpecialRequest = nameSpecialRequest;
    }

    public String toString(){
        return milesTill + "" + nameSpecialRequest;
    }
}