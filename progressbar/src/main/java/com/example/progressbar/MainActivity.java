package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pb;
    private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);
        progress = findViewById(R.id.progress);
    }

    public void showAndVisibleProgressBar(View view) {
        if(pb.getVisibility() == View.GONE)
        {
            pb.setVisibility(View.VISIBLE);
        } else
        {
            pb.setVisibility(View.GONE);
        }
    }
    int sum = 0;
    public void addProgress(View view) {
        if(progress.getProgress() == 100)
        {
            sum = 0;
        } else {
            sum += 5;
        }
        progress.setProgress(sum);
    }
}