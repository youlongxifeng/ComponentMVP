package com.alc.module_home.ui.fragment.details;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.module_home.R;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
@Route(path = Constants.Router.Home.F_DETAILS)
public class DetailsFragment  extends BaseSupportFragment {
    public static DetailsFragment newInstance(){
        return new DetailsFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.details_fragment;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        Log.i("YYY","initView========DetailsFragment====");
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
        Log.i("YYY","initView========initData====");
    }
}
