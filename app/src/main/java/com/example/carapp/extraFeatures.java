package com.example.carapp;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mike on 11/11/2016.
 */

public class extraFeatures extends AppCompatActivity {
//    private Set<String> requests = new HashSet<String>();
    String nameSpecialRequest;
    String miles;
    String CurrentOdometer;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    Calendar calObject = Calendar.getInstance();

    // public static final String PREFS_NAME = "MyPrefsFile";
   private static final String TAG = extraFeatures.class.getSimpleName();
    Button btn;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    //This needs to store the information onclick, then create an object
    //store the object in a dates array, then kick the user back to the main activity.
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedExtraFeaturesState) {
        super.onCreate(savedExtraFeaturesState);
        setContentView(R.layout.extra_features);
        SharedPreferences preferences = getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        final android.icu.util.Calendar cal = android.icu.util.Calendar.getInstance();

        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        ShowDialogOnButtonClick();

        Information_ info = new Information_();
        CurrentOdometer = preferences.getString("CarOdometer", info.GetOdometer());
        nameSpecialRequest = preferences.getString("SpecialService", ""); //Storing string
        miles = preferences.getString("Miles", ""); //Storing string
        //requests = preferences.getStringSet("newService", requests);

        EditText _nameSpecialR = (EditText) findViewById(R.id.name);
        EditText setOd = (EditText) findViewById(R.id.Odometer);
        EditText setM = (EditText) findViewById(R.id.milesTill);

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

            Information_ info = new Information_();
            SharedPreferences.Editor editor = getSharedPreferences(TAG, MODE_PRIVATE).edit();
            info.setOdometer(CurrentOdometer);
            editor.putString("CarOdometer", info.GetOdometer()); //Storing string

            node newNode = new node(nameSpecialRequest, calObject);
            Log.d(TAG,newNode.getDateFormat().toString());
            Log.d(TAG,newNode.getNameSpecialRequest());
            //  String temp = newNode.toString();
          //  requests.add(temp);
          //  editor.putStringSet("newService", requests);

            MainActivity addInformation = new MainActivity();
            List<node> NewNodeArray;
            NewNodeArray = addInformation.addToNodeArrayAndSort(newNode);

            Gson gson = new Gson();

            String json = gson.toJson(NewNodeArray);

            editor.putString(TAG, json);
            editor.commit();
            finish();

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

    public void DaysTill(int _userDate) {

        if (_userDate > 1) {
            Log.d("Set Odometer","State is saved");
            String serviceDate;
            Calendar currentDate = Calendar.getInstance();
            currentDate.setTime(new Date()); // Now use today date.
            currentDate.add(Calendar.DAY_OF_MONTH, _userDate); // Adds 15 days
            serviceDate = dateFormat.format(currentDate.getTime());
            Toast.makeText(extraFeatures.this, serviceDate, Toast.LENGTH_LONG).show();
            Log.d(TAG, "new date=======================" + serviceDate);
        } else {
            Log.d("Set Odometer","The state is Blank and must be filled out.");
            /* initialize app */
        }


    }
    public void ShowDialogOnButtonClick() {
        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }


    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dPickerListener, year_x, month_x, day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dPickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x =  month + 1;
            day_x = dayOfMonth;
            Toast.makeText(extraFeatures.this, year_x + "/" + month_x +"/" + day_x, Toast.LENGTH_LONG).show();

            /////////////////////////////////////
            //This sets the date ints into a date object
            calObject.set(Calendar.MONTH, month_x);
            calObject.set(Calendar.DATE, day_x);
            calObject.set(Calendar.YEAR, year_x);
            //////////////////////////////////
        }
    };

}
