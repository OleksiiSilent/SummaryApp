package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_calc_layout);

        Button backButton = findViewById(R.id.back_btn);
        backButton.setOnClickListener(view -> startActivity(new Intent("MainActivity")));
    }

}