package com.cookandroid.studyassist_project;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class StopwatchActivity extends AppCompatActivity {

    private TextView timer;
    private ScrollView scrollView;
    private TextView record;
    private Button bt_sta,bt_rec;

    //상태를 표시하는 '상수' 지정
    public static final int INIT = 0;  //처음
    public static final int RUN = 1;  //실행중
    public static final int PAUSE = 2;  //정지

    //상태값을 저장하는 변수
    public static int status = INIT;

    //기록할때 순서
    private int cnt = 1;

    //타이머 시간 값
    private long baseTime,pauseTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        //객체화
        timer = (TextView)findViewById(R.id.timer);
        scrollView = (ScrollView)findViewById(R.id.scrollView);
        record = (TextView)findViewById(R.id.record);
        bt_sta = (Button)findViewById(R.id.bt_sta);
        bt_rec = (Button)findViewById(R.id.bt_rec);
        bt_rec.setEnabled(false);  //비활성화

        bt_sta.setOnClickListener(onClickListener);
        bt_rec.setOnClickListener(onClickListener);

    }

    // 스탑워치 화면에 보이는 버튼
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bt_sta:  // 시작 버튼
                    staButton();
                    break;
                case R.id.bt_rec:  // 기록 버튼
                    recButton();

            }


        }
    };

    // 시작 버튼에 대한 동작
    private void staButton(){
        switch (status){
            case INIT:
                baseTime = SystemClock.elapsedRealtime();

                //핸들러 실행
                handler.sendEmptyMessage(0);
                bt_sta.setText("멈춤");
                bt_rec.setEnabled(true);

                //상태 변환
                status = RUN;
                break;
            case RUN:
                //핸들러 정지
                handler.removeMessages(0);

                //정지 시간 체크
                pauseTime = SystemClock.elapsedRealtime();

                bt_sta.setText("시작");
                bt_rec.setText("리셋");

                //상태변환
                status = PAUSE;
                break;
            case PAUSE:
                long reStart = SystemClock.elapsedRealtime();
                baseTime += (reStart - pauseTime);

                handler.sendEmptyMessage(0);

                bt_sta.setText("멈춤");
                bt_rec.setText("기록");

                status = RUN;
        }

    }

    // 기록 버튼에 대한 동작
    private void recButton(){
        switch (status){
            case RUN:
                // 타임리스트에 시간 기록에 대한 텍스트를 추가
                String timeList = record.getText().toString();
                timeList+= String.format("%2d. %s\n",cnt,getTime());

                record.setText(timeList);

                cnt++;
                break;
            case PAUSE:
                bt_sta.setText("시작");
                bt_rec.setText("기록");
                bt_rec.setEnabled(false);

                timer.setText("00:00:00");
                record.setText("");

                baseTime = 0;
                pauseTime = 0;

                cnt = 1;

                status = INIT;

        }
    }

    // 경과된 시간 체크
    private String getTime(){


        long nowTime = SystemClock.elapsedRealtime();

        //시스템이 부팅된 이후의 시간
        long overTime = nowTime - baseTime;

        long m = overTime/1000/60;
        long s = (overTime/1000)%60;
        long ms = overTime % 1000;

        String recTime = String.format("%02d:%02d:%03d",m,s,ms);

        return recTime;
    }

    // Handler 사용
    Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {

            timer.setText(getTime());

            //
            handler.sendEmptyMessage(0);
        }
    };

}