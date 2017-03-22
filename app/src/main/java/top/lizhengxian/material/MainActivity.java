package top.lizhengxian.material;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends BaseActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.contain,new RootFragment());
        }
//        Drawer drawer = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(mToolbar)
////                .withActionBarDrawerToggleAnimated(true)
//                .withRootView(R.id.contain)
//                .withHeader(R.layout.drawer_header)
////                .withDisplayBelowStatusBar(false)
//                .inflateMenu(R.menu.drawer)
//                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//                        return false;
//                    }
//                })
//                .build();
    }
}
