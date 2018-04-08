package com.example.jinny.quizgame;

import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class HighscoreActivity extends AppCompatActivity {

    TextView tvGame1;
    TextView tvGame2;
    SharedPreferences sharedPreferences;
    String name1;
    String name2;
    int score1;
    int score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        final ImageView backgroundOne = findViewById(R.id.background_one);
        final ImageView backgroundTwo = findViewById(R.id.background_two);
        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(10000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = backgroundOne.getWidth();
                final float translationX = width * progress;
                backgroundOne.setTranslationX(translationX);
                backgroundTwo.setTranslationX(translationX - width);
            }
        });
        animator.start();

        tvGame1 = findViewById(R.id.tv_game1);
        tvGame2 = findViewById(R.id.tv_game2);
        sharedPreferences = getSharedPreferences("Dashboard", MODE_PRIVATE);
        name1 = sharedPreferences.getString("name1", null);
        name2 = sharedPreferences.getString("name2", null);
        if (name1 == null) name1 = "";
        else {
            score1 = sharedPreferences.getInt("score1", 0);
            name1 = name1 + " : " + Integer.toString(score1);
        }
        if (name2 == null) name2 = "";
        else {
            score2 = sharedPreferences.getInt("score2", 0);
            name2 = name2 + " : " + Integer.toString(score2);
        }
        tvGame1.setText(name1);
        tvGame2.setText(name2);
    }
}
