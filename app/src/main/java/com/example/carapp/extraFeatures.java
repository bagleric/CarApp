package com.example.carapp;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Mike on 11/11/2016.
 */

public class extraFeatures extends AppCompatActivity {

    List<node> NodeArray = new ArrayList<node>();

public static final String PREFS_NAME = "MyPrefsFile";
    public static final String ARRAY_NAME = "array_location";
    String json;
    String nameSpecialRequest;
    String miles;
    String CurrentOdometer;
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    Calendar calObject = Calendar.getInstance();

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
        SharedPreferences  preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        final Calendar cal = Calendar.getInstance();

        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        ShowDialogOnButtonClick();

        Information_ info = new Information_();
        CurrentOdometer = preferences.getString("CarOdometer", info.GetOdometer());
        nameSpecialRequest = preferences.getString("SpecialService", ""); //Storing string
        miles = preferences.getString("Miles", ""); //Storing string
        Gson gson = new Gson();
        json = preferences.getString(ARRAY_NAME, "");
        if (json.length() >= 5)
        json = json.substring(5);


        Type type = new TypeToken<ArrayList<node>>() {}.getType();

        NodeArray = gson.fromJson(json, type);

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


    private View.OnClickListener submitListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //we need this just commented out for testing
            EditText _nameSpecialR = (EditText) findViewById(R.id.name);
            EditText setOd = (EditText) findViewById(R.id.Odometer);
            EditText setM = (EditText) findViewById(R.id.milesTill);

            if (!_nameSpecialR.getText().toString().equals(""))
                nameSpecialRequest = _nameSpecialR.getText().toString();
            if (!setM.getText().toString().equals(""))
                miles = setM.getText().toString();
            if (!setOd.getText().toString().equals(""))
                CurrentOdometer = setOd.getText().toString();

            Information_ info = new Information_();
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            info.setOdometer(CurrentOdometer);
            editor.putString("CarOdometer", info.GetOdometer()); //Storing string

            node newNode = new node(nameSpecialRequest, calObject);

            setAlarm(nameSpecialRequest, calObject);

            addNodeArrayAndSort(newNode);
            Gson gson = new Gson();

            json = "value" + gson.toJson(NodeArray);
            Log.d("array =====", json);
            editor.putString(ARRAY_NAME, json);
            editor.commit();
            finish();

        }
    };

    public List<node> addNodeArrayAndSort(node ThisNodeObject)
    {
        if(NodeArray == null)
        NodeArray = new ArrayList<node>();

        node methodCaller = new node();
        Log.d("object =====", ThisNodeObject.getNameSpecialRequest());
            NodeArray.add(ThisNodeObject);
              Log.d("new size of array =====", String.valueOf(NodeArray.size()));

        if (NodeArray.size() > 1) {
               Log.d("Size 0 why am I here?!", String.valueOf(NodeArray.size()));
            for (int j = 0; j < NodeArray.size()-1; j++) {
                boolean i = methodCaller.isDateOneLaterThanDateTwo(NodeArray.get(j), NodeArray.get(j + 1));
                Log.d("boolean value", String.valueOf(i));
                if (!methodCaller.isDateOneLaterThanDateTwo(NodeArray.get(j), NodeArray.get(j + 1))) {
                    Log.d("j =====", String.valueOf(j));
                    node temp = NodeArray.get(j);
                    NodeArray.set(j, NodeArray.get(j + 1));
                    j++;
                    NodeArray.set(j, temp);
                    j = 0;
                }
            }
        }

        return NodeArray;
    }
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

    public void setNameSR(String _nameSpecialRequest) { this.nameSpecialRequest = _nameSpecialRequest; }

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

    public  List<node> getNodeArray() {
        return NodeArray;
    }

     /***********************************************
     *  The Following code implements the date picker dialog and allows
     *  a user to select a specific date.
     ***********************************************/
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

            TextView mydate = (TextView)findViewById(R.id.textView1);

            year_x = year;
            month_x =  month + 1;
            day_x = dayOfMonth;
            String monthString = new DateFormatSymbols().getMonths()[month];
            Toast.makeText(extraFeatures.this, "Date set to " + monthString + " " + day_x+", " + year_x, Toast.LENGTH_LONG).show();
            mydate.setText("Date set to " + monthString + " " + day_x+", " + year_x);

            //This sets the date ints into a date object
            calObject.set(Calendar.MONTH, month_x);
            calObject.set(Calendar.DATE, day_x);
            calObject.set(Calendar.YEAR, year_x);

        }
    };

    // end of date picker dialogue.
    public void setAlarm(String message, Calendar myCal) {
        Long alertTime = myCal.getTimeInMillis() + 5*1000;
        Intent alertIntent = new Intent(this, AlertReceiver.class);
        //allows to set at different dates.
        AlarmManager alarmManager = (AlarmManager)
                getSystemService(Context.ALARM_SERVICE);
        Log.d("ALERT", "you made it here.2");
        alarmManager.set(AlarmManager.RTC_WAKEUP, alertTime,
                PendingIntent.getBroadcast(this, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
        Log.d("ALERT", "you made it here.3");
    }


}
