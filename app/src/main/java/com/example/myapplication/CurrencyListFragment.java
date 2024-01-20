package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.CurrencyCalculator.CurrencyRate;
import com.example.myapplication.CurrencyCalculator.CurrencyRateAdapter;
import com.example.myapplication.CurrencyCalculator.DBHelper;
import com.example.myapplication.databinding.FragmentCurrencyListBinding;

import java.util.ArrayList;
import java.util.List;

public class CurrencyListFragment extends Fragment {
    FragmentCurrencyListBinding binding;
    private ArrayList<CurrencyRate> rates;
    private static final String LOG_TAG = "Db_logs";

    public CurrencyListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false);
        ItemViewModel viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        rates = viewModel.getRates();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        ContentValues cv = new ContentValues();
        ListView listView = binding.currencyList;
        List<CurrencyRate> listTool = rates;
        CurrencyRateAdapter adapter = new CurrencyRateAdapter(view.getContext(), listTool);
        listView.setAdapter(adapter);
    }
}