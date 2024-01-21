package com.example.myapplication.CurrencyCalculator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyRate {
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("TimeSign")
    private String timeSign;
    @JsonProperty("CurrencyCode")
    private String currencyCode;
    @JsonProperty("CurrencyCodeL")
    private String currencyCodeL;
    @JsonProperty("Units")
    private int units;
    @JsonProperty("Amount")
    private float amount;

    public CurrencyRate(String currencyCodeL, int units, float amount) {
        this.currencyCodeL = currencyCodeL;
        this.units = units;
        this.amount = amount;
    }

    public CurrencyRate() {
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

    public String getTimeSign() {
        return timeSign;
    }

    public void setTimeSign(String timeSign) {
        this.timeSign = timeSign;
    }

    public float convertUnitTo(CurrencyRate other){
        float other_value_per_unit = other.getAmount() / other.getUnits();
        float this_value_per_unit = this.getAmount() / this.getUnits();
        return this_value_per_unit / other_value_per_unit;
    }
}
