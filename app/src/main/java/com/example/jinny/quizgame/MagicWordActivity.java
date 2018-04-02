package com.example.jinny.quizgame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MagicWordActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_point)
    TextView tvPoint;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.bt_A)
    Button btA;
    @BindView(R.id.bt_B)
    Button btB;
    @BindView(R.id.bt_C)
    Button btC;
    @BindView(R.id.bt_D)
    Button btD;

    private int preId;
    public int score;
    public int time;
    MagicWordQuestionModel magicWordQuestionModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_word);
        ButterKnife.bind(this);
        getActionBar().hide();

        setupUI();
    }

    private void setupUI() {
        score = 0;
        time = 60;
        tvPoint.setText(Integer.toString(score));
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTime.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                TimeUpDialog timeUpDialog =new TimeUpDialog(MagicWordActivity.this);
                timeUpDialog.show();
            }

        }.start();
        preId = -1;
        nextWord(preId);
    }

    private void nextWord(int preId) {
        magicWordQuestionModel = DatabaseManager.getInstance(this).getRandomWord(preId);
        tvQuestion.setText(magicWordQuestionModel.explanation);
        switch (magicWordQuestionModel.right) {
            case 1:
                btA.setText(magicWordQuestionModel.origin);
                break;
            case 2:
                btB.setText(magicWordQuestionModel.origin);
                break;
            case 3:
                btC.setText(magicWordQuestionModel.origin);
                break;
            case 4:
                btD.setText(magicWordQuestionModel.origin);
                break;
        }
        int dem = 0;
        for (int i = 1; i <= 4; i++) {
            if (i != magicWordQuestionModel.right)
            {
                switch (i) {
                    case 1:
                        btA.setText(magicWordQuestionModel.word.get(dem));
                        break;
                    case 2:
                        btB.setText(magicWordQuestionModel.word.get(dem));
                        break;
                    case 3:
                        btC.setText(magicWordQuestionModel.word.get(dem));
                        break;
                    case 4:
                        btD.setText(magicWordQuestionModel.word.get(dem));
                        break;
                }
                dem++;
            }
        }
        Picasso.get().load(magicWordQuestionModel.image).into(ivImage);
        preId = magicWordQuestionModel.id;
    }

    @OnClick({R.id.iv_back, R.id.bt_A, R.id.bt_B, R.id.bt_C, R.id.bt_D})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.bt_A:
                if (magicWordQuestionModel.right == 1) updateScore(true); else updateScore(false);
                nextWord(preId);
                break;
            case R.id.bt_B:
                if (magicWordQuestionModel.right == 2) updateScore(true); else updateScore(false);
                nextWord(preId);
                break;
            case R.id.bt_C:
                if (magicWordQuestionModel.right == 3) updateScore(true); else updateScore(false);
                nextWord(preId);
                break;
            case R.id.bt_D:
                if (magicWordQuestionModel.right == 4) updateScore(true); else updateScore(false);
                nextWord(preId);
                break;
        }
    }

    public void updateScore(boolean right)
    {
        if (right) score++;
        else
            if (score > 0) score--;
        tvPoint.setText(Integer.toString(score));
    }
}
