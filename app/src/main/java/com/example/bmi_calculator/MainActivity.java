package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight;
    private EditText editTextHeight;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        textViewResult = findViewById(R.id.textViewResult);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightString = editTextWeight.getText().toString();
        String heightString = editTextHeight.getText().toString();

        if (!weightString.isEmpty() && !heightString.isEmpty()) {
            double weight = Double.parseDouble(weightString);
            double height = Double.parseDouble(heightString);

            double bmi = calculateBMIValue(weight, height);
            String bmiCategory = getBMICategory(bmi);

            textViewResult.setText("BMI: " + bmi + "\nBMI Category: " + bmiCategory);
        } else {
            textViewResult.setText("Please enter both weight and height.");
        }
    }

    private double calculateBMIValue(double weight, double height) {
        // Formula to calculate BMI: weight (kg) / (height (m) * height (m))
        return weight / (height * height);
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
