package com.example.carapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
//    String nameSpecialRequest;
//    String miles;
//    String Odometer;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    @Override
    protected void onCreate(Bundle savedExtraFeaturesState) {
        super.onCreate(savedExtraFeaturesState);
        setContentView(R.layout.extra_features);
        Button buttonTire = (Button) findViewById(R.id.button);
        buttonTire.setOnClickListener(submitListener);
    }
//
//    @Override
//    public void onResume() {
//        super.onResume();  // Always call the superclass method first
//        Button buttonTire = (Button) findViewById(R.id.button);
//        buttonTire.setOnClickListener(submitListener);
//    }

    private View.OnClickListener submitListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.button);
// we need this just commented out for testing
//            EditText _nameSpecialR = (EditText) findViewById(R.id.name);
//            setNameSR( _nameSpecialR.getText().toString());
//
//            EditText setOd = (EditText) findViewById(R.id.Odometer);
//            setOdometer( setOd.getText().toString());
//
//
//            EditText setM = (EditText) findViewById(R.id.milesTill);
//            setMiles( setM.getText().toString());

            EditText MnthsTill = (EditText) findViewById(R.id.monthsTill);
            int num = Integer.valueOf(MnthsTill.getText().toString());
            MonthsTill(num);


        }
    };

//    public String nameSpecialRequest() {
//        return nameSpecialRequest;
//    }
//
//    public String miles() {
//        return miles;
//    }
//
//    public String Odometer() {
//        return Odometer;
//    }
//
//    public DateFormat date(){return dateFormat;}
//
//    public void setNameSR(String _nameSpecialRequest) {
//        this.nameSpecialRequest = _nameSpecialRequest;
//    }
//
//    public void setMiles(String _miles) {
//        this.miles = _miles;
//    }
//
//    public void setOdometer(String _Odometer) {
//        this.Odometer = _Odometer;
//    }

   // public void setDate(DateFormat dateFormat);

    public void MonthsTill(int _userDate) {
        String serviceDate;
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(new Date()); // Now use today date.
        currentDate.add(Calendar.MONTH, _userDate); // Adds 15 months
        serviceDate = dateFormat.format(currentDate.getTime());
        Toast.makeText(extraFeatures.this, serviceDate, Toast.LENGTH_LONG).show();
    }


}
