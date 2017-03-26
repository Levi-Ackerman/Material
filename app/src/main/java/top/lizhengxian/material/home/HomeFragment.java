package top.lizhengxian.material.home;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import top.lizhengxian.material.R;
import top.lizhengxian.material.core.BaseFragment;

/**
 * ************************************************************
 * Copyright (C) 2005 - 2017 UCWeb Inc. All Rights Reserved
 * Description  :  top.lizhengxian.material.HomeFragment.java
 * <p>
 * Creation     : 2017/3/22
 * Author       : zhengxian.lzx@alibaba-inc.com
 * History      : Creation, 2017 lizx, Create the file
 * *************************************************************
 *
 * @author Administrator
 *         2017/03/22
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    protected Drawer mDrawer;

    @BindView(R.id.tablayout)
    protected TabLayout mTabLayout;

    @BindView(R.id.viewpager)
    protected ViewPager mViewPager;

    @Override
    protected void initView(View rootView) {
        mToolbar.inflateMenu(R.menu.bar);
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
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.setTabTextColors(getResources().getColor(R.color.tabNormal),getResources().getColor(R.color.tabSelected));
        mTabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0)
                    return new RecommandFragment();
                if (position == 1)
                    return new SectionFragment();
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if(position == 0)
                    return "推荐";
                else
                    return "分区";
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected int getRootRes() {
        return R.layout.fragment_home;
    }

    @Override
    public boolean onBackPressedSupport() {
        if (mDrawer != null && mDrawer.isDrawerOpen()) {
            mDrawer.closeDrawer();
            return true;
        }
        return super.onBackPressedSupport();
    }
}
