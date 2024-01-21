package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.databinding.FragmentTipCalculatorBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TipCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipCalculatorFragment extends Fragment {
    private FragmentTipCalculatorBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TipCalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipCalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TipCalculatorFragment newInstance(String param1, String param2) {
        TipCalculatorFragment fragment = new TipCalculatorFragment();
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
        binding = FragmentTipCalculatorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText receiptValueTxt = binding.tipReceiptAmount;
        EditText tipPercentTxt = binding.tipPercent;
        TextView tipAmountTxt = binding.txtTipAmount;
        TextView receiptAmountTxt = binding.receiptAmount;
        EditText peopleNumberText = binding.peopleNumber;
        TextView amountPerPersonTxt = binding.amountPerPerson;

        binding.tipCalculateBtn.setOnClickListener(view1 -> {

            Float receiptValue = Float.valueOf(receiptValueTxt.getText().toString());
            Float tipPercent = Float.valueOf(tipPercentTxt.getText().toString()) / 100F;
            Float tipAmount = receiptValue*tipPercent;
            tipAmountTxt.setText(String.format("%.2f", tipAmount));
            receiptAmountTxt.setText(String.format("%.2f", (receiptValue + tipAmount)));
        });

        binding.splitReceiptBtn.setOnClickListener(view1 -> {
            float receiptAmount = Float.parseFloat(receiptAmountTxt.getText().toString());
            int peopleNumber = Integer.parseInt(peopleNumberText.getText().toString());
            float amountPerPerson = 0F;
            boolean b = !(receiptAmount == 0f);
            if (b) {
                amountPerPerson = receiptAmount / peopleNumber;
            }
            amountPerPersonTxt.setText(String.format("%.2f", amountPerPerson));
        });
    }
}