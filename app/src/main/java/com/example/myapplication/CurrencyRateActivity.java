package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CurrencyRateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_rates_layout);
    }

    public void goToMainActivity(View v){
        Intent intent = new Intent("MainActivity");
        startActivity(intent);
    }
}