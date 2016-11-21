package com.example.carapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mike on 11/11/2016.
 */

public class extraFeatures extends AppCompatActivity {
    String nameSpecialRequest;
    String miles;
    String CurrentOdometer;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

    //This needs to store the information onclick, then create an object
    //store the object in a dates array, then kick the user back to the main activity.
    @Override
    protected void onCreate(Bundle savedExtraFeaturesState) {
        super.onCreate(savedExtraFeaturesState);
        setContentView(R.layout.extra_features);
        Button buttonTire = (Button) findViewById(R.id.button);
        buttonTire.setOnClickListener(submitListener);
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        Button buttonTire = (Button) findViewById(R.id.button);
        buttonTire.setOnClickListener(submitListener);
    }

    private View.OnClickListener submitListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.button);
            //we need this just commented out for testing

           EditText _nameSpecialR = (EditText) findViewById(R.id.name);
           setNameSR(_nameSpecialR.getText().toString());

           EditText setOd = (EditText) findViewById(R.id.Odometer);
           setOdometer(setOd.getText().toString());

           EditText setM = (EditText) findViewById(R.id.milesTill);
           setMiles(setM.getText().toString());

           EditText MnthsTill = (EditText) findViewById(R.id.monthsTill);
           int num = Integer.valueOf(MnthsTill.getText().toString());
           MonthsTill(num);


        }
    };

    public String nameSpecialRequest() {
        return nameSpecialRequest;
    }

    public String miles() {
        return miles;
    }

    public String Odometer() {
        return CurrentOdometer;
    }

    public DateFormat date(){return dateFormat;}

    public void setNameSR(String _nameSpecialRequest) {

        if (_nameSpecialRequest != "") {
            Log.d("Special Name","State is saved");
            this.nameSpecialRequest = _nameSpecialRequest;
        } else {
            Log.d("Special Name","The state is Blank and must be filled out.");
            /* initialize app */
        }
        this.nameSpecialRequest = _nameSpecialRequest;
    }

    public void setMiles(String _miles) {
        if (_miles != "") {
            Log.d("Set Miles","State is saved");
            this.miles = _miles;
        } else {
            Log.d("Set Miles","The state is Blank and must be filled out.");
        }
    }

    public void setOdometer(String _Odometer) {

        if (_Odometer != "") {
            Log.d("Set Odometer","State is saved");
            this.CurrentOdometer = _Odometer;
        } else {
            Log.d("Set Odometer","The state is Blank and must be filled out.");
        }
    }

 //   public void setDate(DateFormat dateFormat);

    public void MonthsTill(int _userDate) {

        if (_userDate < 1) {
            Log.d("Set Odometer","State is saved");
            String serviceDate;
            Calendar currentDate = Calendar.getInstance();
            currentDate.setTime(new Date()); // Now use today date.
            currentDate.add(Calendar.MONTH, _userDate); // Adds 15 months
            serviceDate = dateFormat.format(currentDate.getTime());
            Toast.makeText(extraFeatures.this, serviceDate, Toast.LENGTH_LONG).show();
        } else {
            Log.d("Set Odometer","The state is Blank and must be filled out.");
            /* initialize app */
        }

    }


}
