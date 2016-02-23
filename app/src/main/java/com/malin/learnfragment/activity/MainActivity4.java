package com.malin.learnfragment.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.malin.learnfragment.R;
import com.malin.learnfragment.reconstruction.FragmentSix;
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
public class MainActivity4 extends Activity implements FragmentSix.ClickEventInterFace {

    private static final String TAG = MainActivity4.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.d("onCreate");
        setContentView(R.layout.activity_main_4);

        setFragment();
    }


    private void setFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentSix fragmentSix = new FragmentSix();
        fragmentTransaction.add(R.id.id_content_activity_4, fragmentSix, "fragment_five");
        //fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();

    }

    @Override
    public void click(View v) {
        Logger.d("MainActivity4 setClickEventInterFace");
        Toast.makeText(MainActivity4.this, "fragmentSix button", Toast.LENGTH_SHORT).show();
    }
}
