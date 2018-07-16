package com.edu.ntou.smartcampus.Intro;

import android.content.Intent;

import com.edu.ntou.smartcampus.Main.MainActivity;
import com.github.paolorotolo.appintro.AppIntro2;

/**
 * Created by 1216QDF on 4/25/2017.
 */
public class BaseIntro  extends AppIntro2 {

    //引導程式進入主畫面
    void loadMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
