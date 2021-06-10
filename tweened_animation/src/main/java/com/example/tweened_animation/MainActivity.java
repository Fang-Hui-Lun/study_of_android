package com.example.tweened_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 通过加载动画设置 XML文件,创建 Animation 对象
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
                Animation rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                Animation scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
                Animation translate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);

                iv.startAnimation(translate);
            }
        });
    }
}