package com.example.carapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int oilMiles;
    private int tireMiles;
    private int driverMiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTire = (Button) findViewById(R.id.buttonTire);
        buttonTire.setOnClickListener(kListener);

        Button buttonButton = (Button) findViewById(R.id.buttonButton);
        buttonButton.setOnClickListener(lListener);

        Button buttonInsurance = (Button) findViewById(R.id.buttonInsurance);
        buttonInsurance.setOnClickListener(jListener);

        Button buttonOil = (Button) findViewById(R.id.buttonOil);
        buttonOil.setOnClickListener(mListener);
    }
    private View.OnClickListener mListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView theTextView = (TextView)findViewById(R.id.textView);
            theTextView.setText("Your car needs Oil!");
            //Toast.makeText(MainActivity.this, v, Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener jListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView theTextView = (TextView)findViewById(R.id.textView);
            theTextView.setText("You need Insurance!");
            //Toast.makeText(MainActivity.this, v, Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener lListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calendar cal = new calendar();
            TextView theTextView = (TextView)findViewById(R.id.textView);
            String date = cal.getCurrentDate();
            theTextView.setText(date);
            //Toast.makeText(MainActivity.this, v, Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener kListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView theTextView = (TextView)findViewById(R.id.textView);
            theTextView.setText("You Need Tires!");
            //Toast.makeText(MainActivity.this, v, Toast.LENGTH_LONG).show();
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


