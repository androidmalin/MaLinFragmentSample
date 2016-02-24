package com.malin.learnfragment.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.malin.learnfragment.R;
import com.malin.learnfragment.reconstruction.FragmentFive;

/**
 * 类描述:
 * 创建人:lin.ma@renren-inc.com
 * 创建时间:16-2-24
 * 备注:{@link } Thanks for  ,Her code is very good ! I made reference to his code,It saves me a lot of time!
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class MainActivity5 extends Activity {


    FragmentFive fragmentFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_5);
        setDefaultFragment();
        clickEvent();
    }


    private void setDefaultFragment() {

        if (fragmentFive == null) {
            fragmentFive = new FragmentFive();
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_content_activity_main_5, fragmentFive, "FragmentFive");
        fragmentTransaction.commit();
    }


    private void clickEvent() {
        fragmentFive.setOnButtonClickListener(new FragmentFive.clickEvent() {
            @Override
            public void click(View v) {
                Toast.makeText(MainActivity5.this, "MainActivity5 fragmentFive click", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
