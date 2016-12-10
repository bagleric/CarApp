package com.example.carapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    private int oilMiles;
    private int tireMiles;
    private int driverMiles;

    List<node> NodeArray = new ArrayList<node>();
    public static final String ARRAY_NAME = "array_location";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        Gson gson = new Gson(); //this allows us to set an arrayList to a sttring value for saving
        String json = preferences.getString(ARRAY_NAME, "");//convert to string
        Log.i("Calendar", json);//debugging shows value
        if (json.length() >= 5)//make sure json string has an array in it
            json = json.substring(5);//remove the marker I use to find the json string

        Type type = new TypeToken<ArrayList<node>>() {}.getType();//convert json back to ArrayList
        NodeArray = gson.fromJson(json, type); //set it to current arrayList

        Button buttonTire = (Button) findViewById(R.id.tireButton); //these grab the buttons and set them to objects
        Button buttonOil = (Button) findViewById(R.id.oilButton);
        //this will change the oil, and tire button names to match their service dates
        if(NodeArray != null) {
        for (int i = 0; i < NodeArray.size(); i++){
                if(NodeArray.get(i).getNameSpecialRequest().equals("Oil Change"))
                {
                    if(!NodeArray.get(i).getDateFormat().equals(""))//make sure it's not blank
                    buttonOil.setText(NodeArray.get(i).getDateInStringFormat() + " " + NodeArray.get(i).getNameSpecialRequest());
                }
            if(NodeArray.get(i).getNameSpecialRequest().equals("Tire Change"))//make sure it's not blank
            {
                if(!NodeArray.get(i).getDateFormat().equals(""))
                buttonTire.setText(NodeArray.get(i).getDateInStringFormat() + " " + NodeArray.get(i).getNameSpecialRequest());
            }
        }
    }
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        Button buttonTire = (Button) findViewById(R.id.tireButton);// these four are click listeners
        buttonTire.setOnClickListener(tireListener);

        Button buttonButton = (Button) findViewById(R.id.addButton);// they wait for user input
        buttonButton.setOnClickListener(addListener);

        Button buttonInsurance = (Button) findViewById(R.id.carButton);
        buttonInsurance.setOnClickListener(carListener);

        Button buttonOil = (Button) findViewById(R.id.oilButton);
        buttonOil.setOnClickListener(oilListener);

        Button CalendarButton = (Button) findViewById(R.id.ServiceCalendar);
        CalendarButton.setOnClickListener(ServiceCalendarListener);

        //here I am calling the shared preferences so I can grab the arrayList
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //same as onCreate()
        Gson gson = new Gson();
        String json = preferences.getString(ARRAY_NAME, "");
        Log.i("Calendar", json);
        if (json.length() >= 5)
            json = json.substring(5);

        Type type = new TypeToken<ArrayList<node>>() {
        }.getType();
        NodeArray = gson.fromJson(json, type);
        //This sets the values to a defualt state incase the user deletes one from the list
        buttonOil.setText("Next oil change");
        buttonTire.setText("Next Tire Service");

        //debugging test to display list length
        if (NodeArray != null) {
            Log.d("NodeArray Size =====", Integer.toString(NodeArray.size()));

            //should the date for oil or tire change or they are deleted this will update the button name

            for (int i = 0; i < NodeArray.size(); i++) {
                if (NodeArray.get(i).getNameSpecialRequest().equals("Oil Change")) {
                    if (!NodeArray.get(i).getDateFormat().equals(""))
                        buttonOil.setText(NodeArray.get(i).getDateInStringFormat() + " " + NodeArray.get(i).getNameSpecialRequest());
                }
                if (NodeArray.get(i).getNameSpecialRequest().equals("Tire Change")) {
                    if (!NodeArray.get(i).getDateFormat().equals(""))
                        buttonTire.setText(NodeArray.get(i).getDateInStringFormat() + " " + NodeArray.get(i).getNameSpecialRequest());
                }

            }

        }

    }
    ///all these listeners acticvate if the users clicks their button
    private View.OnClickListener ServiceCalendarListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //these intents allow the user to move to
            //a different activity in the app
            Intent calendar = new Intent(MainActivity.this, My_calendar.class);
            startActivity(calendar);

        }
    };

        private View.OnClickListener oilListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            //This auto names the service for the user
            String oil = "Oil Change";
            editor.putString("SpecialService", oil); //Storing string
            //here it saves the name so it will change when we get to the
            //activity where we add the service
            editor.commit();
            //these intents allow the user to move to
            //a different activity in the app
            Intent add = new Intent(MainActivity.this, extraFeatures.class);
            startActivity(add);
        }
    };

    private View.OnClickListener carListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent information = new Intent(MainActivity.this, Information_.class);
            startActivity(information);
        }
    };

    private View.OnClickListener addListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            String spsvc = "";
            editor.putString("SpecialService", spsvc); //Storing string
            editor.commit();
            Intent add = new Intent(MainActivity.this, extraFeatures.class);
            startActivity(add);
        }
    };

    private View.OnClickListener tireListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            String oil = "Tire Change";
            editor.putString("SpecialService", oil); //Storing string
            editor.commit();
            Intent add = new Intent(MainActivity.this, extraFeatures.class);
            startActivity(add);
        }
    };
    //all the getters should we need them
    public int getOilMiles() {
        return oilMiles;
    }

    public int getTireMiles() {
        return tireMiles;
    }

    public int getDriverMiles() {
        return driverMiles;
    }

    public void setOilMiles(int Omiles) {
        this.oilMiles = Omiles;
    }

    public void setTireMiles(int Tmiles) {
        this.tireMiles = Tmiles;
    }

    public void setDriverMiles(int Dmiles) {
        this.driverMiles = Dmiles;
    }

}
