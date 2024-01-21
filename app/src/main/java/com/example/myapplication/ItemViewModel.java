package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.CurrencyCalculator.CurrencyRate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ItemViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<CurrencyRate>> currencyRates = new MutableLiveData<>();
    private final MutableLiveData<CurrencyRate> currencyRate = new MutableLiveData<>();
    public ArrayList<CurrencyRate> getRates(){
        return currencyRates.getValue();
    }

    public void setRates(ArrayList<CurrencyRate> rates){
        currencyRates.setValue(rates);
    }

    public void setSelectRate(CurrencyRate rate){
        currencyRate.setValue(rate);
    }

    public LiveData<CurrencyRate> getSelectedRate(){
        return currencyRate;
    }
}
