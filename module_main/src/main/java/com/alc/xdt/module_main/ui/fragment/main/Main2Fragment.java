package com.alc.xdt.module_main.ui.fragment.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.xdt.module_main.R;
import com.alc.xdt.module_main.view.BottomBar;
import com.alc.xdt.module_main.view.BottomBarTab;
import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.ISupportActivity;
import com.weikaiyun.fragmentation.ISupportFragment;
import com.weikaiyun.fragmentation.SupportFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
public class Main2Fragment extends BaseSupportFragment {
    private static final int REQ_MSG = 10;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOUR = 3;

    private SupportFragment[] mFragments = new SupportFragment[4];

    private BottomBar mBottomBar;


    public static Main2Fragment newInstance() {

        Bundle args = new Bundle();

        Main2Fragment fragment = new Main2Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.i("YYY", "(context context context)::" + (context instanceof ISupportActivity));
        super.onAttach(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment2_main;
    }


    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        mBottomBar
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_message_white_24dp, getString(R.string.project_name)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_account_circle_white_24dp, getString(R.string.public_name)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_discover_white_24dp, getString(R.string.square_name)))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_discover_white_24dp, getString(R.string.use_name)));

        // 模拟未读消息
        mBottomBar.getItem(FIRST).setUnreadCount(9);

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
                BottomBarTab tab = mBottomBar.getItem(FIRST);
                if (position == FIRST) {
                    tab.setUnreadCount(0);
                } else {
                    tab.setUnreadCount(tab.getUnreadCount() + 1);
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                // EventBusActivityScope.getDefault(_mActivity).post(new TabSelectedEvent(position));
            }
        });
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
        SupportFragment fragment = (SupportFragment) ARouter.getInstance().build(Constants.Router.Home.F_MAIN)
                .navigation();
        SupportFragment projectFragment = findChildFragment(fragment.getClass());
        SupportFragment publicFragment = (SupportFragment) ARouter.getInstance().build(Constants.Router.Home.F_MAIN)
                .navigation();
        SupportFragment squareFragment = (SupportFragment) ARouter.getInstance().build(Constants.Router.Project.F_MAIN)
                .navigation();
        SupportFragment useFragment = (SupportFragment) ARouter.getInstance().build(Constants.Router.User.F_MAIN)
                .navigation();
        if (projectFragment == null) {
            mFragments[FIRST] = (SupportFragment) ARouter.getInstance().build(Constants.Router.Home.F_MAIN)
                    .navigation();
            mFragments[SECOND] = publicFragment;
            mFragments[THIRD] = squareFragment;
            mFragments[FOUR] = useFragment;

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOUR]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = projectFragment;
            mFragments[SECOND] = findChildFragment(publicFragment.getClass());
            mFragments[THIRD] = findChildFragment(squareFragment.getClass());
            mFragments[FOUR] = findChildFragment(useFragment.getClass());
        }
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (requestCode == REQ_MSG && resultCode == RESULT_OK) {

        }
    }

    /**
     * start other BrotherFragment
     */
    public void startBrotherFragment(ISupportFragment targetFragment) {
        start(targetFragment);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String event) {
        Log.i("YYY", "initView========event====" + event);
        ISupportFragment fragment = (ISupportFragment) ARouter.getInstance().build(event)
                .navigation();
        start(fragment);
    }
}
