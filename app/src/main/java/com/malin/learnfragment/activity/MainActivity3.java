package com.malin.learnfragment.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.malin.learnfragment.R;
import com.malin.learnfragment.fragment.FragmentOne;
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
public class MainActivity3 extends Activity {
    private static final String TAG = MainActivity3.class.getSimpleName()+"-->";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        Logger.d(TAG + "onCreate");
        addFragment();

    }

    private void addFragment() {
        FragmentOne fragmentOne = new FragmentOne();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Toast.makeText(MainActivity3.this, "MainActivity3 FragmentOne onBackStackChanged ", Toast.LENGTH_SHORT).show();
            }
        });
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.id_content_activity_3, fragmentOne, "one");
        fragmentTransaction.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(TAG + "onDestroy");
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


}
