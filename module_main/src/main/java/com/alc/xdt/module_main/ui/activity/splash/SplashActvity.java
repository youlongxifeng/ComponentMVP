package com.alc.xdt.module_main.ui.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alc.library_common.base.BaseSupportActivity;
import com.alc.library_common.common.Constants;
import com.alc.library_common.common.router.RouteHelper;
import com.alc.xdt.module_main.R;
import com.alc.xdt.module_main.ui.fragment.demo.DemoFragment;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
public class SplashActvity extends BaseSupportActivity {
    TextView tv_splash;

    @Override
    public int getContentViewID() {
        return R.layout.splash_activity;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        tv_splash=findViewById(R.id.tv_splash);
        tv_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 RouteHelper.navigateTo(Constants.Router.Main.A_MAIN);
//                DemoFragment    mainFragment = DemoFragment.newInstance();
//                loadRootFragment(R.id.container, mainFragment);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}