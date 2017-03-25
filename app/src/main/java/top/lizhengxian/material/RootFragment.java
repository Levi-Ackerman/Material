package top.lizhengxian.material;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

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
 *         2017/03/22
 */

public class RootFragment extends BaseFragment {

    @BindView(R.id.btn)
    protected Button mJumpButton;

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.contain)
    protected ViewGroup mContentView;

    protected Drawer mDrawer;

    @Override
    protected void initView(View rootView) {
        mDrawer = new DrawerBuilder()
                .withActivity(getActivity())
                .withToolbar(mToolbar)
                .withHeader(R.layout.drawer_header)
                .inflateMenu(R.menu.drawer)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                })
                .build();
    }

    @OnClick(R.id.btn)
    protected void onClick() {
        start(new JumpedFragment());
    }

    @Override
    protected int getRootRes() {
        return R.layout.fragment_root;
    }

    @Override
    public boolean onBackPressedSupport() {
        if (mDrawer !=null && mDrawer.isDrawerOpen()){
            mDrawer.closeDrawer();
            return true;
        }
        return super.onBackPressedSupport();
    }
}
