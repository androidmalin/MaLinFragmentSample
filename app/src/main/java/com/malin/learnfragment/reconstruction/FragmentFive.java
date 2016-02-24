package com.malin.learnfragment.reconstruction;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.malin.learnfragment.R;
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
public class FragmentFive extends Fragment implements View.OnClickListener {

    private static final String TAG = FragmentFive.class.getSimpleName();
    private Button btn_fragment_five;
    private clickEvent clickEvent;

    public interface clickEvent {
        void click(View v);
    }

    public void setOnButtonClickListener(clickEvent onclickListener) {
        this.clickEvent = onclickListener;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.t(TAG).d(TAG + "-->" + "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_five_layout, null);

        initView(rootView);
        bindListener();

        return rootView;
    }

    private void initView(View rootView) {
        btn_fragment_five = (Button) rootView.findViewById(R.id.btn_fragment_five);
    }

    private void bindListener() {
        btn_fragment_five.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_fragment_five: {

                if (clickEvent != null) {
                    clickEvent.click(v);
                }
                break;
            }
            default: {
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.t(TAG).d(TAG + "-->" + "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.t(TAG).d(TAG + "-->" + "onStop");
    }


    @Override
    public void onStart() {
        super.onStart();
        Logger.t(TAG).d(TAG + "-->" + "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.t(TAG).d(TAG + "-->" + "onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.t(TAG).d(TAG + "-->" + "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.t(TAG).d(TAG + "-->" + "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.t(TAG).d(TAG + "-->" + "onDetach");
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting_one:{
                Toast.makeText(getActivity(), "menu_setting_one", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_setting_two:{
                Toast.makeText(getActivity(), "menu_setting_two", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return true;
    }
}
