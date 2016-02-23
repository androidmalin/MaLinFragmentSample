package com.malin.learnfragment.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.malin.learnfragment.R;
import com.orhanobut.logger.Logger;

/**
 * 类描述:
 * 创建人:lin.ma@renren-inc.com
 * 创建时间:16-1-26
 * 备注:{@link } Thanks for  ,Her code is very good ! I made reference to his code,It saves me a lot of time!
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class FragmentTwo extends Fragment implements View.OnClickListener {
    private static final String TAG = FragmentTwo.class.getSimpleName()+"-->";
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two_layout, null);
        Logger.d(TAG + "onCreateView");
        initView(rootView);
        bindListener();
        return rootView;
    }
    private boolean mIsClick = true;

    public  void setClickEnable(){
        mIsClick = false;
    }


    private void initView(View rootView) {
        mTextView = (TextView) rootView.findViewById(R.id.tv_fragment_two);
    }

    private void bindListener() {
        mTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


//            这里点击时，我们没有使用replace，而是先隐藏了当前的Fragment，
//            然后添加了FragmentThree的实例，最后将事务添加到回退栈。
//            这样做的目的是为了给大家提供一种方案：
//            如果不希望视图重绘该怎么做，请再次仔细看效果图，我们在FragmentTwo的EditText填写的内容，用户Back回来时，数据还在~~~

            case R.id.tv_fragment_two: {

                if (mIsClick){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    FragmentThree fragmentThree = new FragmentThree();
                    fragmentTransaction.hide(this);
                    fragmentTransaction.add(R.id.frameLayout_content, fragmentThree, "three");
                    fragmentTransaction.addToBackStack("two_fragment");
                    fragmentTransaction.commit();
                }
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
        Logger.d(TAG+"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d(TAG + "onDetach");
    }
}
