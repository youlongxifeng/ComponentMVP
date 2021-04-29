package com.alc.xdt.module_main.ui.fragment.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.module_home.ui.fragment.details.DetailsFragment;
import com.alc.xdt.module_main.R;
import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.ISupportFragment;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
public class DemoFragment  extends BaseSupportFragment {
    TextView tv_Jump_home;

    public static DemoFragment newInstance(){
        return new DemoFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.demo_fragment;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        tv_Jump_home=view.findViewById(R.id.tv_Jump_home);

        ISupportFragment fragment = (ISupportFragment) ARouter.getInstance().build(Constants.Router.Home.F_DETAILS)
                .navigation();
        tv_Jump_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  _mActivity.start(DetailsFragment.newInstance());
                _mActivity.start(fragment);
            }
        });

    }
}
