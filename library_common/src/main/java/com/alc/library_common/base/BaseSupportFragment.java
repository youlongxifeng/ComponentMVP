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
import com.weikaiyun.fragmentation.SupportFragment;

public abstract class BaseSupportFragment extends SupportFragment {
    protected ARouter mRouter = ARouter.getInstance();
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

    abstract public int getLayoutId();

    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
