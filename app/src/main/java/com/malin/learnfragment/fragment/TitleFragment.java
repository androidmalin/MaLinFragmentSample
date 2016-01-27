package com.malin.learnfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.malin.learnfragment.R;

public class TitleFragment extends Fragment implements View.OnClickListener {

    private ImageButton mLeftImageButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_title, container, false);
        initView(rootView);
        bingListener();
        return rootView;
    }


    private void initView(View rootView) {
        mLeftImageButton = (ImageButton) rootView.findViewById(R.id.id_title_left_btn);
    }

    private void bingListener() {
        mLeftImageButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.id_title_left_btn: {
                Toast.makeText(getActivity(), "I am an ImageButton in TitleFragment ! ", Toast.LENGTH_SHORT).show();
                break;
            }

            default: {

                break;
            }
        }
    }
}
