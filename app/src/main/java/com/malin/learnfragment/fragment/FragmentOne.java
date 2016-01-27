package com.malin.learnfragment.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.malin.learnfragment.R;
import com.orhanobut.logger.Logger;

/**
 * 类描述:
 * 创建人:lin.ma@renren-inc.com
 * 创建时间:16-1-26
 * 备注:
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class FragmentOne extends Fragment implements View.OnClickListener {


    private static final String TAG = FragmentOne.class.getSimpleName() + "-->";
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one_laytou, null);
        Logger.d(TAG + "onCreateView");
        initView(rootView);
        bindListener();
        return rootView;
    }

    private void bindListener() {
        mTextView.setOnClickListener(this);
    }

    private void initView(View rootView) {
        mTextView = (TextView) rootView.findViewById(R.id.tv_fragment_one);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv_fragment_one: {
                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        Toast.makeText(getActivity(), "FragmentTwo onBackStackChanged", Toast.LENGTH_SHORT).show();
                    }
                });

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentTwo fragmentTwo = new FragmentTwo();
                fragmentTransaction.replace(R.id.id_content_activity_3, fragmentTwo, "two");
                fragmentTransaction.addToBackStack("two_fragment");

                ///////////////////////////////////1111///////////////////////////////////////////////////////////
                // replace是remove和add的合体
                //并且如果不添加事务到回退栈，前一个FragmentOne实例会被销毁
                // FragmentOne-->onPause
                // FragmentOne-->onStop
                // FragmentOne-->onDestroyView 与onCreateView想对应，当该Fragment的视图被移除时调用
                // FragmentOne-->onDestroy
                // FragmentOne-->onDetach 与onAttach相对应，当Fragment与Activity关联被取消时调用
                //
                ///////////////////////////////////2222///////////////////////////////////////////////////////////

                //添加事务到回退栈
                // FragmentOne-->onPause
                // FragmentOne-->onStop
                // FragmentOne-->onDestroyView 与onCreateView想对应，当该Fragment的视图被移除时调用
                //调用fragmentTransaction.addToBackStack("");将当前的事务添加到了回退栈，
                // 所以FragmentOne实例不会被销毁，但是视图层次依然会被销毁，
                // 即会调用onDestroyView



                fragmentTransaction.commit();
                break;
            }

            default: {

                break;
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d(TAG + "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d(TAG + "onStop");
    }


    @Override
    public void onStart() {
        super.onStart();
        Logger.d(TAG + "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d(TAG + "onResume");
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
