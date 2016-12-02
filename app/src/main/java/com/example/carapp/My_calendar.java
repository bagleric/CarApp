package com.example.carapp;

import java.util.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

public class My_calendar extends AppCompatActivity {
    final String[] services = {};
    private static final String TAG = Information_.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar);
        final ListView listView = (ListView) findViewById(R.id.serviceList);

        // Defined Array values to show in ListView
        Log.i("Calendar", "You made it to the calendar");
        /////////////////////////////////////
        String date = "11/22/2016";
        String parts[] = date.split("/");

        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        Log.d(TAG, "set Content View " + year);
        calendar.set(Calendar.MONTH, month);
        Log.d(TAG, "set Content View " + month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Log.d(TAG, "set Content View " + day);
        long milliTime = calendar.getTimeInMillis();
        CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.calendarView2); // get the reference of CalendarView
        //simpleCalendarView.setSelectedDateVerticalBar(getResources().getDrawable(R.drawable.ic_launcher)); // set the drawable for the vertical bar
        //////////////////////////////////////////////////////


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, services);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
                Log.i("Calendar", "You made it to the calendar");
            }

        });
    }


//public void addService(Service theService){
//    services[services.length] = theService.name + ": " + theService.getNextServiceDate() + " or " + theService.getNextServiceMiles();
//}

}
