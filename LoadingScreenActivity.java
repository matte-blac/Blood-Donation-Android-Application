package com.example.bda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingScreenActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView title , slogan;

    Animation imageAnimation, textAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_load_screen);

        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);
        slogan = findViewById(R.id.slogan);

        imageAnimation = AnimationUtils.loadAnimation(this, R.anim.image_animation);
        textAnimation =AnimationUtils.loadAnimation(this, R.anim.text_animation);

        logo.setAnimation(imageAnimation);
        title.setAnimation(textAnimation);
        slogan.setAnimation(textAnimation);

        int LOAD_SCREEN = 4300;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, LOAD_SCREEN);
    }
}