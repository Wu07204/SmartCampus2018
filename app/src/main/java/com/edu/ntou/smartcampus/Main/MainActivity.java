package com.edu.ntou.smartcampus.Main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.edu.ntou.smartcampus.Intro.DefaultIntro;
import com.edu.ntou.smartcampus.R;
import com.edu.ntou.smartcampus.Theme.CustomMapActivity;
import com.edu.ntou.smartcampus.Theme.GenderInforActivity;
import com.edu.ntou.smartcampus.Theme.SosBellActivity;
import com.edu.ntou.smartcampus.Theme.NightMapActivity;
import com.edu.ntou.smartcampus.Theme.SiteInforActivity;
import com.edu.ntou.smartcampus.Theme.WorkoutPlanActivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //定義GridView
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupIntro();
        setupViews();
    }

    /***
     * 呼叫新執行緒，建立導覽頁面
     */
    private void setupIntro(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  初始化SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  建立boolean和preference，設定成true
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                //  判斷是否啟動過
                if (isFirstStart) {

                    //  執行Intro
                    Intent i = new Intent(MainActivity.this, DefaultIntro.class);
                    startActivity(i);

                    //  建立preferences editor，preference 改成false，因為不再重複啟動
                    SharedPreferences.Editor e = getPrefs.edit();
                    e.putBoolean("firstStart", false);
                    e.apply();
                }
            }
        });

        t.start();
    }

    /***
     * 建立主頁面(GridView)內容，創建ArrayList和HashMap，置放MainItems的圖片和文字，利用Adapter串接資料和介面。
     */
    private void setupViews(){
        setContentView(R.layout.activity_main);

        //定義items為ArrayLists類實例化List集合，List內放置Map集合
        List<Map<String,Object>> items = new ArrayList<>();
        for (int i = 0; i < MainItems.mainitems.length; i++){
            //定義item為Map集合，key屬於String類，value屬於Object類
            Map<String,Object> item = new HashMap<>();
            item.put("image",MainItems.mainitems[i].getImgId());
            item.put("text",MainItems.mainitems[i].getName());
            items.add(item);
        }

        //使用SimpleAdapter連接gridview與items資料
        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.grid_item,
                new String[]{"image","text"}, new int[]{R.id.image,R.id.text});
        gridView = (GridView)findViewById(R.id.main_page_gridview);
        gridView.setNumColumns(2);//設定欄位數
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        selectMenu(NightMapActivity.class);
                        break;
                    case 1:
                        selectMenu(CustomMapActivity.class);
                        break;
                    case 2 :
                        selectMenu(SiteInforActivity.class);
                        break;
                    case 3 :
                        selectMenu(WorkoutPlanActivity.class);
                        break;
                    case 4:
                        selectMenu(GenderInforActivity.class);
                        break;
                    case 5:
                        selectMenu(SosBellActivity.class);
                        break;
                }
            }
        });
    }

    /***
     *選擇功能頁面，轉換至新頁面
     */
    private void selectMenu(Object activity){
        Intent i = new Intent(MainActivity.this, (Class<?>) activity);
        startActivity(i);
    }
}
