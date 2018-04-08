package com.example.jinny.quizgame;

import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SaveScoreActivity extends AppCompatActivity {

    EditText etName;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btOK;
    int score;
    int gameid;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_score);
        if (getActionBar() != null)
            getActionBar().hide();

//        final ImageView backgroundOne = findViewById(R.id.background_one);
//        final ImageView backgroundTwo = findViewById(R.id.background_two);
//        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
//
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setInterpolator(new LinearInterpolator());
//        animator.setDuration(10000L);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                final float progress = (float) animation.getAnimatedValue();
//                final float width = backgroundOne.getWidth();
//                final float translationX = width * progress;
//                backgroundOne.setTranslationX(translationX);
//                backgroundTwo.setTranslationX(translationX - width);
//            }
//        });
//        animator.start();


        etName = findViewById(R.id.et_name);
        btOK = findViewById(R.id.bt_ok);
        sharedPreferences = getSharedPreferences("Dashboard", MODE_PRIVATE);
        gameid = (int) getIntent().getSerializableExtra("gameid");
        int oldScore = (gameid == 1) ? sharedPreferences.getInt("score1", 0) : sharedPreferences.getInt("score2", 0);
        score = (int) getIntent().getSerializableExtra("score");
        if (oldScore < score)
            //Konfetti
        editor = sharedPreferences.edit();
        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
                if (gameid == 1) {
                    editor.putString("name1", name);
                    editor.putInt("score1", score);
                } else {
                    editor.putString("name2", name);
                    editor.putInt("score2", score);
                }
            }
        });
        editor.commit();
    }
}
