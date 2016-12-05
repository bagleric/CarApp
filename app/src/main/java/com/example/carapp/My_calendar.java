package com.example.carapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class My_calendar extends AppCompatActivity {
    final String[] services = {};
    private static final String TAG = Information_.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar);
        final ListView listView = (ListView) findViewById(R.id.serviceList);
        populateServices();

        // Defined Array values to show in ListView
        Log.i("Calendar", "You made it to the calendar");

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

    private void populateServices() {
        MainActivity main = new MainActivity();

        List<node> serviceList = new ArrayList<node>();
        serviceList= main.getNodeArray();
        if(serviceList != null) {
            for (int i = 0; i < serviceList.size(); i++) {
                String thService = serviceList.get(i).getDateFormat() + " " + serviceList.get(i).getNameSpecialRequest();
                services[i] = thService;
                Log.i("Calendar", "creating the list");
            }
        }
    }


//public void addService(Service theService){
//    services[services.length] = theService.name + ": " + theService.getNextServiceDate() + " or " + theService.getNextServiceMiles();
//}

}
