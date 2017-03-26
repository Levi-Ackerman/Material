package top.lizhengxian.material.home;

import android.os.Bundle;

import top.lizhengxian.material.R;
import top.lizhengxian.material.core.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.contain,new HomeFragment());
        }
    }
}
