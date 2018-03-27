package com.example.jinny.quizgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_word);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.bt_A, R.id.bt_B, R.id.bt_C, R.id.bt_D})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.bt_A:
                break;
            case R.id.bt_B:
                break;
            case R.id.bt_C:
                break;
            case R.id.bt_D:
                break;
        }
    }
}
