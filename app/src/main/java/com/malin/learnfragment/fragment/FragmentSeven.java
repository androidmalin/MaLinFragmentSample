package com.malin.learnfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.malin.learnfragment.R;
import com.malin.learnfragment.activity.MainActivity6;
import com.orhanobut.logger.Logger;

/**
 * 类描述:
 * 创建人:lin.ma@renren-inc.com
 * 创建时间:16-2-24
 * 备注:{@link } Thanks for  ,Her code is very good ! I made reference to his code,It saves me a lot of time!
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class FragmentSeven extends Fragment implements View.OnClickListener{

    private static final String TAG = FragmentSeven.class.getSimpleName();
    private static FragmentSeven fragmentSeven;
    private Button mButton;

    public static FragmentSeven newInstance(Bundle bundle){
        fragmentSeven = new FragmentSeven();
        fragmentSeven.setArguments(bundle);
        return fragmentSeven;
    }

    private clickButtonSevenEvent clickButtonSevenEvent;

    public interface clickButtonSevenEvent{
        void click(View view);
    }


    public void setSevenButtonClickListener(clickButtonSevenEvent clickEvent){
        this.clickButtonSevenEvent = clickEvent;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_seven_layout,null);
        initView(rootView);
        bindListener();
        return rootView;
    }

    private void initView(View rootView) {
        mButton = (Button) rootView.findViewById(R.id.button_seven);
    }

    private void bindListener() {
        mButton.setOnClickListener(this);
    }


    private  Bundle bundle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        Logger.t(TAG).d(bundle.toString());
        Logger.t(TAG).d("bundle name--> "+bundle.getString(MainActivity6.BUNDLE_NAME));
    }

    @Override
    public void onClick(View v) {
        Logger.t(TAG).d(bundle.toString());
        v.setTag(bundle);
        if (clickButtonSevenEvent!=null){
            clickButtonSevenEvent.click(v);
        }
    }
}
