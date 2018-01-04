package com.xzt.uc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by asus on 2018/1/3.
 */

public class UserHeader extends Fragment implements View.OnClickListener {

    private ImageButton settings = null;

    private ImageButton back;

    private TextView welcome;

    private View view;

    Intent intent = null;

    private CircleImageView circleImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_header, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        settings = view.findViewById(R.id.settings);
        welcome = view.findViewById(R.id.welcome);
        circleImageView = view.findViewById(R.id.icon_image);
        welcome.setText("欢迎您," + LoginActivity.user.getUid());
        circleImageView.setImageResource(R.drawable.login_image);
        settings.setOnClickListener(this);
        back = view.findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settings:
                intent = new Intent(getActivity(), UserSettings.class);
                getActivity().startActivityForResult(intent, 2);
                break;
            case R.id.back:
                getActivity().finish();
                break;
        }
    }
}
