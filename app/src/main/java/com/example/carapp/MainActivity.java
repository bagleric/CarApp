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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //String make;
    public static final String PREFS_NAME = "MyPrefsFile";

    private int oilMiles;
    private int tireMiles;
    private int driverMiles;
    private static final String TAG = MainActivity.class.getSimpleName();//////


    List<node> NodeArray = new ArrayList<node>();

    public List<node> addToNodeArrayAndSort(node ThisNodeObject)
    {

        Log.d(TAG, "trying to add to array");
        node methodCaller = new node();
        if(NodeArray.size() < 1) {
            NodeArray.add(ThisNodeObject);
          //  Log.d("Size of array =====", String.valueOf(NodeArray.size()));
        }
        else{
            NodeArray.add(ThisNodeObject);
          //  Log.d("new size of array =====", String.valueOf(NodeArray.size()));
        }
        if(NodeArray.size() > 1) {
         //   Log.d("Size 0 why am I here?!", String.valueOf(NodeArray.size()));
            for (int j = 0; j < NodeArray.size(); j++) {
                if (methodCaller.isDateOneLaterThanDateTwo(NodeArray.get(j), NodeArray.get(j + 1))) {
                    node temp = NodeArray.get(j);
                    NodeArray.set(j, NodeArray.get(j + 1));
                    j++;
                    NodeArray.set(j, temp);
                    j = 0;
                }
            }
        }
        Log.d("new size of array =====", String.valueOf(NodeArray.size()));
        for(int k = 0; k < NodeArray.size(); k++)
            Log.d("new size of array =====", NodeArray.get(k).toString());

        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(NodeArray);
        editor.putString(TAG, json);
        editor.commit();
        return NodeArray;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);


        Log.d("new size of array =====", String.valueOf(NodeArray.size()));
        for(int k = 0; k < NodeArray.size(); k++)
            Log.d("new size of array =====", NodeArray.get(k).toString());

    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first


        Button buttonTire = (Button) findViewById(R.id.tireButton);
        buttonTire.setOnClickListener(tireListener);

        Button buttonButton = (Button) findViewById(R.id.addButton);
        buttonButton.setOnClickListener(addListener);

        Button buttonInsurance = (Button) findViewById(R.id.carButton);
        buttonInsurance.setOnClickListener(carListener);

        Button buttonOil = (Button) findViewById(R.id.oilButton);
        buttonOil.setOnClickListener(oilListener);
        Service oil = new Service();

        Button CalendarButton  = (Button) findViewById(R.id.ServiceCalendar);
        CalendarButton.setOnClickListener(ServiceCalendarListener);
        Service ServiceCal = new Service();

    }

    private View.OnClickListener ServiceCalendarListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.ServiceCalendar);
            Intent calendar = new Intent(MainActivity.this, My_calendar.class);
            startActivity(calendar);
        }
    };
        private View.OnClickListener oilListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.oilButton);
            button.setText("Oil Changed! Great Job!");
            Intent calendar = new Intent(MainActivity.this, My_calendar.class);
            startActivity(calendar);
        }
    };

    private View.OnClickListener carListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.carButton);
            //button.setText("You Need insurance!");
            Intent information = new Intent(MainActivity.this, Information_.class);
startActivity(information);
            //Toast.makeText(MainActivity.this, v, Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener addListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.addButton);
            //button.setText("You touched the add button!");
            Intent add = new Intent(MainActivity.this, extraFeatures.class);
            startActivity(add);
        }
    };

    private View.OnClickListener tireListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.tireButton);
            //button.setText("You touched the tire button!");
            Intent calendar = new Intent(MainActivity.this, My_calendar.class);
            startActivity(calendar);
            //Toast.makeText(MainActivity.this, ("You Need Tires!"), Toast.LENGTH_LONG).show();
        }
    };

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
    public  List<node> getNodeArray() {
        extraFeatures e = new extraFeatures();
        return e.NodeArray;
    }

}


//        ///////////////////////
//        //application life cycle
//        if (savedInstanceState != null) {
//            // Restore value of members from saved state
//              Log.d(TAG, "onCreate() Restoring previous state");
//
//        } else {
//            // Probably initialize members with default values for a new instance
//            Log.d(TAG, "onCreate() No saved state available");
//            Intent add = new Intent(MainActivity.this, Information_.class);
//            Log.d(TAG, "added intent");
//            startActivity(add);
//            Log.d(TAG, "started activity1");
//        }