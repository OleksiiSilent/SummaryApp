package com.example.myapplication.CurrencyCalculator;

public class CurrencyRate {
    private int id;
    private String startDate;
    private String currencyCode;
    private String currencyCodeL;
    private int units;
    private float amount;

    public CurrencyRate(String currencyCodeL, int units, float amount) {
        this.currencyCodeL = currencyCodeL;
        this.units = units;
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCodeL() {
        return currencyCodeL;
    }

    public void setCurrencyCodeL(String currencyCodeL) {
        this.currencyCodeL = currencyCodeL;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
