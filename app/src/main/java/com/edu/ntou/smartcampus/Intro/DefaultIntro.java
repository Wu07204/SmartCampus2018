package com.edu.ntou.smartcampus.Intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.edu.ntou.smartcampus.R;

/**
 * Created by 1216QDF on 4/25/2017.
 */
public class DefaultIntro extends BaseIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //建制導覽頁面，利用SampleSlide引入配置檔
        addSlide(SampleSlide.newInstance(R.layout.intro_1));
        addSlide(SampleSlide.newInstance(R.layout.intro_2));
        addSlide(SampleSlide.newInstance(R.layout.intro_3));
        addSlide(SampleSlide.newInstance(R.layout.intro_4));
    }

    //SKIP 導覽事件
    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        loadMainActivity();
        Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    //導覽瀏覽覽結束事件
    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        loadMainActivity();
    }

    public void getStarted(View v) {
        loadMainActivity();
    }
}