package com.edu.ntou.smartcampus.Theme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.edu.ntou.smartcampus.R;

public class GenderInforActivity extends AppCompatActivity {

    public Button btn1,btn2,btn3,btn4,btn5,btn6;//網址連結，性平相關資訊
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }

    private void setupViews(){
        setContentView(R.layout.activity_gender_infor);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //FloatingActionButton代表浮點鈕，功能：E-mail至海大性平會
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:sq@mail.ntou.edu.tw");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(it);
            }
        });

        //CollapsingToolbarLayout代表可折疊的工具欄
        // 畫面最上層(兩隻手)滑動後可被折疊、隱藏
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");

        loadImage();

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn1.setOnClickListener(btnListener);
        btn2.setOnClickListener(btnListener);
        btn3.setOnClickListener(btnListener);
        btn4.setOnClickListener(btnListener);
        btn5.setOnClickListener(btnListener);
        btn6.setOnClickListener(btnListener);
    }

    /*
        *按鈕的監聽事件，連結到各自網址
        */
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn1:
                    btnWebsite("https://www.gender.edu.tw/web/index.php/home/index");//性別平等教育資訊網
                    break;
                case R.id.btn2:
                    btnWebsite("http://law.moj.gov.tw/LawClass/LawAll.aspx?PCode=H0080069");//校園性侵害性騷擾或性霸凌防治準則
                    break;
                case R.id.btn3:
                    btnWebsite("http://law.moj.gov.tw/LawClass/LawAll.aspx?PCode=H0080067");//性別平等教育法
                    break;
                case R.id.btn4:
                    btnWebsite("http://law.moj.gov.tw/LawClass/LawAll.aspx?PCode=D0050074");//性騷擾防治法
                    break;
                case R.id.btn5:
                    btnWebsite("https://www.gender.edu.tw/web/index.php/m7/m7_02_01_01?sid=74#");//校園性侵害性騷擾或性霸凌事件通報及調查處理程序參考流程圖
                    break;
                case R.id.btn6:
                    btnWebsite("http://www.stu.ntou.edu.tw/sq/Page_Show.asp?Page_ID=1243");//國立臺灣海洋大學性別平等教育委員會
                    break;
            }
        }
    };

    /*
     *切換至網頁瀏覽器
     */
    private void btnWebsite(String url){
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
        startActivity(i);
    }

    /*
        *使用Glide載入大尺寸圖片
         */
    private void loadImage() {
        //設置"兩隻手"至頂圖[ res/drawable/imggender ]
        final ImageView imgView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.campusinfo2).centerCrop().into(imgView);
        //調查統計圖 [ res/drawable/survey ]
        final ImageView imgView1 = (ImageView) findViewById(R.id.imgSurvey);
        Glide.with(this).load(R.drawable.survey).fitCenter().into(imgView1);
    }
}
