package com.edu.ntou.smartcampus.NightMap;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.ntou.smartcampus.R;
import com.qozix.tileview.TileView;


public class nMapFragment extends Fragment {

    TileView ntileView;

    public nMapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_n_map, container, false);
        ntileView = (TileView) v.findViewById(R.id.ntileView);

        /*ntileView.setSize( 2160, 3840 );//長和寬
        ntileView.addDetailLevel( 1.0000f, "tiles/customMap/%d_%d.png" );//增加比例圖磚
        ntileView.setMarkerAnchorPoints( -0.5f, -0.5f );//錨點相對位置
        ntileView.setScale( 0.2500f );//初始比例大小*/
        ntileView.setSize( 2500,1800 );
        ntileView.addDetailLevel(1.000f, "tiles/nightMap/1000/%d_%d.jpg");//增加比例圖磚
        ntileView.setMarkerAnchorPoints(-0.5f, -0.5f);//錨點相對位置
        ntileView.setScale(0);//初始比例大小
        ntileView.defineBounds( 0, 0, 1, 1 );
        ntileView.setScaleLimits( 0, 6 );
        ntileView.setShouldLoopScale( true );


        return v;
    }




}
