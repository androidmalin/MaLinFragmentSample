package com.malin.learnfragment.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.malin.learnfragment.R;
import com.malin.learnfragment.reconstruction.FragmentFive;
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
public class MainActivity6 extends Activity implements FragmentFive.clickEvent {


    private static final String TAG = MainActivity6.class.getSimpleName();
    private FragmentFive fragmentFive;
    public static final String BUNDLE_NAME = "malin_bundle";
    public static final String INTENT_NAME = "malin_intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_6);
        Logger.t(TAG).d("MainActivity6 onCreate");
        if (savedInstanceState==null){
            setDefaultFragment();
        }
    }


    private void setDefaultFragment() {

        if (fragmentFive == null) {
            fragmentFive = new FragmentFive();
            fragmentFive.setOnButtonClickListener(this);
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_content_activity_main_6, fragmentFive, "FragmentFive");
        fragmentTransaction.commit();
    }


    @Override
    public void click(View v) {
       // Toast.makeText(MainActivity6.this, "MainActivity6 fragmentFive click", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity6.this,MainActivity7.class);

        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_NAME,"from MainActivity6");
        intent.putExtra(INTENT_NAME,bundle);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_activity_setting_one:{
                Toast.makeText(MainActivity6.this, "Activity setting one", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.menu_activity_setting_two:{
                Toast.makeText(MainActivity6.this, "Activity setting two", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        //如果希望Fragment自己处理MenuItem点击事件，一定不要忘了调用super.xxx
        return super.onOptionsItemSelected(item);
    }




}
