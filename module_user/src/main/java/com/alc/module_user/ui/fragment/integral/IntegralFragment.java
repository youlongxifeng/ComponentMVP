package com.alc.module_user.ui.fragment.integral;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.library_common.uitle.LogUtils;
import com.alc.module_user.R;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.ISupportFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * @Title:我的积分
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
@Route(path = Constants.Router.User.F_INTEGRAL)
public class IntegralFragment extends BaseSupportFragment {
    private TextView mtv_jump_extend;

    public static IntegralFragment newInstance(){
        return new IntegralFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.integral_fragment;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        LogUtils.i("initView========DetailsFragment====");
        mtv_jump_extend=view.findViewById(R.id.tv_jump_extend);
        mtv_jump_extend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(Constants.Router.User.F_MAIN);
            }
        });
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
        Log.i("YYY","initView========initData====");
    }
}
