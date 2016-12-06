package com.example.carapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

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
        Log.d(TAG, "test ======================= 2");
        /////////////////////here we are saving the array
//        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
//        Gson gson = new Gson();

        /////////////////////////here we are reading the array from the saved state, and setting it
//        String json = sharedPrefs.getString("ArrayList", "NodeArray");
//        Type type = new TypeToken<ArrayList<node>>() {}.getType();
//        ArrayList<node> arrayList = gson.fromJson(json, type);

//        if(NodeArray != null)
//            NodeArray = new ArrayList<node>(arrayList);
        Log.d(TAG, "trying to add to array");
        node methodCaller = new node();
        if(NodeArray.size() < 1) {
            NodeArray.add(ThisNodeObject);
            Log.d("Size of array =====", String.valueOf(NodeArray.size()));
        }
        else{
            NodeArray.add(ThisNodeObject);
            Log.d("new size of array =====", String.valueOf(NodeArray.size()));
        }
        if(NodeArray.size() > 1) {
            Log.d("Size 0 why am I here?!", String.valueOf(NodeArray.size()));
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
//
//        SharedPreferences.Editor editor = sharedPrefs.edit();
//        json = gson.toJson(NodeArray);
//        editor.putString("NodeArray", json);
//        editor.commit();
            return NodeArray;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = "";
               json =  sharedPrefs.getString("ArrayList", json);
        Type type = new TypeToken<ArrayList<node>>() {}.getType();
        ArrayList<node> arrayList = gson.fromJson(json, type);

        if(arrayList != null)
        NodeArray = new ArrayList<node>(arrayList);

        Information_ info = new Information_();

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

    }

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