package com.example.carapp;

/**
 * Created by mariahbozeman on 11/2/16.
 */

public class Information {
    String make;
    String model;
    private int insuranceId;
    private int numInsurance;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public int getNumInsurance() {
        return numInsurance;
    }

    public void setMake(String _make) {
        this.make = _make;
    }

    public void setModel(String _model) {
        this.model = _model;
    }

    public void setInsuranceId(int _insuranceId) {
        this.insuranceId = _insuranceId;
    }

    public void setNumInsurance(int _numInsurance) {
        this.numInsurance = _numInsurance;
    }
}
