package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.CurrencyCalculator.Calculator;
import com.example.myapplication.CurrencyCalculator.CurrencyRate;
import com.example.myapplication.databinding.FragmentCurrencyCalculatorBinding;
import com.example.myapplication.databinding.FragmentMainHostBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class CurrencyCalculatorFragment extends Fragment {
    private FragmentCurrencyCalculatorBinding binding;
    ArrayList<String> currencyCode;
    ArrayList<CurrencyRate> rates;

    public CurrencyCalculatorFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCurrencyCalculatorBinding.inflate(inflater, container, false);
        ItemViewModel viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        rates = viewModel.getRates();
        ArrayList<String> currencyCodes = new ArrayList<>();
        rates.forEach(item -> currencyCodes.add(item.getCurrencyCodeL()));

        Spinner sourceRatioSp = binding.sourceRatioSp;
        Spinner targetRatioSp = binding.targetRatioSp;
        Collections.sort(currencyCodes);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                binding.getRoot().getContext(),
                android.R.layout.simple_spinner_item,
                currencyCodes);
        sourceRatioSp.setAdapter(adapter);
        targetRatioSp.setAdapter(adapter);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        Button calculateBtn = binding.caclExchangeBtn;
        EditText currencyValTxt = binding.sourceRatioValue;
        Spinner sourceCurrency = binding.sourceRatioSp;
        Spinner targetCurrency = binding.targetRatioSp;

        calculateBtn.setOnClickListener(view1 -> {

            TextView resultText = binding.resultText;
            float amount_to_exchange = Float.parseFloat(currencyValTxt.getText().toString());
            String sourceCurrencyCodeL = sourceCurrency.getSelectedItem().toString();
            String targetCurrencyCodeL = targetCurrency.getSelectedItem().toString();
            Log.d("calculate", "amount: " + amount_to_exchange
                        + ", sourceCodeL: " + sourceCurrencyCodeL + ", targetCodeL: " + targetCurrencyCodeL);

            CurrencyRate source = rates.stream()
                    .filter(item -> Objects.equals(item.getCurrencyCodeL(), sourceCurrencyCodeL))
                    .findFirst()
                    .get();

            CurrencyRate target = rates.stream()
                    .filter(item -> Objects.equals(item.getCurrencyCodeL(), targetCurrencyCodeL))
                    .findFirst()
                    .get();

            Float result = source.convertUnitTo(target) * amount_to_exchange;

            resultText.setText(String.valueOf(result));
        });
    }
}