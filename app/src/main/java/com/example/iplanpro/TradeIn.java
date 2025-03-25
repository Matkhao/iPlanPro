package com.example.iplanpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class TradeIn extends AppCompatActivity {

    Spinner oldModelSpinner, newModelSpinner;
    Button calculateButton;
    TextView resultText, resultHeader;
    ImageButton backToMain;

    // ราคาประเมิน Trade-In (โดยประมาณ)
    HashMap<String, Integer> tradeInPrices = new HashMap<>();
    // ราคาขาย iPhone ใหม่ (สมมุติ)
    HashMap<String, Integer> newPhonePrices = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_in);

        oldModelSpinner = findViewById(R.id.oldModelSpinner);
        newModelSpinner = findViewById(R.id.newModelSpinner);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);
        resultHeader = findViewById(R.id.resultHeader);
        backToMain = findViewById(R.id.backToMain);

        String[] iphoneModels = {"iPhone 7", "iPhone 8", "iPhone XR", "iPhone XS", "iPhone 11",
                "iPhone 12", "iPhone 13", "iPhone 14", "iPhone 15"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, iphoneModels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        oldModelSpinner.setAdapter(adapter);
        newModelSpinner.setAdapter(adapter);

        // กำหนดราคาประเมิน Trade-In
        tradeInPrices.put("iPhone 7", 1000);
        tradeInPrices.put("iPhone 8", 1500);
        tradeInPrices.put("iPhone XR", 2000);
        tradeInPrices.put("iPhone XS", 2200);
        tradeInPrices.put("iPhone 11", 2500);
        tradeInPrices.put("iPhone 12", 3000);
        tradeInPrices.put("iPhone 13", 3500);
        tradeInPrices.put("iPhone 14", 4000);
        tradeInPrices.put("iPhone 15", 4500);

        // กำหนดราคาขายเครื่องใหม่
        newPhonePrices.put("iPhone 7", 6500);
        newPhonePrices.put("iPhone 8", 8000);
        newPhonePrices.put("iPhone XR", 9500);
        newPhonePrices.put("iPhone XS", 10500);
        newPhonePrices.put("iPhone 11", 12000);
        newPhonePrices.put("iPhone 12", 14500);
        newPhonePrices.put("iPhone 13", 16000);
        newPhonePrices.put("iPhone 14", 19000);
        newPhonePrices.put("iPhone 15", 22000);

        calculateButton.setOnClickListener(v -> {
            String oldModel = oldModelSpinner.getSelectedItem().toString();
            String newModel = newModelSpinner.getSelectedItem().toString();

            int oldPrice = tradeInPrices.getOrDefault(oldModel, 0);
            int newPrice = newPhonePrices.getOrDefault(newModel, 0);

            int difference = newPrice - oldPrice;
            if (difference < 0) difference = 0;

            resultHeader.setVisibility(View.VISIBLE);
            resultText.setVisibility(View.VISIBLE);

            resultText.setText("฿ " + String.format("%,d", difference));
        });

        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(TradeIn.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
