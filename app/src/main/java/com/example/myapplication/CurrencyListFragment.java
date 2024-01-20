package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrencyListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrencyListFragment extends Fragment {
    FragmentCurrencyListBinding binding;

    SQLiteDatabase db;

    private static final String LOG_TAG = "DB:Rates";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrencyListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrencyListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrencyListFragment newInstance(String param1, String param2) {
        CurrencyListFragment fragment = new CurrencyListFragment();
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
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        DBHelper dbHelper = new DBHelper(binding.getRoot().getContext());
        db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        ListView listView = binding.currencyList;
        List<CurrencyRate> listTool = getList();
        CurrencyRateAdapter adapter = new CurrencyRateAdapter(view.getContext(), listTool);
        listView.setAdapter(adapter);
    }

    private List<CurrencyRate> getList(){
        List<CurrencyRate> rates= new ArrayList<>();
        Log.d(LOG_TAG, "------ Rows in currency_rate--------");
        Cursor c = db.query("currency_rate", null,null,null, null, null,null);

        if (c.moveToFirst()){
            int currencyCodeLColIndex = c.getColumnIndex("currencyCodeL");
            int unitsColIndex = c.getColumnIndex(("units"));
            int amountColIndex = c.getColumnIndex(("amount"));

            do {
                rates.add(new CurrencyRate(
                        c.getString(currencyCodeLColIndex),
                        c.getInt(unitsColIndex),
                        c.getInt(amountColIndex)));
                Log.d(LOG_TAG,"startDate: "
                        + ", currencyCodeL: " + c.getInt(currencyCodeLColIndex)
                        + ", units: " + c.getString(unitsColIndex)
                        + ", amount" + c.getString((amountColIndex)));
            } while (c.moveToNext());


        }else{
            Log.d(LOG_TAG, "0 rows");
        }
        return rates;
    }
}