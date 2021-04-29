package com.alc.xdt.module_main.ui.fragment.main;

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
        return (Fragment) ARouter.getInstance().build(Constants.Router.Home.F_MAIN)
                .navigation();
        //return new DemoFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
