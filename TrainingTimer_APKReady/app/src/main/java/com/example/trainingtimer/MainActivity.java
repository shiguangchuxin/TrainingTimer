package com.example.trainingtimer;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView timerText;
    private Button startButton;
    private Handler handler = new Handler();
    private boolean running = false;
    private MediaPlayer mediaPlayer;

    private final long D30 = 30000L;
    private final long D10 = 10000L;

    private Runnable start30 = new Runnable() {
        @Override
        public void run() {
            timerText.setText("计时 30 秒中...");
            handler.postDelayed(() -> {
                playBeep();
                handler.post(start10);
            }, D30);
        }
    };

    private Runnable start10 = new Runnable() {
        @Override
        public void run() {
            timerText.setText("计时 10 秒中...");
            handler.postDelayed(() -> {
                playBeep();
                handler.post(start30);
            }, D10);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerText = findViewById(R.id.timerText);
        startButton = findViewById(R.id.startButton);
        mediaPlayer = MediaPlayer.create(this, R.raw.beep);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!running) {
                    running = true;
                    startButton.setText("停止");
                    handler.post(start30);
                } else {
                    stopLoop();
                }
            }
        });
    }

    private void stopLoop() {
        running = false;
        startButton.setText("开始训练");
        handler.removeCallbacksAndMessages(null);
        timerText.setText("已停止");
    }

    private void playBeep() {
        if (!running) return;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        handler.removeCallbacksAndMessages(null);
    }
}
