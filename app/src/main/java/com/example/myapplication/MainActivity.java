package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.CurrencyCalculator.Calculator;
import com.example.myapplication.CurrencyCalculator.CurrencyRate;
import com.example.myapplication.CurrencyCalculator.DBHelper;
import com.example.myapplication.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "app_logs";
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ArrayList<CurrencyRate> rates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        ItemViewModel viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        rates = getList();
        viewModel.setRates(rates);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph())
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private ArrayList<CurrencyRate> getList(){
        DBHelper dbHelper = new DBHelper(binding.getRoot().getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        rates= new ArrayList<>();
        Log.d(LOG_TAG, "------ Rows in currency_rate--------");
        Cursor c = db.query("currency_rate", null,null,null, null, null,null);

        if (c.moveToFirst()){
            int currencyCodeLColIndex = c.getColumnIndex("currencyCodeL");
            int unitsColIndex = c.getColumnIndex(("units"));
            int amountColIndex = c.getColumnIndex(("amount"));
            Log.d(LOG_TAG,"start read data from db: ");
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