package com.example.jinny.quizgame;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String TABLE_WORD = "tbl_word";

    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context) {
        if (databaseManager == null) databaseManager = new DatabaseManager(context);
        return databaseManager;
    }

    public DatabaseManager(Context context) {
        assetHelper = new AssetHelper(context);
    }

    public List<WordModel> getListWord() {
        sqLiteDatabase = assetHelper.getReadableDatabase();

        List<WordModel> wordModelList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_WORD, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String origin = cursor.getString(1);
            String explanation = cursor.getString(2);
            String type = cursor.getString(3);
            String pronounciation = cursor.getString(4);
            String image = cursor.getString(5);
            String example = cursor.getString(6);
            String exampleTrans = cursor.getString(7);
            int topic_id = cursor.getInt(8);
            int level = cursor.getInt(9);

            WordModel wordModel = new WordModel(id, origin, explanation, type, pronounciation, image, example, exampleTrans, topic_id, level);
            wordModelList.add(wordModel);
            cursor.moveToNext();
        }
        return wordModelList;
    }
} 