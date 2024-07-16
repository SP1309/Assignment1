package com.example.shalin_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner mySpinner;
    private Button myButton;
    private String selectedCarCompany;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner = findViewById(R.id.mySpinner);
        myButton = findViewById(R.id.myButton);

        // Setting up the Spinner
        String[] carCompanies = {"Toyota Camry", "Ford F-150", "BMW 3 Series", "Honda Civic", "Chevrolet Camaro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, carCompanies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        // Spinner listener
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCarCompany = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedCarCompany = "Toyota"; // default car company
            }
        });

        // Button listener
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the DisplayActivity
                Intent intent = new Intent(MainActivity.this, com.example.shalin_assignment1.DisplayActivity.class);
                // Pass the selected car company to the new activity
                intent.putExtra("selectedCarCompany", selectedCarCompany);
                startActivity(intent);
            }
        });
    }
}
