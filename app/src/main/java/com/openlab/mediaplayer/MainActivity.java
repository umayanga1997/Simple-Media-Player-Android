package com.openlab.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    MediaPlayer _mediaPlayer;

    ImageView _playBtn;
    Button _pauseBtn;
    Button _stopBtn;
    TextView _status;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Components
        _playBtn = findViewById(R.id.play_btn);
        _pauseBtn = findViewById(R.id.pause_btn);
        _stopBtn = findViewById(R.id.stop_btn);
        _status = findViewById(R.id.status_txt);

        // Get File Name
        String[] names = getResources().getResourceName(R.raw.test).split("/");
        String fileName = names[names.length - 1];

        // Initial
        _status.setText("Waiting for your command...");

        // Set music to media player
        _mediaPlayer = MediaPlayer.create(this, R.raw.test);

        // Set events
        _playBtn.setOnClickListener(v -> {
            if(_mediaPlayer != null) {
                _mediaPlayer.start();
                _status.setText(fileName + " song is playing");
            }
        });

        _pauseBtn.setOnClickListener(v -> {
            _mediaPlayer.pause();
            _status.setText(fileName + " song was paused");
        });

        _stopBtn.setOnClickListener(v -> {
            _mediaPlayer.stop();
            _mediaPlayer = MediaPlayer.create(this, R.raw.test);
            _status.setText(fileName + " song was stopped");
        });

    }

}