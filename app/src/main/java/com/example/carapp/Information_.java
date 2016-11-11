package com.example.carapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Information_ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_);
    }


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
