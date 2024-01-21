package com.example.myapplication.CurrencyCalculator;

public class Calculator {

    public static float calculate(
            float value_to_exchange,
            CurrencyRate source_currency,
            CurrencyRate target_currency){
        int source_unit = source_currency.getUnits();
        float target_unit = target_currency.getUnits();
        float target_amount = target_currency.getAmount();
        float source_amount = source_currency.getAmount();


        return value_to_exchange * (
                (source_currency.getAmount() / source_unit)
                        * (target_amount / target_unit));
    }
}
