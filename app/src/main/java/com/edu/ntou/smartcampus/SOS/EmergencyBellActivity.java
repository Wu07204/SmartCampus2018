package com.edu.ntou.smartcampus.SOS;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.edu.ntou.smartcampus.R;
import com.edu.ntou.smartcampus.Theme.SosBellActivity;


public class EmergencyBellActivity extends SosBellActivity {
    //宣告媒體檔案
    MediaPlayer ringsong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_bell);
        SOSBell();
    }

    //播放求救警鈴鈴聲
    private void SOSBell() {
        ringsong = new MediaPlayer();
        ringsong.reset();
        ringsong = MediaPlayer.create(this, R.raw.ring);
        ringsong.start();
    }

    //離開SOSBell 時停止鈴聲
    @Override
    protected void onPause(){
        super.onPause();
//        Log.e("TAG", "Pause");
        EndBell();
    }

    //停止鈴聲
    void EndBell(){
        if(ringsong.isPlaying()) {
            ringsong.stop();
            ringsong.release();
        }
    }
}
