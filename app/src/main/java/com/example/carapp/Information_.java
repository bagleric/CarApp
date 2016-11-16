package com.example.carapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Information_ extends AppCompatActivity {

    String makeUser = "";
    String model = "";
    private int insuranceId = 0;
    private int numInsurance = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_);

        Button buttonOil = (Button) findViewById(R.id.submitButton);
        buttonOil.setOnClickListener(submitListener);
        Service oil = new Service();
    }

    private View.OnClickListener submitListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final EditText makeOC = (EditText) findViewById(R.id.Make);
            String makeOfCar = makeOC.getText().toString();
            setMake(makeOfCar);

            SharedPreferences.Editor editor = getSharedPreferences(MainActivity.PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString(MainActivity.PREFS_NAME, makeUser); //Storing String
            editor.commit();
            Toast.makeText(Information_.this, "Submitted Successfully", Toast.LENGTH_LONG).show();
        }
    };




        public String getMake() {
            return makeUser;
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
            this.makeUser = _make;
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
