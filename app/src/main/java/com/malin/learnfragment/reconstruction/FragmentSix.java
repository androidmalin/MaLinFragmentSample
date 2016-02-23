package com.malin.learnfragment.reconstruction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.malin.learnfragment.R;
import com.orhanobut.logger.Logger;

/**
 * 类描述:
 * 创建人:lin.ma@renren-inc.com
 * 创建时间:16-1-28
 * 备注:{@link } Thanks for  ,Her code is very good ! I made reference to his code,It saves me a lot of time!
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class FragmentSix extends Fragment implements View.OnClickListener {
    private static final String TAG = FragmentSix.class.getSimpleName() + "-->";
    private Button mButton;


    /**
     * 设置按钮点击的回调
     */
    public interface ClickEventInterFace{
        void click(View v);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_six_layout,null);

        initView(rootView);
        bindListener();
        return rootView;
    }


    private void initView(View rootView) {

        mButton = (Button) rootView.findViewById(R.id.btn_fragment_six);

    }
    private void bindListener() {
        mButton.setOnClickListener(this);

    }


    /**
     * onClick中首先判断了当前绑定的Activity是否实现了该接口，如果实现了则调用。
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (getActivity() instanceof ClickEventInterFace){
            ((ClickEventInterFace) getActivity()).click(v);
            Toast.makeText(getActivity(), "Activity实现了该接口", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(), "Activity meiyou 实现了该接口", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d(TAG + "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(TAG + "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d(TAG + "onDetach");
    }
}
