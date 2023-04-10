package com.example.cars4sales;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    // create array of Strings and store name of cars
    String[] cars = { "BMW X5", "BMW X6",
            "Dodge Challenger SRT", "Dodge Charger SRT",
            "Ford Cobra GT" };
    List<String> carList = new ArrayList<>(Arrays.asList(cars));
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        Spinner spinr = findViewById(R.id.carspinner);
        spinr.setOnItemSelectedListener(this);

        Collections.sort(carList);
        carList.add(0, "Car City!");

        ArrayAdapter<String> spinnerAd = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, carList);
        // Initializing ArrayAdapter as anonymous class

        /*
        ArrayAdapter<String> spinnerAd = new ArrayAdapter<String>(
                this, R.layout.spinner_item, carList) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView,
                        parent);

                return view;
            }
        };
        */

        // set simple layout resource file for each spinner item
       spinnerAd.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data to bind data to Spinner
       spinr.setAdapter(spinnerAd);
    }

    // Performing action when ItemSelected from spinner, Overriding onItemSelected method

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int
            position, long id) {
        if(position != 0)
        // make toast show which is selected in spinner
        Toast.makeText(getApplicationContext(),
                        carList.get(position),
                        Toast.LENGTH_LONG)
                .show();
        switch (position) {
            case 1: //run query 1
                    break;

            case 2: //run query 2
                    break;

        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {  }
}
