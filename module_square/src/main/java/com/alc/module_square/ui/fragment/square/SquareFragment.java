package com.alc.module_square.ui.fragment.square;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.module_square.R;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
@Route(path = Constants.Router.Square.F_MAIN)
public class SquareFragment extends BaseSupportFragment {
    @Override
    public int getLayoutId() {
        return R.layout.square_fragment;
    }
}
