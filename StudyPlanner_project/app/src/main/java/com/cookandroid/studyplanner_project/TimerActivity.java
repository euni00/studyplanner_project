package com.cookandroid.studyplanner_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TimerActivity extends AppCompatActivity {

    private TextView countdownText;  // timer current state

    private Button startButton;  // Start Button
    private Button stopButton;  // Stop Button
    private Button cancelButton;  // Cancel Button

    private EditText hourText;  // hour
    private EditText minText;  // minute
    private EditText secondText;  // second

    private CountDownTimer countDownTimer;

    private boolean timerRunning; // timer running (true, false)
    private boolean firstState; // timer first running (true, false)

    private long time = 0;
    private long tempTime = 0;

    FrameLayout setting;  // setting layout
    FrameLayout timer;  // timer layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        // timer -> findViewById
        countdownText = findViewById(R.id.countdown_text);
        startButton = findViewById(R.id.countdown_button);
        stopButton = findViewById(R.id.stop_button);
        cancelButton = findViewById(R.id.cancel_button);

        hourText = findViewById(R.id.hour);
        minText = findViewById(R.id.min);
        secondText = findViewById(R.id.second);

        setting = findViewById(R.id.setting);
        timer = findViewById(R.id.timer);

        // Define startButton
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstState = true;
                setting.setVisibility(setting.GONE);
                timer.setVisibility(timer.VISIBLE);
                startStop();
            }
        });


        // Define stopButton
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });

        // Define cancelButton
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting.setVisibility(setting.VISIBLE);
                timer.setVisibility(timer.GONE);
                firstState = true;
                stopTimer();
            }

        });
        updateTimer();
    }

    // Define start and stop according to timer
    private void startStop() {
        if(timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    // Implement a timer
    private void startTimer() {
        if (firstState) {
            String sHour = hourText.getText().toString();
            String sMin = minText.getText().toString();
            String sSecond = secondText.getText().toString();
            time = (Long.parseLong(sHour) * 3600000) + (Long.parseLong(sMin) * 60000) + (Long.parseLong(sSecond) * 1000) + 1000;
        } else {
            time = tempTime;
        }

        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tempTime = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
            }
        }.start();

        stopButton.setText("일시정지");
        timerRunning = true;
        firstState = false;
    }
    // Define stopTimer
    private void stopTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        stopButton.setText("계속");
    }

    // Update time
    private void updateTimer() {
        int hour = (int) tempTime / 3600000;
        int minutes = (int) tempTime % 3600000 / 60000;
        int seconds = (int) tempTime % 3600000 % 60000 / 1000;

        String timeLeftText = "";

        timeLeftText = "" + hour + ":";

        if(minutes < 10) timeLeftText += "0";
        timeLeftText += minutes + ":";

        if(seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }
}