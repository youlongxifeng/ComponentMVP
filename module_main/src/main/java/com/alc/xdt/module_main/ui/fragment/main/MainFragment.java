package com.alc.xdt.module_main.ui.fragment.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;

import com.alc.library_common.base.BaseSupportActivity;
import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.xdt.module_main.R;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.weikaiyun.fragmentation.ISupportFragment;
import com.weikaiyun.fragmentation.SupportFragment;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
@Route(path = Constants.Router.Main.F_MAIN)
public class MainFragment extends BaseSupportFragment {
    private ViewPager2 mview_page;
    private TabLayout mTabLayout;
    private MainFragmentStateAdapter mMainFragmentStateAdapter;
    private String[]tabs={"项目","商场","广场","我的"};

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
      mview_page.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);//水平滑动
       mview_page.setAdapter(mMainFragmentStateAdapter);
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
        //是否可滑动
        mview_page.setUserInputEnabled(false);
        mview_page.setOffscreenPageLimit(2);//预加载几页
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator( mTabLayout, mview_page, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabs[position]);
            }
        });
        tabLayoutMediator.attach();
        LinearLayout linearLayout = (LinearLayout) mTabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView == null) {
                    tab.setCustomView(R.layout.tab_text_layout);
                }
                TextView textView = tab.getCustomView().findViewById(android.R.id.text1);
                textView.setTextAppearance(getActivity(), R.style.TabLayoutTextSelected);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView == null) {
                    tab.setCustomView(R.layout.tab_text_layout);
                }
                TextView textView = tab.getCustomView().findViewById(android.R.id.text1);
                textView.setTextAppearance(getActivity(), R.style.TabLayoutTextUnSelected);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    /**
     * start other BrotherFragment
     */
    public void startBrotherFragment(ISupportFragment targetFragment) {
        Log.i("YYY", "MainFragment==targetFragment======="+targetFragment.getClass().getSimpleName());
        startWithPop(targetFragment);

    }
}
