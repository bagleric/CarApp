package com.example.carapp;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class My_calendar extends AppCompatActivity {
    final String[] services = {};
    private static final String TAG = Information_.class.getSimpleName();

    Button btn;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;

    @TargetApi(Build.VERSION_CODES.N)
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

        Log.i("Calendar", "Creating button date picker");
        final Calendar cal = Calendar.getInstance(Locale.US);
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        ShowDialogOnButtonClick();
    }


    public void ShowDialogOnButtonClick() {
        btn = (Button) findViewById(R.id.addService);
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
            Toast.makeText(My_calendar.this, year_x + "/" + month_x +"/" + day_x, Toast.LENGTH_LONG).show();

        }
    };



//public void addService(Service theService){
//    services[services.length] = theService.name + ": " + theService.getNextServiceDate() + " or " + theService.getNextServiceMiles();
//}

}
