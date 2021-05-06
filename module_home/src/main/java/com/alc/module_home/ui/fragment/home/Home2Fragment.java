package com.alc.module_home.ui.fragment.home;

import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.module_home.R;
import com.alc.module_home.adapter.HomeFragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
public class Home2Fragment  extends BaseSupportFragment {
    private ViewPager mview_page;
    private TabLayout mTabLayout;
    private HomeFragmentStateAdapter mHomeFragmentStateAdapter;
    private String[] tabs = {"项目", "商场", "我的", "我的"};
    private TextView tv_jump_details;

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment;
    }
}
