package com.example.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showPopupWindow(View view) {
        View popupView = getLayoutInflater().inflate(R.layout.popup_window_view, null);
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        // 设置 popup view 背景图片
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
        // 显示 popup view, 可以通过偏移的方式让 popup view 显示在任何位置
        popupWindow.showAsDropDown(view/* , view.getWidth(), -view.getHeight() */);

        // popupWindow.setTouchable(false); // 设置 popupView 内部触摸使能 主要影响的是点击事件

        // popupWindow.setOutsideTouchable(false); // 设置 popupView 外部触摸使能

        // 监听 popup window 中按钮的点击事件
        Button beijing = popupView.findViewById(R.id.BeiJing);
        Button wuhan = popupView.findViewById(R.id.WuHan);
        beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        wuhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}