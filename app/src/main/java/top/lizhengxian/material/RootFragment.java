package top.lizhengxian.material;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    protected Drawer mDrawer;

    @BindView(R.id.tablayout)
    protected TabLayout mTabLayout;

    @BindView(R.id.viewpager)
    protected ViewPager mViewPager;
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
        mTabLayout.addTab(mTabLayout.newTab().setText("推荐"));
        mTabLayout.addTab(mTabLayout.newTab().setText("发现"));
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new JumpedFragment();
            }

            @Override
            public int getCount() {
                return 1;
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
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
