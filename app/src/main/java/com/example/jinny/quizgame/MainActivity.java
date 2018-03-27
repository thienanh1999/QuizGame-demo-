package com.example.jinny.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cv_flagsGame)
    CardView cvFlagsGame;
    @BindView(R.id.cv_magicWord)
    CardView cvMagicWord;
    @BindView(R.id.cv_dashboard)
    CardView cvDashboard;
    @BindView(R.id.cv_credit)
    CardView cvCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(actionBar.getDisplayOptions() | actionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_action_bar);
    }

    @OnClick({R.id.cv_flagsGame, R.id.cv_magicWord, R.id.cv_dashboard, R.id.cv_credit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cv_flagsGame:
                break;
            case R.id.cv_magicWord:
                Intent intent = new Intent(MainActivity.this, MagicWordActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_dashboard:
                break;
            case R.id.cv_credit:
                break;
        }
    }
}
