package com.malin.learnfragment.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.malin.learnfragment.R;
import com.malin.learnfragment.fragment.FragmentOne;
import com.malin.learnfragment.fragment.FragmentTwo;

/**
 * 类描述:
 * 创建人:lin.ma@renren-inc.com
 * 创建时间:16-1-26
 * 备注:{@link } Thanks for  ,Her code is very good ! I made reference to his code,It saves me a lot of time!
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class MainActivity2 extends Activity implements View.OnClickListener {
    private Button mButtonOne;
    private Button mButtonTwo;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_2);
        initView();
        bindListener();


        // 设置默认的Fragment
        setDefaultFragment();
    }


    private void initView() {

        mButtonOne = (Button) findViewById(R.id.btn_one);
        mButtonTwo = (Button) findViewById(R.id.btn_two);
    }

    private void bindListener() {
        mButtonOne.setOnClickListener(this);
        mButtonTwo.setOnClickListener(this);


    }


    private void setDefaultFragment() {


        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mFragmentOne = new FragmentOne();
        mFragmentOne.setClickEnable();
        transaction.replace(R.id.frameLayout_content, mFragmentOne);
        transaction.commit();
    }

    /**
     *
     *
     * Fragment常用的三个类
     *
     * android.app.Fragment 主要用于定义Fragment
     *
     * android.app.FragmentManager 主要用于在Activity中操作Fragment
     *
     * android.app.FragmentTransaction 保证一些列Fragment操作的原子性，熟悉事务这个词，一定能明白~
     *
     *
     *
     *
     * @param v
     */

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fgtransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.btn_one: {
                if (mFragmentOne == null) {
                    mFragmentOne = new FragmentOne();
                    mFragmentOne.setClickEnable();
                }
                fgtransaction.replace(R.id.frameLayout_content, mFragmentOne);
                break;
            }

            case R.id.btn_two: {
                if (mFragmentTwo == null) {
                    mFragmentTwo = new FragmentTwo();
                    mFragmentTwo.setClickEnable();
                }

                fgtransaction.replace(R.id.frameLayout_content, mFragmentTwo);
                break;
            }


//            case R.id.btn_one: {
//                if (mFragmentTwo!=null){
//                    fgtransaction.hide(mFragmentTwo);
//                }
//
//                if (mFragmentOne == null) {
//                    mFragmentOne = new FragmentOne();
//                    mFragmentOne.setClickEnable();
//                    fgtransaction.add(R.id.frameLayout_content, mFragmentOne);
//                }else{
//                    fgtransaction.show(mFragmentOne);
//                }
//                break;
//            }
//
//            case R.id.btn_two: {
//
//                if (mFragmentOne!=null){
//                    fgtransaction.hide(mFragmentOne);
//                }
//
//                if (mFragmentTwo == null) {
//                    mFragmentTwo = new FragmentTwo();
//                    mFragmentTwo.setClickEnable();
//                    fgtransaction.add(R.id.frameLayout_content,mFragmentTwo);
//                }else{
//                    fgtransaction.show(mFragmentTwo);
//                }
//                break;
//            }

            default: {
                break;
            }
        }
        fgtransaction.commit();
    }
}
