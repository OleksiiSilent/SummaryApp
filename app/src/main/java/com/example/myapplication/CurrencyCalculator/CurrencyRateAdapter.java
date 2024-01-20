package com.example.myapplication.CurrencyCalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class CurrencyRateAdapter extends BaseAdapter {

    List<CurrencyRate> currencyRateList;
    private final LayoutInflater layoutInflater;

    public CurrencyRateAdapter(Context context, List<CurrencyRate> currencyRateList) {
        this.currencyRateList = currencyRateList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return currencyRateList.size();
    }

    @Override
    public Object getItem(int position) {
        return currencyRateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = layoutInflater.inflate(R.layout.currency_rate_layout, parent, false);
        }

        CurrencyRate rate = currencyRateList.get(position);
        TextView currencyCodeL = (TextView) view.findViewById(R.id.currency_code_l);
        TextView units = (TextView) view.findViewById(R.id.units);
        TextView amount = (TextView) view.findViewById(R.id.amount);

        currencyCodeL.setText("Валюта: " + rate.getCurrencyCodeL());
        units.setText("Одиниця: " + rate.getUnits());
        amount.setText("Курс: " + rate.getAmount());

        return view;
    }
}
