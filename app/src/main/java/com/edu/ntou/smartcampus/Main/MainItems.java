package com.edu.ntou.smartcampus.Main;

import com.edu.ntou.smartcampus.R;

/**
 * MainItems.java 定義GridView內的Text和Image。
 */
public class MainItems {
    //主選單圖片
    private String name;
    //主選單圖片ID
    private int imgId;

    public static final MainItems[] mainitems = {
            new MainItems("Campus Map",R.drawable.custom_map), new MainItems("Smart Campus Map",R.drawable.osm), new MainItems("Workout Info.",R.drawable.infor),
            new MainItems("Workout Plan",R.drawable.infor), new MainItems("Campus Info.",R.drawable.infor), new MainItems("SOS",R.drawable.bell),
            new MainItems("Coming Soon",R.drawable.none), new MainItems("Coming Soon",R.drawable.none)
    };

    //每個MainItems具有名稱和圖片ID
    private MainItems(String name,int imgId){
        this.name = name;
        this.imgId = imgId;
    }

    public String getName(){
        return name;
    }

    public int getImgId(){
        return imgId;
    }
}
