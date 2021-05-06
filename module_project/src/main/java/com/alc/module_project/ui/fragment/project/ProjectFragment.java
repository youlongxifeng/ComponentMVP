package com.alc.module_project.ui.fragment.project;

import com.alc.library_common.base.BaseSupportFragment;
import com.alc.library_common.common.Constants;
import com.alc.module_project.R;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.weikaiyun.fragmentation.SupportFragment;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/30
 */
@Route(path = Constants.Router.Project.F_MAIN)
public class ProjectFragment extends BaseSupportFragment {
    @Override
    public int getLayoutId() {
        return R.layout.project_fragment;
    }


}
