package com.example.jinny.quizgame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class HighscoreDialog extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Dialog d;
    public EditText EtName;
    public Button BtOk;

    public HighscoreDialog (Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.timeup_dialog);
        BtOk = findViewById(R.id.bt_ok);
        EtName = findViewById(R.id.et_name);
        BtOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ok:
                String name;
                name = EtName.getText().toString();
                save(name);
                c.finish();
                Intent intent = new Intent(c, MagicWordActivity.class);
                c.startActivity(intent);
                break;
        }
    }

    private void save(String name) {
        int score;
    }
}