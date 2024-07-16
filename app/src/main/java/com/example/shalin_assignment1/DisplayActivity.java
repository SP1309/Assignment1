package com.example.shalin_assignment1;

import static com.example.shalin_assignment1.R.id.displayTextView;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class DisplayActivity extends AppCompatActivity {

    Car toyota = new Car("Toyota Camry", "2023", "2.5L 4-cylinder engine", "$25,000");
    Car ford = new Car("Ford F-150", "2023", "3.3L V6 engine", "$30,000");
    Car bmw = new Car("BMW 3 Series", "2023", "2.0L 4-cylinder engine", "$41,000");
    Car honda = new Car("Honda Civic", "2023", "2.0L 4-cylinder engine", "$22,000");
    Car chev = new Car("Chevrolet Camaro", "2023", "6.2L V8 engine", "$40,000");

    Car[] carlist = {toyota, ford, bmw, honda, chev};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView displayTextView = findViewById(R.id.displayTextView);

        // Get the intent and retrieve the data

        TextView displayCarName = findViewById(R.id.displayCarName);
        TextView displayLaunchYear = findViewById(R.id.displayLaunchYear);
        TextView displayEngine = findViewById(R.id.displayEngine);
        TextView displayCarPrice = findViewById(R.id.displayCarPrice);

        // Get the intent and retrieve the Car object
        String selectedCar = getIntent().getStringExtra("selectedCarCompany");
        Car selectedCarModel = getCar(selectedCar, carlist);

        // Display the car details
        displayCarName.setText(selectedCarModel.carName);
        displayLaunchYear.setText(selectedCarModel.launchYear);
        displayEngine.setText(selectedCarModel.engine);
        displayCarPrice.setText(selectedCarModel.carPrice);

        // Display the selected car company
        //displayTextView.setText("Selected Car Company: " + selectedCarCompany);
    }

    Car getCar(String car, Car[] carlist) {
        for (Car c : carlist) {
            if (c.carName.equals(car))
                return c;
        }
        return null;
    }
}

class Car {
    String carName;
    String carPrice;
    String launchYear;
    String engine;

    public Car(String carName, String launchYear, String engine, String carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
        this.engine = engine;
        this.launchYear = launchYear;
    }
}
