package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void alertDialog(View view) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_view, null); // 获取自定义布局

        AlertDialog.Builder builder = new AlertDialog.Builder(this); // 创建 alert dialog 构建器
        // alertDialog 设置属性
        builder.setIcon(R.drawable.ic_baseline_brightness_low_24)
                .setTitle("测试弹框") // 设置 dialog 标题
                .setMessage("测试消息") // 设置 dialog 内容
                .setView(dialogView) // 设置 dialog 自定义内容
                // 监听确定按钮点击事件
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("test","点击确定");
                    }
                })
                // 监听取消按钮点击事件
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("test", "点击取消");
                    }
                })
                // 监听中间按钮点击事件
                .setNeutralButton("中间", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("test", "点击中间");
                    }
                })
                .create()
                .show();
    }
}