package com.example.carapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class My_calendar extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String ARRAY_NAME = "array_location";
    private static final String TAG = Information_.class.getSimpleName();

    List<node> serviceList = new ArrayList<node>();
    List<String> services = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar);

        final ListView listView = (ListView) findViewById(R.id.serviceList);

        //fill the listView with the saved services.
        populateServices();

        // Define a new Adapter:parameter 1 - Context; parameter 2 - row layout; parameter 3 - view;
        // parameter 4: the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, services);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // Listener for clicking on list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showCancelDialog(listView, position);
            }

        });

        Button buttonButton = (Button) findViewById(R.id.addButton);
        buttonButton.setOnClickListener(addListener);
    }

    private void populateServices() {
        Log.i("Calendar", "You are populating services");

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = preferences.getString(ARRAY_NAME, "");
        Log.i("Calendar", json);
        if (json.length() >= 5)
        json = json.substring(5);

        Type type = new TypeToken<ArrayList<node>>() {}.getType();
        serviceList = gson.fromJson(json, type);
        if(serviceList != null) {
            for (int i = 0; i < serviceList.size(); i++) {
                Log.d("i value", serviceList.get(i).getDateInStringFormat());
            }
        }

        if(json.equals("[]")) {
            Log.i("test===========", json);
            services.add("You don't have any services registered.");
        }

        if(serviceList == null)
            services.add("You don't have any services registered.");
        else if(serviceList != null) {

            for (int i = 0; i < serviceList.size(); i++) {
                String thService = serviceList.get(i).getDateInStringFormat() + " " + serviceList.get(i).getNameSpecialRequest();
                services.add(i, thService);
                Log.i("Calendar", "creating the list");
            }
        }

    }

    private View.OnClickListener addListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            String NewService = "";
            editor.putString("SpecialService", NewService); //Storing string
            editor.commit();
            Intent add = new Intent(My_calendar.this, extraFeatures.class);
            startActivity(add);
            finish();
        }
    };


    public void showCancelDialog(final ListView listView, final int position) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Delete Service");
        alertDialog.setMessage("Are you Sure you want to Delete This Item?");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ListView Clicked item value
                String  itemValue = (String) listView.getItemAtPosition(position);


                Log.i("Calendar", "You made it to the calendar");

                serviceList.remove(position);
                // Show Alert

                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                Gson gson = new Gson();

                String json = "value" + gson.toJson(serviceList);
                Log.d("array =====", json);
                editor.putString(ARRAY_NAME, json);
                editor.commit();

                Intent calendar = new Intent(My_calendar.this, My_calendar.class);
                finish();
                startActivity(calendar);
                Toast.makeText(getApplicationContext(),
                        "Deleted Service:"+itemValue , Toast.LENGTH_LONG)
                        .show();

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Delete Canceled", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
    }
}
