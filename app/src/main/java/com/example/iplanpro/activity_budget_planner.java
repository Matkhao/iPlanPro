package com.example.iplanpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;
import java.util.Map;

public class activity_budget_planner extends AppCompatActivity {

    EditText budgetInput;
    Button checkButton;
    TextView resultHeader, bestModelDetail;
    ImageButton backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_planner);

        budgetInput = findViewById(R.id.budgetInput);
        checkButton = findViewById(R.id.checkButton);
        resultHeader = findViewById(R.id.resultHeader);
        bestModelDetail = findViewById(R.id.bestModelDetail);
        backToMain = findViewById(R.id.backToMain);

        // ราคาประมาณของรุ่น
        Map<String, Integer> iphonePrices = new LinkedHashMap<>();
        iphonePrices.put("iPhone 7", 6500);
        iphonePrices.put("iPhone 8", 8000);
        iphonePrices.put("iPhone XR", 9500);
        iphonePrices.put("iPhone XS", 10500);
        iphonePrices.put("iPhone 11", 12000);
        iphonePrices.put("iPhone 12", 14500);
        iphonePrices.put("iPhone 13", 16000);
        iphonePrices.put("iPhone 14", 19000);
        iphonePrices.put("iPhone 15", 22000);

        // ข้อมูล 7 หัวข้อที่ต้องรู้
        Map<String, String> iphoneSpecs = new LinkedHashMap<>();
        iphoneSpecs.put("iPhone 7", "" +
                "• รุ่น: iPhone 7\n" +
                "• ปีที่เปิดตัว: 2016\n" +
                "• ขนาดหน้าจอ: 4.7\" Retina HD\n" +
                "• กล้องหลัก: 12MP เดี่ยว\n" +
                "• ชิปประมวลผล: A10 Fusion\n" +
                "• ความสามารถเด่น: กันน้ำ IP67, ปุ่มโฮมแบบสัมผัส\n" +
                "• ระบบชาร์จ: Lightning");
        iphoneSpecs.put("iPhone 8", "" +
                "• รุ่น: iPhone 8\n" +
                "• ปีที่เปิดตัว: 2017\n" +
                "• ขนาดหน้าจอ: 4.7\" Retina HD\n" +
                "• กล้องหลัก: 12MP เดี่ยว\n" +
                "• ชิปประมวลผล: A11 Bionic\n" +
                "• ความสามารถเด่น: รองรับชาร์จไร้สาย\n" +
                "• ระบบชาร์จ: Lightning");
        iphoneSpecs.put("iPhone XR", "" +
                "• รุ่น: iPhone XR\n" +
                "• ปีที่เปิดตัว: 2018\n" +
                "• ขนาดหน้าจอ: 6.1\" Liquid Retina\n" +
                "• กล้องหลัก: 12MP เดี่ยว\n" +
                "• ชิปประมวลผล: A12 Bionic\n" +
                "• ความสามารถเด่น: Face ID, แบตอึด\n" +
                "• ระบบชาร์จ: Lightning");
        iphoneSpecs.put("iPhone XS", "" +
                "• รุ่น: iPhone XS\n" +
                "• ปีที่เปิดตัว: 2018\n" +
                "• ขนาดหน้าจอ: 5.8\" OLED\n" +
                "• กล้องหลัก: กล้องคู่ 12MP\n" +
                "• ชิปประมวลผล: A12 Bionic\n" +
                "• ความสามารถเด่น: กันน้ำ IP68\n" +
                "• ระบบชาร์จ: Lightning");
        iphoneSpecs.put("iPhone 11", "" +
                "• รุ่น: iPhone 11\n" +
                "• ปีที่เปิดตัว: 2019\n" +
                "• ขนาดหน้าจอ: 6.1\" Liquid Retina\n" +
                "• กล้องหลัก: กล้องคู่ (Wide + Ultra Wide)\n" +
                "• ชิปประมวลผล: A13 Bionic\n" +
                "• ความสามารถเด่น: Night Mode\n" +
                "• ระบบชาร์จ: Lightning");
        iphoneSpecs.put("iPhone 12", "" +
                "• รุ่น: iPhone 12\n" +
                "• ปีที่เปิดตัว: 2020\n" +
                "• ขนาดหน้าจอ: 6.1\" OLED\n" +
                "• กล้องหลัก: กล้องคู่ 12MP\n" +
                "• ชิปประมวลผล: A14 Bionic\n" +
                "• ความสามารถเด่น: รองรับ 5G, MagSafe\n" +
                "• ระบบชาร์จ: Lightning");
        iphoneSpecs.put("iPhone 13", "" +
                "• รุ่น: iPhone 13\n" +
                "• ปีที่เปิดตัว: 2021\n" +
                "• ขนาดหน้าจอ: 6.1\" OLED\n" +
                "• กล้องหลัก: กล้องคู่ (Wide + Ultra Wide)\n" +
                "• ชิปประมวลผล: A15 Bionic\n" +
                "• ความสามารถเด่น: วิดีโอ Cinematic\n" +
                "• ระบบชาร์จ: Lightning + MagSafe");
        iphoneSpecs.put("iPhone 14", "" +
                "• รุ่น: iPhone 14\n" +
                "• ปีที่เปิดตัว: 2022\n" +
                "• ขนาดหน้าจอ: 6.1\" OLED\n" +
                "• กล้องหลัก: กล้องคู่ 12MP\n" +
                "• ชิปประมวลผล: A15 Bionic\n" +
                "• ความสามารถเด่น: Crash Detection, Emergency SOS\n" +
                "• ระบบชาร์จ: Lightning + MagSafe");
        iphoneSpecs.put("iPhone 15", "" +
                "• รุ่น: iPhone 15\n" +
                "• ปีที่เปิดตัว: 2023\n" +
                "• ขนาดหน้าจอ: 6.1\" OLED\n" +
                "• กล้องหลัก: 48MP + Ultra Wide\n" +
                "• ชิปประมวลผล: A16 Bionic\n" +
                "• ความสามารถเด่น: Dynamic Island, USB-C\n" +
                "• ระบบชาร์จ: USB-C");

        // ปุ่มคำนวณ
        checkButton.setOnClickListener(v -> {
            String input = budgetInput.getText().toString().trim();
            resultHeader.setVisibility(View.VISIBLE);
            bestModelDetail.setVisibility(View.VISIBLE);

            if (input.isEmpty()) {
                resultHeader.setText("กรุณาใส่งบประมาณของคุณ");
                bestModelDetail.setText("");
                return;
            }

            int budget = Integer.parseInt(input);
            String bestModel = null;
            int bestPrice = -1;

            for (Map.Entry<String, Integer> entry : iphonePrices.entrySet()) {
                if (entry.getValue() <= budget && entry.getValue() > bestPrice) {
                    bestPrice = entry.getValue();
                    bestModel = entry.getKey();
                }
            }

            if (bestModel == null) {
                resultHeader.setText("ไม่พบ iPhone ที่เหมาะสม");
                bestModelDetail.setText("งบของคุณอาจไม่เพียงพอสำหรับรุ่นใด ๆ");
            } else {
                resultHeader.setText("รุ่นแนะนำที่เหมาะกับงบของคุณ");
                bestModelDetail.setText(iphoneSpecs.get(bestModel));
            }
        });

        // ปุ่มย้อนกลับ
        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(activity_budget_planner.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
