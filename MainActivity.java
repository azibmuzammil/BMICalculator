package com.example.bmicalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText heightEditText, weightEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height = Double.parseDouble(heightEditText.getText().toString());
                double weight = Double.parseDouble(weightEditText.getText().toString());
                double bmi = calculateBMI(height, weight);

                String result;

                if (bmi < 18.5) {
                    result = "Underweight";
                } else if (bmi >= 18.5 && bmi < 25) {
                    result = "Normal weight";
                } else if (bmi >= 25 && bmi < 30) {
                    result = "Overweight";
                } else {
                    result = "Obese";
                }

                resultTextView.setText("Your BMI is " + bmi + " which is considered " + result);
            }
        });
    }

    private double calculateBMI(double height, double weight) {
        // Convert height from cm to m
        height = height / 100.0;

        // Convert weight from pounds to kg
        weight = weight * 0.453592;

        return weight / (height * height);
    }
}
