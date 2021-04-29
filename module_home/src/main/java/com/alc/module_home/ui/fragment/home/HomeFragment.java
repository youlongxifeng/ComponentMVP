package com.alc.module_home.ui.fragment.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.module_home.R;
import com.alc.module_home.ui.fragment.details.DetailsFragment;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.ISupportFragment;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
@Route(path = Constants.Router.Home.F_MAIN)
public class HomeFragment extends BaseSupportFragment {
    private TextView tv_jump_details;

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        Log.i("YYY", "==initView=======");
        tv_jump_details = view.findViewById(R.id.tv_jump_details);
        ARouter.getInstance().build(Constants.Router.Home.F_DETAILS).navigation(getActivity(), new NavCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.d("ARouter", "找到了");
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.d("ARouter", "找不到了");
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.d("ARouter", "跳转完了");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.d("ARouter", "被拦截了");
            }
        });
        ISupportFragment fragment = (ISupportFragment) ARouter.getInstance().build(Constants.Router.Home.F_DETAILS)
                .navigation();

        tv_jump_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.start(DetailsFragment.newInstance());
                Log.i("YYY", "==onClick=======");
            }
        });
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
    }
}
