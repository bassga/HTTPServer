package com.example.httpserver;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // サーバーサービスを開始
        Intent intent = new Intent(this, ServerService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // サーバーサービスを停止
        Intent intent = new Intent(this, ServerService.class);
        stopService(intent);
    }
}
