package com.alc.module_user.ui.fragment.use;

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

import org.greenrobot.eventbus.EventBus;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
@Route(path = Constants.Router.User.F_MAIN)
public class UseFragment extends BaseSupportFragment {
    private TextView tv_use;

    public static UseFragment newInstance(){
        return new UseFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.use_fragment;
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        LogUtils.i("YYY","initView========UseFragment====");
        tv_use=view.findViewById(R.id.tv_use);
        tv_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
