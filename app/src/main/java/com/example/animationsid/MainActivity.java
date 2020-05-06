package com.example.animationsid;
//A1.Drawable Importer 上下堆疊特效
//1.使用Drawable import外掛使用方法: File/Settings/Plugins/drawable impoter下載
//2.寫好xml頁面元件
//3.ActionBar關掉
//4.創建anim區/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    ImageView imgLogo;
    TextView txtAppName,txtAppTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.設置全體視窗
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //2.取得特效上下效果
        topAnim =  AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //3.抓元件id
        imgLogo = findViewById(R.id.img);
        txtAppName = findViewById(R.id.txtAppName);
        txtAppTitle = findViewById(R.id.txtAppTitle);

        //4.設置效果
        imgLogo.setAnimation(topAnim);
        txtAppName.setAnimation(bottomAnim);
        txtAppTitle.setAnimation(bottomAnim);

        //5.自動跳轉下一個頁面並關閉
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },5000);

        }
    }
