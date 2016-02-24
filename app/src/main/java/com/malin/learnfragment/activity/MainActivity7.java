package com.malin.learnfragment.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.malin.learnfragment.R;
import com.malin.learnfragment.fragment.FragmentSeven;
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
public class MainActivity7 extends Activity implements FragmentSeven.clickButtonSevenEvent {


    private static final String TAG = MainActivity7.class.getSimpleName();
    private FragmentSeven fragmentSeven;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_7);
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getBundleExtra(MainActivity6.INTENT_NAME);

            Logger.t(TAG).d(bundle.toString());
            Logger.t(TAG).d("bundle name--> "+bundle.getString(MainActivity6.BUNDLE_NAME));
        }
        if (savedInstanceState == null) {
            setDefaultFragment();
        }
    }


    private void setDefaultFragment() {
        if (fragmentSeven == null) {
            fragmentSeven = FragmentSeven.newInstance(bundle);
            fragmentSeven.setSevenButtonClickListener(this);
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_content_activity_7, fragmentSeven, "fragmentSeven");
        fragmentTransaction.commit();
    }


    @Override
    public void click(View view) {
        switch (view.getId()) {

            case R.id.button_seven: {
                Bundle bundle = (Bundle) view.getTag();
                String name = bundle.getString(MainActivity6.BUNDLE_NAME);
                Logger.t(TAG).d("bundle name--> "+name);
                Toast.makeText(MainActivity7.this, name, Toast.LENGTH_SHORT).show();
                break;
            }
            default: {
                break;
            }
        }
    }



}
