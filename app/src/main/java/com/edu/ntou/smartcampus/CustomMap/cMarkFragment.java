package com.edu.ntou.smartcampus.CustomMap;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.graphics.Color;
import android.graphics.Paint;

import com.edu.ntou.smartcampus.R;
import com.qozix.tileview.TileView;
import com.qozix.tileview.paths.CompositePathView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class cMarkFragment extends Fragment {

    public TileView tileView;

    CheckBox chk[] = new CheckBox[6];
    int chkID[] = {R.id.chkEmergencyCall, R.id.chkGuard, R.id.chkSchoolSecurityOffice, R.id.chkConvenienceStore, R.id.chkConvenienceStore1, R.id.chkSchoolGate};

    CheckBox chkRoute[] = new CheckBox[3];
    int chkID2[] = {R.id.chkNightBrightRoute, R.id.chkWeatherProtectionRoute};
    private CompositePathView.DrawablePath drawablePath, drawablePath1, drawablePath2, drawablePath3, drawablePath4;


    ImageView imgEmergencyCall[] = new ImageView[25];
    ImageView imgGuard[] = new ImageView[1];
    ImageView imgSchoolSecurityOffice[] = new ImageView[1];
    ImageView imgConvenienceStore[] = new ImageView[2];
    ImageView imgConvenienceStore1[] = new ImageView[1];
    ImageView imgSchoolGate[] = new ImageView[3];


    public cMarkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c_mark, container, false);

        //建立頁面內容，和設定Checkbox的監聽事件
        for (int i = 0; i < chkID.length; i++) {
            if ((chk[i] = (CheckBox) v.findViewById(chkID[i])) != null)
                chk[i].setOnCheckedChangeListener(chkListener);
        }
        for (int i = 0; i < chkID2.length; i++) {
            if ((chkRoute[i] = (CheckBox) v.findViewById(chkID2[i])) != null)
                chkRoute[i].setOnCheckedChangeListener(chkListener);
        }

        setupmarkView();

        // Inflate the layout for this fragment
        return v;
    }

    /*
        設定ImageView(圖標)
        */
    private void setupmarkView() {

        for (int i = 0; i < imgEmergencyCall.length; i++)//緊急電話
        {
            imgEmergencyCall[i] = new ImageView(getActivity());
            imgEmergencyCall[i].setImageResource(R.drawable.ppphone);
        }
        for (int i = 0; i < imgGuard.length; i++)//駐警隊
        {
            imgGuard[i] = new ImageView(getActivity());
            imgGuard[i].setImageResource(R.drawable.guard);
        }
        for (int i = 0; i < imgSchoolSecurityOffice.length; i++)//校安中心
        {
            imgSchoolSecurityOffice[i] = new ImageView(getActivity());
            imgSchoolSecurityOffice[i].setImageResource(R.drawable.guard);
        }
        for (int i = 0; i < imgConvenienceStore.length; i++)//便利商店(全家)
        {
            imgConvenienceStore[i] = new ImageView(getActivity());
            imgConvenienceStore[i].setImageResource(R.drawable.cconv);
        }
        for (int i = 0; i < imgConvenienceStore1.length; i++)//便利商店(OK)
        {
            imgConvenienceStore1[i] = new ImageView(getActivity());
            imgConvenienceStore1[i].setImageResource(R.drawable.ccconv);
        }
        for (int i = 0; i < imgSchoolGate.length; i++)//校門
        {
            imgSchoolGate[i] = new ImageView(getActivity());
            imgSchoolGate[i].setImageResource(R.drawable.ggate);
        }

    }

    /*
        Checkbox的監聽事件，勾選時在地圖上顯示圖標。
        */
    private CheckBox.OnCheckedChangeListener chkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()) {

                case R.id.chkEmergencyCall:
                    if (chk[0].isChecked()) {
                        tileView = (TileView) getActivity().findViewById(R.id.tileView);
                        tileView.addMarker(imgEmergencyCall[0], 2495, 820, null, null); //   01  695, 1380    1360, 1430
                        tileView.addMarker(imgEmergencyCall[1], 2895, 550, null, null);  //  02    530, 1000     950, 1630
                        tileView.addMarker(imgEmergencyCall[2], 2995, 164, null, null);   //  03     150, 855      860, 2020
                        tileView.addMarker(imgEmergencyCall[3], 2695, 290, null, null);  // 04     275, 1200    1140, 1880
                        tileView.addMarker(imgEmergencyCall[4], 2465, 250, null, null);  // 05     265, 1380     1375, 1910
                        tileView.addMarker(imgEmergencyCall[5], 2513, 330, null, null);  // 06      337, 1340     1330, 1830
                        tileView.addMarker(imgEmergencyCall[6], 2465, 325, null, null);  // 07     337, 1490      1380, 1840
                        tileView.addMarker(imgEmergencyCall[7], 2770, 375, null, null);  // 08       400, 1150     1090, 1795
                        tileView.addMarker(imgEmergencyCall[8], 2005, 270, null, null);    //     09    150, 1931      1835, 1920
                        tileView.addMarker(imgEmergencyCall[9], 2190, 490, null, null);    //    10     530, 1700      1655, 1710
                        tileView.addMarker(imgEmergencyCall[10], 2090, 720, null, null);    //     11      655, 1755    1745, 1490
                        tileView.addMarker(imgEmergencyCall[11], 1790, 670, null, null);    //     12          645, 2070    2060, 1510
                        tileView.addMarker(imgEmergencyCall[12], 965, 690, null, null);   //    13           675, 2880    2880, 1500
                        tileView.addMarker(imgEmergencyCall[13], 1165, 1180, null, null); //    14           1200, 2650     2700, 995
                        tileView.addMarker(imgEmergencyCall[14], 1470, 985, null, null);    //   15              980, 2350   2375, 1185
                        tileView.addMarker(imgEmergencyCall[15], 1940, 1065, null, null);  //   16             1100, 1931
                        tileView.addMarker(imgEmergencyCall[16], 1155, 1288, null, null); //   17           1300, 2700
                        tileView.addMarker(imgEmergencyCall[17], 1215, 1743, null, null); //   18           1750, 2650
                        tileView.addMarker(imgEmergencyCall[18], 1280, 1923, null, null); // 19          1930, 2600
                        tileView.addMarker(imgEmergencyCall[19], 1605, 1915, null, null); // 20           1920, 2240
                        tileView.addMarker(imgEmergencyCall[20], 1785, 1795, null, null); // 21           1830, 2000
                        tileView.addMarker(imgEmergencyCall[21], 830, 1843, null, null); // 22            1830, 3000
                        tileView.addMarker(imgEmergencyCall[22], 1675, 1745, null, null); // 23            1750, 2200
                        tileView.addMarker(imgEmergencyCall[23], 3345, 264, null, null);  // 24                  50, 595

                    } else {
                        removePin(imgEmergencyCall);
                    }
                    break;
                case R.id.chkGuard:
                    if (chk[1].isChecked()) {
                        tileView = (TileView) getActivity().findViewById(R.id.tileView);
                        tileView.addMarker(imgGuard[0], 2315, 920, null, null);
                    } else {
                        removePin(imgGuard);
                    }
                    break;
                case R.id.chkSchoolSecurityOffice:
                    if (chk[2].isChecked()) {
                        tileView = (TileView) getActivity().findViewById(R.id.tileView);
                        tileView.addMarker(imgSchoolSecurityOffice[0], 1080, 1288, null, null);
                    } else {
                        removePin(imgSchoolSecurityOffice);
                    }
                    break;
                case R.id.chkConvenienceStore:
                    if (chk[3].isChecked()) {
                        tileView = (TileView) getActivity().findViewById(R.id.tileView);
                        tileView.addMarker(imgConvenienceStore[0], 2190, 300, null, null);
                        tileView.addMarker(imgConvenienceStore[1], 1075, 640, null, null);

                    } else {
                        removePin(imgConvenienceStore);
                    }
                    break;
                case R.id.chkConvenienceStore1:
                    if (chk[4].isChecked()) {
                        tileView = (TileView) getActivity().findViewById(R.id.tileView);
                        tileView.addMarker(imgConvenienceStore1[0], 1125, 1378, null, null);

                    } else {
                        removePin(imgConvenienceStore1);
                    }
                    break;
                case R.id.chkSchoolGate:
                    if (chk[5].isChecked()) {
                        tileView = (TileView) getActivity().findViewById(R.id.tileView);
                        tileView.addMarker(imgSchoolGate[0], 3390, 480, null, null);
                        tileView.addMarker(imgSchoolGate[1], 2390, 1255, null, null);
                        tileView.addMarker(imgSchoolGate[2], 1015, 1763, null, null);
                    } else {
                        removePin(imgSchoolGate);
                    }
                    break;
                case R.id.chkNightBrightRoute:
                    if (chkRoute[0].isChecked()) {
                        DrawNightBrightRoute();
                    } else {
                        RemoveNightBrightRoute();
                    }
                    break;
                case R.id.chkWeatherProtectionRoute:
                    if (chkRoute[1].isChecked()) {
                        DrawWeatherProtectionRoute();
                    } else {
                        RemoveWeatherProtectionRoute();
                    }
                    break;
            }
        }
    };


    /*
        移除圖標
        */
    private void removePin(ImageView marker) {
        tileView.removeMarker(marker);
    }

    /*
        移除圖標(陣列)
        */
    private void removePin(ImageView[] marker) {
        for (int i = 0; i < marker.length; i++)
            tileView.removeMarker(marker[i]);
    }

    /*
        顯示夜間明亮路線(黃色)
         */
    private void DrawNightBrightRoute() {
        tileView = (TileView) getActivity().findViewById(R.id.tileView);
        Paint paint = new Paint();
        paint.setAntiAlias(true);//設定畫筆抗鋸齒
        paint.setColor(Color.YELLOW);//設定畫筆顏色
        paint.setStyle(Paint.Style.STROKE);//設定畫筆風格
        paint.setStrokeWidth(20);//設定畫筆寬度
        //drawablePath是由Path和Paint組成，代表路徑
        drawablePath = tileView.drawPath(points.subList(0, 26), paint);
        drawablePath4 = tileView.drawPath(points.subList(26, 31), paint);
        tileView.drawPath(drawablePath);
        tileView.drawPath(drawablePath4);
    }

    /*
        取消夜間明亮路線(黃色)
         */
    private void RemoveNightBrightRoute() {
        tileView.removePath(drawablePath);
        tileView.removePath(drawablePath4);
    }

    /*
        顯示防風雨路線(青綠色)
        */
    private void DrawWeatherProtectionRoute() {
        tileView = (TileView) getActivity().findViewById(R.id.tileView);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        drawablePath1 = tileView.drawPath(points.subList(31, 35), paint);  //6,14  31,45
        tileView.drawPath(drawablePath1);
        drawablePath2 = tileView.drawPath(points.subList(35, 45), paint);
        tileView.drawPath(drawablePath2);
        drawablePath3 = tileView.drawPath(points.subList(45, 48), paint);
        tileView.drawPath(drawablePath3);
    }

    /*
        取消防風雨路線(青綠色)
        */
    private void RemoveWeatherProtectionRoute() {
        tileView.removePath(drawablePath1);
        tileView.removePath(drawablePath2);
        tileView.removePath(drawablePath3);
    }

    private ArrayList<double[]> points = new ArrayList<>();

    {
        //夜間明亮路線
        points.add(new double[]{3295, 50}); //1
        points.add(new double[]{3295, 200});
        points.add(new double[]{2995, 200});
        points.add(new double[]{2995, 480});
        points.add(new double[]{3345, 480});
        points.add(new double[]{2995, 480});
        points.add(new double[]{2895, 550});
        points.add(new double[]{2995, 480});
        points.add(new double[]{2995, 200});
        points.add(new double[]{2390, 200});
        points.add(new double[]{2390, 580});
        points.add(new double[]{2845, 580});
        points.add(new double[]{2845, 550});
        points.add(new double[]{2845, 580});
        points.add(new double[]{2390, 580});//15
        points.add(new double[]{1315, 580});
        points.add(new double[]{1115, 670});
        points.add(new double[]{1115, 945});
        points.add(new double[]{965, 945});
        points.add(new double[]{965, 1230});
        points.add(new double[]{2390, 1230});
        points.add(new double[]{2390, 580});
        points.add(new double[]{2390, 1230});
        points.add(new double[]{965, 1230});
        points.add(new double[]{1110, 1395}); //25
        points.add(new double[]{1215, 1773});

        points.add(new double[]{1280, 1873});
        points.add(new double[]{1530, 1873});
        points.add(new double[]{1020, 1873});
        points.add(new double[]{970, 1803});
        points.add(new double[]{570, 1803}); //31


        //防風雨路線
        points.add(new double[]{1160, 595}); //32
        points.add(new double[]{1320, 595});
        points.add(new double[]{1320, 670});
        points.add(new double[]{1600, 670});

        points.add(new double[]{1635, 640});
        points.add(new double[]{1795, 640});
        points.add(new double[]{1795, 610});
        points.add(new double[]{2045, 610}); //39
        points.add(new double[]{2045, 625});
        points.add(new double[]{2305, 625});
        points.add(new double[]{2065, 625});
        points.add(new double[]{2065, 930});
        points.add(new double[]{1635, 930});
        points.add(new double[]{1595, 880});

        points.add(new double[]{2770, 550});
        points.add(new double[]{2900, 550});
        points.add(new double[]{2900, 433});


    }
}
