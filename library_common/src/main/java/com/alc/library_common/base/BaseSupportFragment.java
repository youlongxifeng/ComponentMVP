package com.alc.library_common.base;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.ISupportFragment;
import com.weikaiyun.fragmentation.SupportFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseSupportFragment extends SupportFragment {
    protected ARouter mRouter = ARouter.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view, savedInstanceState);
        initData(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    abstract public int getLayoutId();

    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
    @Override
    public void startBrotherFragment(ISupportFragment targetFragment) {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(String message) {

    }
}
