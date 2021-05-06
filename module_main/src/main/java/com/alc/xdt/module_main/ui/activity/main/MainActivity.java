package com.alc.xdt.module_main.ui.activity.main;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.alc.library_common.base.BaseSupportActivity;
import com.alc.library_common.common.Constants;
import com.alc.xdt.module_main.R;
import com.alc.xdt.module_main.ui.fragment.demo.DemoFragment;
import com.alc.xdt.module_main.ui.fragment.main.Main2Fragment;
import com.alc.xdt.module_main.ui.fragment.main.MainFragment;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.ISupportFragment;
import com.weikaiyun.fragmentation.SupportHelper;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
@Route(path = Constants.Router.Main.A_MAIN)
public class MainActivity extends BaseSupportActivity {
    private MainFragment mainFragment;
    @Override
    public int getContentViewID() {
        return R.layout.main_acitiviy;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        ARouter.getInstance().build(Constants.Router.Home.F_MAIN).navigation(this, new NavCallback() {
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
          mainFragment = SupportHelper.findFragment(getSupportFragmentManager(), MainFragment.class);
        //  DemoFragment mainFragment = SupportHelper.findFragment(getSupportFragmentManager(), DemoFragment.class);
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
        loadRootFragment(R.id.container, mainFragment);
        }

    }

    @Override
    public void startBrotherFragment(ISupportFragment targetFragment) {
        super.startBrotherFragment(targetFragment);
        Log.i("YYY", "==targetFragment======="+targetFragment.getClass().getSimpleName());
         mainFragment.startBrotherFragment(targetFragment);
       // loadRootFragment(R.id.container, targetFragment);
    }
}
