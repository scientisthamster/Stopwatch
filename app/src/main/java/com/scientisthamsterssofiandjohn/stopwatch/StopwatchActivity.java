package com.scientisthamsterssofiandjohn.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopwatchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart,btnStop;
    private ImageView ivCircle,ivClock;
    private Animation animation1;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        init();
    }

    private void init() {
        chronometer = findViewById(R.id.timer);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnStop.setAlpha(0);
        ivClock = findViewById(R.id.ivClock);
        ivCircle = findViewById(R.id.ivCircle);
        animation1 = AnimationUtils.loadAnimation(this,R.anim.animclock);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                ivClock.startAnimation(animation1);
                btnStop.animate().alpha(1).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                break;
            case R.id.btnStop:
                chronometer.stop();
                ivClock.clearAnimation();
                btnStart.animate().alpha(1).setDuration(300).start();
                btnStop.animate().alpha(0).setDuration(300).start();
                break;
        }

    }
}