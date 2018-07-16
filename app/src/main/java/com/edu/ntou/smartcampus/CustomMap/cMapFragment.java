package com.edu.ntou.smartcampus.CustomMap;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.ntou.smartcampus.R;
import com.qozix.tileview.TileView;


/**
 * A simple {@link Fragment} subclass.
 */
public class cMapFragment extends Fragment {


    TileView tileView;

    public cMapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c_map,container,false);

        tileView = (TileView)v.findViewById(R.id.tileView);


        tileView.setSize( 4000, 2300 );//長和寬
        tileView.addDetailLevel( 1.0000f, "tiles/customMap/1000/%d_%d.png" );//增加比例圖磚
        tileView.setMarkerAnchorPoints( -0.5f, -0.5f );//錨點相對位置
        tileView.setScale( 0.6f );//初始比例大小   0.2500f
        tileView.setScaleLimits( 0.6f, 6 );   //0.6f,6
        tileView.setShouldLoopScale( true );
        
        // Inflate the layout for this fragment
        return v;
    }

}
