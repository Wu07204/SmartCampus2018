package com.edu.ntou.smartcampus.Theme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.edu.ntou.smartcampus.R;
import com.edu.ntou.smartcampus.SOS.EmergencyBellActivity;

public class SosBellActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCall;
    private Button btnCall1;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sos_bell);

            btnCall = (Button) findViewById(R.id.btnCall);
            btnCall1 = (Button) findViewById(R.id.btnCall1);

            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-24629976"));
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(intent);
                }
            });

            btnCall1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0933198009"));
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(intent1);
                }
            });



            Button btnplay = (Button) findViewById(R.id.btnPlay);
            btnplay.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    // 指定要呼叫的 Activity Class
                    Intent EmergencyBellActivity = new Intent();
                    EmergencyBellActivity.setClass(SosBellActivity.this, EmergencyBellActivity.class);

                    // 呼叫新的 Activity Class
                    startActivity(EmergencyBellActivity);

                    // 結束原先的 Activity Class
                    //SosBellActivity.this.finish();
                }
            });


        }
    public void onClick(View v) {}
    }















/*@SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.ring, 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                playSound();
                break;
        }
    }

    private void playSound() {
        soundPool.play(
                soundID,
                0.5f,      //左耳道音量【0~1】
                0.5f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                1,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }*/














