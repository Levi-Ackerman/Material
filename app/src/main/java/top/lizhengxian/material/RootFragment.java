package top.lizhengxian.material;

import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ************************************************************
 * Copyright (C) 2005 - 2017 UCWeb Inc. All Rights Reserved
 * Description  :  top.lizhengxian.material.RootFragment.java
 * <p>
 * Creation     : 2017/3/22
 * Author       : zhengxian.lzx@alibaba-inc.com
 * History      : Creation, 2017 lizx, Create the file
 * *************************************************************
 *
 * @author Administrator
 *  2017/03/22
 */

public class RootFragment extends BaseFragment {
    @BindView(R.id.btn)
    protected Button mJumpButton;

    @Override
    protected void initView(View rootView) {

    }

    @OnClick(R.id.btn)
    protected void onClick(){
        start(new JumpedFragment());
    }

    @Override
    protected int getRootRes() {
        return R.layout.fragment_root;
    }
}
