package com.alc.module_home.ui.fragment.details;

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
import com.alc.module_home.ui.fragment.home.HomeFragment;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.ISupportFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * @Title:内容详情
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
@Route(path = Constants.Router.Home.F_DETAILS)
public class DetailsFragment  extends BaseSupportFragment {
    private TextView mtv_jump_extend;

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
        ISupportFragment fragment = (ISupportFragment) ARouter.getInstance().build(Constants.Router.User.F_INTEGRAL)
                .navigation();
        ARouter.getInstance().build(Constants.Router.User.F_INTEGRAL).navigation(getActivity(), new NavCallback() {
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
        mtv_jump_extend=view.findViewById(R.id.tv_jump_extend);
        mtv_jump_extend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //start(fragment);
           //   getParentFragment().getParentFragment().startBrotherFragment(fragment);
              //  ((HomeFragment) getParentFragment().getParentFragment()).startBrotherFragment(fragment);
                Fragment homeFragment=   getParentFragment();
               // Log.i("YYY","initView========homeFragment===="+(homeFragment!=null)+" ="+homeFragment.getClass().getSimpleName());
           // _mActivity.startBrotherFragment(fragment);
                EventBus.getDefault().post(Constants.Router.User.F_INTEGRAL);
            }
        });
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
        Log.i("YYY","initView========initData====");
    }
}
