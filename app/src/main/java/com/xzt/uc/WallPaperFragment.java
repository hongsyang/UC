package com.xzt.uc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by T on 2017/12/17.
 */

public class WallPaperFragment extends Fragment {

    private View view;
    private View view2;
    private ImageButton pinkWallPaper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.tab01,container, false);
        view2=inflater.inflate(R.layout.top,container,false);
        ImageButton pinkWallPaper =(ImageButton)view.findViewById(R.id.pinkWallPaperT);
        pinkWallPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //View topL=view.findViewById(R.id.topL);
                //topL.setBackgroundResource(R.drawable.pink);
                //ImageButton btnBack = view2.findViewById(R.id.btnBackBDress);
                //btnBack.setImageResource(R.drawable.pink_triangle);


                //btnBack.setImageResource(R.drawable.pink_triangle);
                //
                Toast.makeText(getContext(),"装扮成功",Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }
}
