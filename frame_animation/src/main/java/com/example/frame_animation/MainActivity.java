package com.example.frame_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView frame = findViewById(R.id.frame);
        AnimationDrawable anima = (AnimationDrawable) frame.getBackground();
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag) {
                    anima.start();
                    flag = true;
                } else
                {
                    anima.stop();
                    flag = false;
                }
            }
        });
    }
}