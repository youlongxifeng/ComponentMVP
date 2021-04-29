package com.alc.xdt.module_main.ui.fragment.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;

import com.alc.library_common.base.BaseSupportActivity;
import com.alc.library_common.base.BaseSupportFragment;
import com.alc.xdt.module_main.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
public class MainFragment extends BaseSupportFragment {
    private ViewPager2 mview_page;
    private TabLayout mTabLayout;
    private MainFragmentStateAdapter mMainFragmentStateAdapter;
    private String[]tabs={"项目","商场","我的","我的"};

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        mview_page=view.findViewById(R.id.view_page);
        mTabLayout=view.findViewById(R.id.tabLayout);
        mMainFragmentStateAdapter=new MainFragmentStateAdapter(getActivity());
        mview_page.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mview_page.setAdapter(mMainFragmentStateAdapter);
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
        //是否可滑动
        mview_page.setUserInputEnabled(true);
        mview_page.setOffscreenPageLimit(5);
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator( mTabLayout, mview_page, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabs[position]);
            }
        });
        tabLayoutMediator.attach();

    }
}
