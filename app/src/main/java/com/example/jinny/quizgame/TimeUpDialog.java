package com.example.jinny.quizgame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.jinny.quizgame.R;

public class TimeUpDialog extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;

    public TimeUpDialog (Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.timeup_dialog);
        yes = (Button) findViewById(R.id.bt_ok);
        no = (Button) findViewById(R.id.bt_try);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ok:
                c.finish();
                break;
            case R.id.bt_try:
                c.finish();
                Intent intent = new Intent(c, SaveScoreActivity.class);
                c.startActivity(intent);
                break;
        }
    }

    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(false);
    }
}