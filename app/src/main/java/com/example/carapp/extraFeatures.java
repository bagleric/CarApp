package com.example.carapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
   // public static final String PREFS_NAME = "MyPrefsFile";
   private static final String TAG = Information_.class.getSimpleName();

    //This needs to store the information onclick, then create an object
    //store the object in a dates array, then kick the user back to the main activity.
    @Override
    protected void onCreate(Bundle savedExtraFeaturesState) {
        super.onCreate(savedExtraFeaturesState);
        setContentView(R.layout.extra_features);
//        SharedPreferences preferences = getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);

        Information_ info = new Information_();
        CurrentOdometer = preferences.getString("CarOdometer", info.GetOdometer());
        nameSpecialRequest = preferences.getString("SpecialService", ""); //Storing string
        miles = preferences.getString("Miles", ""); //Storing string
        Log.d(TAG, "Odometer=======================" + CurrentOdometer);
        Log.d(TAG, "Odometer from info=======================" + info.GetOdometer());
        EditText _nameSpecialR = (EditText) findViewById(R.id.name);
        EditText setOd = (EditText) findViewById(R.id.Odometer);
        EditText setM = (EditText) findViewById(R.id.milesTill);




        //CurrentOdometer = info.GetOdometer();
        if(!nameSpecialRequest.equals(""))
            _nameSpecialR.setHint(nameSpecialRequest);
        if(!miles.equals(""))
            setM.setHint(miles);
        if(CurrentOdometer != null)
            setOd.setHint(CurrentOdometer);

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
            //we need this just commented out for testing
           EditText _nameSpecialR = (EditText) findViewById(R.id.name);
           EditText setOd = (EditText) findViewById(R.id.Odometer);
           EditText setM = (EditText) findViewById(R.id.milesTill);
            if(!_nameSpecialR.getText().toString().equals(""))
                nameSpecialRequest = _nameSpecialR.getText().toString();
            if(!setM.getText().toString().equals(""))
                miles = setM.getText().toString();
            if(!setOd.getText().toString().equals(""))
                CurrentOdometer = setOd.getText().toString();

            SharedPreferences.Editor editor = getSharedPreferences("PREFS_NAME", MODE_PRIVATE).edit();
            editor.putString("SpecialService", nameSpecialRequest); //Storing string
            editor.putString("Odometer", CurrentOdometer); //Storing string
            editor.putString("Miles", miles); //Storing string
            editor.commit();

            finish();

            //////////////////////////////////////////////////////////////
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
