package com.example.myapplication.CurrencyCalculator;

public class Calculator {
    private float rate = 0F;
    private int value_to_exchange = 0;

    public float getRate() {
        return rate;
    }

    private void setRate(float rate) {
        this.rate = rate;
    }

    public void setValue_to_exchange(int value_to_exchange) {
        this.value_to_exchange = value_to_exchange;
    }

    public float calculate(){
        return value_to_exchange * rate;
    }
}
