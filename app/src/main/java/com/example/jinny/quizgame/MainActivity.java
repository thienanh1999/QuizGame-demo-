package com.example.jinny.quizgame;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(actionBar.getDisplayOptions()|actionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_action_bar);

        //ThienAnh

        //thienanh :>
        //a comment
    }
}
