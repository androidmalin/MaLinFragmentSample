package com.malin.learnfragment.activity;

import android.app.Activity;
import android.os.Bundle;

import com.malin.learnfragment.R;

public class MainActivity extends Activity {

//    是不是把Fragment当成普通的View一样声明在Activity的布局文件中，
//    然后所有控件的事件处理等代码都由各自的Fragment去处理，瞬间觉得Activity好干净有木有~~代码的可读性、
//    复用性以及可维护性是不是瞬间提升了
    //静态的使用Fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
