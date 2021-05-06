package com.alc.xdt.module_main.ui.fragment.main;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alc.library_common.common.Constants;
import com.alc.xdt.module_main.ui.fragment.demo.DemoFragment;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
public class MainFragmentStateAdapter extends FragmentStateAdapter {


    public MainFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        Log.i("YYY","createFragment==="+position);
        if (position == 0) {
            fragment = (Fragment) ARouter.getInstance().build(Constants.Router.Home.F_MAIN)
                    .navigation();

        } else if (position == 1) {
            fragment = (Fragment) ARouter.getInstance().build(Constants.Router.Project.F_MAIN)
                    .navigation();
            return fragment;
        } else if (position == 2) {
            fragment = (Fragment) ARouter.getInstance().build(Constants.Router.Square.F_MAIN)
                    .navigation();

        } else if (position == 3) {
            fragment = (Fragment) ARouter.getInstance().build(Constants.Router.User.F_MAIN)
                    .navigation();

        } else {
            fragment = (Fragment) ARouter.getInstance().build(Constants.Router.User.F_MAIN)
                    .navigation();


        }
        return fragment;
//        return  (Fragment) ARouter.getInstance().build(Constants.Router.Home.F_MAIN)
//                .navigation();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
