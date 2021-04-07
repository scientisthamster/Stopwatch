package com.scientisthamsterssofiandjohn.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSplash, tvSubSplash;
    private Button btnGet;
    private ImageView ivSplash;
    private Animation animation1, animation2, animation3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnGet = findViewById(R.id.btnGet);
        ivSplash = findViewById(R.id.ivSplash);

        animation1 = AnimationUtils.loadAnimation(this, R.anim.anim_splash);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.anim2_spl);
        animation3 = AnimationUtils.loadAnimation(this, R.anim.anim3_spl);


        ivSplash.startAnimation(animation1);
        tvSplash.startAnimation(animation2);
        tvSubSplash.startAnimation(animation2);
        btnGet.startAnimation(animation3);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, StopwatchActivity.class));
    }
}