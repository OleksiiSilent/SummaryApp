package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
    }

    public void onClick(View view){
        Intent intent;
        int id = view.getId();
        if (id == R.id.currency_calc_btn) {
            intent = new Intent("CurrencyCalculatorActivity");
        } else if (id == R.id.currency_list_btn) {
            intent = new Intent("CurrencyRateActivity");
        } else if (id == R.id.tip_calculator) {
            intent = new Intent("TipCalculatorActivity");
        } else if (id == R.id.about) {
            intent = new Intent("InfoActivity");
        } else {
            intent = new Intent("MainActivity");
        }
        startActivity(intent);
    }
}