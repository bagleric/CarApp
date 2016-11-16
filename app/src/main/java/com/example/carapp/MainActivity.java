package com.example.carapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String make;
    private int oilMiles;
    private int tireMiles;
    private int driverMiles;
    SharedPreferences prefs = null;//////////////////////////
    public static final String PREFS_NAME = "MyPrefsFile";/////////////
    private static final String TAG = MainActivity.class.getSimpleName();//////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////////////
        //application life cycle
        if (savedInstanceState != null) {
            Log.d(TAG, "onCreate() Restoring previous state");
            prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            /* restore state */
        } else {
            Log.d(TAG, "onCreate() No saved state available");
            /* initialize app */
            Intent information = new Intent(MainActivity.this, Information_.class);
            startActivity(information);
        }

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
            button.setText("You Need insurance!");
            Intent information = new Intent(MainActivity.this, Information_.class);
startActivity(information);
            //Toast.makeText(MainActivity.this, v, Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener addListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.addButton);
            button.setText("You touched the add button!");
            Intent add = new Intent(MainActivity.this, extraFeatures.class);
            startActivity(add);
        }
    };

    private View.OnClickListener tireListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button)findViewById(R.id.tireButton);
            button.setText("You touched the tire button!");
            Intent calendar = new Intent(MainActivity.this, My_calendar.class);
            startActivity(calendar);
            Toast.makeText(MainActivity.this, ("You Need Tires!"), Toast.LENGTH_LONG).show();
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


