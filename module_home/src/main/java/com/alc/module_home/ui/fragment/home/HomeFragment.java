package com.alc.module_home.ui.fragment.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.module_home.R;
import com.alc.module_home.adapter.HomeFragmentStateAdapter;
import com.alc.module_home.ui.fragment.details.DetailsFragment;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.weikaiyun.fragmentation.ISupportFragment;
import com.weikaiyun.fragmentation.SupportFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
@Route(path = Constants.Router.Home.F_MAIN)
public class HomeFragment extends BaseSupportFragment {
    private ViewPager2 mview_page;
    private TabLayout mTabLayout;
    private HomeFragmentStateAdapter mHomeFragmentStateAdapter;
    private String[] tabs = {"项目", "商场", "我的", "我的"};
    private TextView tv_jump_details;

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        Log.i("YYY", "==initView=======");

        mview_page = view.findViewById(R.id.view_page);
        mTabLayout = view.findViewById(R.id.tabLayout);
        mHomeFragmentStateAdapter = new HomeFragmentStateAdapter(getActivity());
        mview_page.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mview_page.setAdapter(mHomeFragmentStateAdapter);
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
        //是否可滑动
        mview_page.setUserInputEnabled(true);
        mview_page.setOffscreenPageLimit(1);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mview_page, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabs[position]);
            }
        });
        tabLayoutMediator.attach();
    }

    @Override
    public void startBrotherFragment(ISupportFragment targetFragment) {
        start(targetFragment);
    }



}
