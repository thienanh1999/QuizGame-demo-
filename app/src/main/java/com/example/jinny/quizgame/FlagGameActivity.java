package com.example.jinny.quizgame;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FlagGameActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "FlagGameActitvity";
    TextView tvTimer;
    TextView tvPoints;
    Button btnCountry1;
    Button btnCountry2;
    Button btnCountry3;
    Button btnCountry4;
    ImageView ivFlag;
    ImageView ivBack;

    int points;

    List<Country> listCountries;
    List<Button> listButtons;
    List<Country> randomCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        points = 0;

        setupUI();

        listButtons = new ArrayList<>();
        listButtons.add(btnCountry1);
        listButtons.add(btnCountry2);
        listButtons.add(btnCountry3);
        listButtons.add(btnCountry4);
        listCountries = DBUtils.getInstance(this).getAllCountries();
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        setButtonAndFlag();

        startNewTimer();
    }

    private void startNewTimer() {
        new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(millisUntilFinished / 1000 + " s");
            }

            @Override
            public void onFinish() {
                new AlertDialog.Builder(FlagGameActivity.this)
                        .setTitle("Game over")
                        .setMessage("You got " + points + ((points < 1) ? " point" : " points") + "\nPlay again?")
                        .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                startActivity(getIntent());
                            }
                        })
                        .setNegativeButton("Nah", null)
                        .setCancelable(false)
                        .show();
            }
        }.start();
    }

    private void setupUI() {
        tvTimer = findViewById(R.id.tv_time);
        tvPoints = findViewById(R.id.tv_point);
        btnCountry1 = findViewById(R.id.btn_country1);
        btnCountry1.setOnClickListener(this);
        btnCountry2 = findViewById(R.id.btn_country2);
        btnCountry2.setOnClickListener(this);
        btnCountry3 = findViewById(R.id.btn_country3);
        btnCountry3.setOnClickListener(this);
        btnCountry4 = findViewById(R.id.btn_country4);
        btnCountry4.setOnClickListener(this);
        ivFlag = findViewById(R.id.iv_flag);
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(this);
    }

    void setButtonAndFlag() {
        Collections.shuffle(listButtons);
        randomCountries = new ArrayList<>();
        randomCountries.add(getRandomCountry());
        Glide.with(this).load(randomCountries.get(0).getUrl()).into(ivFlag);
        do {
            Country temp = getRandomCountry();
            if (randomCountries.contains(temp))
                continue;
            randomCountries.add(temp);
        } while (randomCountries.size() < 4);
        int i = 0;
        Log.d(TAG, "setButtonAndFlag: " + listButtons.size());
        for (Button button: listButtons) {
            Log.d(TAG, "setButtonAndFlag: " + randomCountries.get(i).getName());
            button.setText(randomCountries.get(i).getName());
            i++;
        }
    }

    private Country getRandomCountry() {
        Random rand = new Random();
        int index = rand.nextInt(listCountries.size());
        return listCountries.get(index);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: Invoked");
        switch (view.getId()) {
            case R.id.btn_country1:
                if (btnCountry1.getText().equals(randomCountries.get(0).getName())) {
                    Toast.makeText(this, "Correct! +2 points", Toast.LENGTH_SHORT);
                    points += 2;
                    tvPoints.setText("Point: " + points);
                    setButtonAndFlag();
                } else {
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT);
                    setButtonAndFlag();
                }

                break;
            case R.id.btn_country2:
                if (btnCountry2.getText().equals(randomCountries.get(0).getName())) {
                    Toast.makeText(this, "Correct! +2 points", Toast.LENGTH_SHORT);
                    points += 2;
                    tvPoints.setText("Point: " + points);
                    setButtonAndFlag();
                } else {
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT);
                    setButtonAndFlag();
                }
                break;
            case R.id.btn_country3:
                if (btnCountry3.getText().equals(randomCountries.get(0).getName())) {
                    Toast.makeText(this, "Correct! +2 points", Toast.LENGTH_SHORT);
                    points += 2;
                    tvPoints.setText("Point: " + points);
                    setButtonAndFlag();
                } else {
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT);
                    setButtonAndFlag();
                }
                break;
            case R.id.btn_country4:
                if (btnCountry4.getText().equals(randomCountries.get(0).getName())) {
                    Toast.makeText(this, "Correct! +2 points", Toast.LENGTH_SHORT);
                    points += 2;
                    tvPoints.setText("Point: " + points);
                    setButtonAndFlag();
                } else {
                    Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT);
                    setButtonAndFlag();
                }
                break;
            case R.id.iv_back:
                onBackPressed();
                break;
        }
    }
}