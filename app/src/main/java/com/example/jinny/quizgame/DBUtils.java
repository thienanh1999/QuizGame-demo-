package com.example.jinny.quizgame;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.jinny.quizgame.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung's PC on 3/31/2018.
 */

public class DBUtils {

    private static final String TAG = "DBUtils";

    private static final String TABLE_COUNTRY = "Countries";

    private SQLiteDatabase sqLiteDatabase;
    private MyDatabase myDatabase;

    private static DBUtils dbUtils;

    public DBUtils(Context context) {
        myDatabase = new MyDatabase(context);
    }

    public static DBUtils getInstance(Context context) {
        if (dbUtils == null) {
            dbUtils = new DBUtils(context);
        }
        return dbUtils;
    }

    public List<Country> getAllCountries() {
        List<Country> listCountries = new ArrayList<>();
        sqLiteDatabase = myDatabase.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_COUNTRY, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int ID = cursor.getInt(0);
            String name = cursor.getString(1);
            String url = cursor.getString(2);
            listCountries.add(new Country(ID, name, url));
            cursor.moveToNext();
        }
        Log.d(TAG, "getAllCountries: " + listCountries.size());
        return listCountries;
    }
}
