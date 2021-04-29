package com.alc.library_common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.weikaiyun.fragmentation.SupportActivity;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
public abstract class BaseSupportActivity extends SupportActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewID());
    }

    abstract public int getContentViewID();

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initView(savedInstanceState);
        initData(savedInstanceState);
    }

    public void initView(@Nullable Bundle savedInstanceState) {

    }

    public void initData(@Nullable Bundle savedInstanceState) {

    }
}

