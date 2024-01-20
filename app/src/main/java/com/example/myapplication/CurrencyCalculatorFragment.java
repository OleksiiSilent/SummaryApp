package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.CurrencyCalculator.Calculator;
import com.example.myapplication.databinding.FragmentCurrencyCalculatorBinding;
import com.example.myapplication.databinding.FragmentMainHostBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrencyCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrencyCalculatorFragment extends Fragment {

    private FragmentCurrencyCalculatorBinding binding;
    private Calculator calculator = new Calculator();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrencyCalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrencyCalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrencyCalculatorFragment newInstance(String param1, String param2) {
        CurrencyCalculatorFragment fragment = new CurrencyCalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCurrencyCalculatorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        Button calculateBtn = binding.caclExchangeBtn;
        calculateBtn.setOnClickListener(view1 -> {
            EditText currencyValueText = binding.sourceRatioValue;
            TextView resultText = binding.resultText;

            Integer currencyValue = Integer.getInteger(currencyValueText.getText().toString());
            calculator.setValue_to_exchange(currencyValue);
            Float result = calculator.calculate();

            resultText.setText(String.valueOf(result));
        });
    }
}