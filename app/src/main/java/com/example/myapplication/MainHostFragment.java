package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentMainHostBinding;

public class MainHostFragment extends Fragment {
    private FragmentMainHostBinding binding;

    public MainHostFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainHostBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.currencyCalcBtn.setOnClickListener(view1 -> NavHostFragment
                .findNavController(MainHostFragment.this)
                .navigate(R.id.currencyCalculatorFragment));

        binding.currencyListBtn.setOnClickListener((view1 -> NavHostFragment
                .findNavController(MainHostFragment.this)
                .navigate((R.id.currencyListFragment))));

        binding.tipCalculatorBtn.setOnClickListener((view1 -> NavHostFragment
                .findNavController(MainHostFragment.this)
                .navigate(R.id.tipCalculatorFragment)));

        binding.aboutBtn.setOnClickListener(view1 -> NavHostFragment
                .findNavController(MainHostFragment.this)
                .navigate(R.id.infoFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}