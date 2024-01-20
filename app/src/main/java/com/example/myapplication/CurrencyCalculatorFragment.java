package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

public class CurrencyCalculatorFragment extends Fragment {
    private FragmentCurrencyCalculatorBinding binding;
    ArrayList<String> currencyCode;
    private final Calculator calculator = new Calculator();



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
        ArrayList<CurrencyRate> rates = viewModel.getRates();
        ArrayList<String> currencyCodes = new ArrayList<>();
        rates.forEach(item -> currencyCodes.add(item.getCurrencyCodeL()));

        Spinner sourceRatioSp = binding.sourceRatioSp;
        Spinner targetRatioSp = binding.targetRatioSp;
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
        calculateBtn.setOnClickListener(view1 -> {
            EditText currencyValueText = binding.sourceRatioValue;
            TextView resultText = binding.resultText;
            Spinner sourceCurrency = binding.sourceRatioSp;
            Spinner targetCurrency = binding.targetRatioSp;

            Integer currencyValue = Integer.getInteger(currencyValueText.getText().toString());
            calculator.setValue_to_exchange(currencyValue);
            Float result = calculator.calculate();

            resultText.setText(String.valueOf(result));
        });
    }
}