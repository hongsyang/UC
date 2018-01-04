package com.xzt.uc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by asus on 2018/1/3.
 */

public class LoginHeader extends Fragment implements View.OnClickListener {

    private Button btn_sign_in = null;

    private ImageButton back;

    private View view;

    Intent intent = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_header, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_sign_in = view.findViewById(R.id.sign_in);
        btn_sign_in.setOnClickListener(this);
        back = view.findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in:
                intent = new Intent(getActivity(), SignIn.class);
                getActivity().startActivityForResult(intent, 1);
                break;
            case R.id.back:
                getActivity().finish();
                break;
        }
    }
}
