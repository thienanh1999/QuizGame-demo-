package com.example.trungspc.quizgame.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Trung's PC on 3/31/2018.
 */

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "197_independent_countries.sqlite";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
