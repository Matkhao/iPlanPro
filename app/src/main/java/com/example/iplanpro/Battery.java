package com.example.iplanpro;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Battery extends AppCompatActivity {

    Spinner productSpinner, modelSpinner;
    TextView resultText, resultHeader , resultSubText;
    Button calculateButton;
    ImageButton backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        productSpinner = findViewById(R.id.productSpinner);
        modelSpinner = findViewById(R.id.modelSpinner);
        resultHeader = findViewById(R.id.resultHeader);
        resultSubText = findViewById(R.id.resultSubText);
        resultText = findViewById(R.id.resultText);
        calculateButton = findViewById(R.id.calculateButton);
        backToMain = findViewById(R.id.backToMain);

        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(Battery.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        String[] products = {"iPhone"};
        String[] iphoneModels = {"iPhone SE", "iPhone 7", "iPhone 8", "iPhone XR", "iPhone XS",
                "iPhone 11", "iPhone 12", "iPhone 13", "iPhone 14", "iPhone 15", "iPhone 16"};

        ArrayAdapter<String> productAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, products);
        productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        productSpinner.setAdapter(productAdapter);

        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, iphoneModels);
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelAdapter);

        calculateButton.setOnClickListener(v -> {
            String model = modelSpinner.getSelectedItem().toString();
            int price;

            switch (model) {
                case "iPhone SE":
                    price = 1900;
                    break;
                case "iPhone 7":
                case "iPhone 8":
                    price = 2000;
                    break;
                case "iPhone XR":
                case "iPhone XS":
                case "iPhone 11":
                case "iPhone 12":
                case "iPhone 13":
                    price = 2200;
                    break;
                case "iPhone 14":
                case "iPhone 15":
                case "iPhone 16":
                    price = 3200;
                    break;
                default:
                    price = 0;
            }

            resultHeader.setVisibility(View.VISIBLE);
            resultSubText.setVisibility(View.VISIBLE);
            resultText.setVisibility(View.VISIBLE);

            resultHeader.setText("ค่าใช้จ่ายโดยประมาณของคุณ");
            resultSubText.setText("เราจะตรวจสอบความคุ้มครองการบริการของคุณเพื่อประเมินค่าธรรมเนียมการให้บริการขั้นสุดท้าย");
            resultText.setText("฿ " + String.format("%,d", price));
        });
    }
}
