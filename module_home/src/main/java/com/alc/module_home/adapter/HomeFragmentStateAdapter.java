package com.alc.module_home.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alc.library_common.common.Constants;
import com.alc.module_home.ui.fragment.android.AndroidFragment;
import com.alc.module_home.ui.fragment.details.DetailsFragment;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
public class HomeFragmentStateAdapter extends FragmentStateAdapter {


    public HomeFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
    //    return AndroidFragment.newInstance();
//        if (position == 0) {
//            return AndroidFragment.newInstance();
//        }
      return DetailsFragment.newInstance();

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
