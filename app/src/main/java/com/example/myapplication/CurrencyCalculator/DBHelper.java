package com.example.myapplication.CurrencyCalculator;
import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "SummaryDB", null, 1);;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table currency_rate ("
                + "id integer primary key autoincrement,"
                + "startDate text,"
                + "currencyCode text,"
                + "currencyCodeL text,"
                + "units integer,"
                + "amount real" + ");" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS currency_rate");
        onCreate(db);
    }
}
