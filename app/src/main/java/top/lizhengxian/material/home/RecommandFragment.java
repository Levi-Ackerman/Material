package top.lizhengxian.material.home;

import android.net.Uri;
import android.view.View;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import top.lizhengxian.material.R;
import top.lizhengxian.material.core.BaseFragment;

/**
 * ************************************************************
 * Copyright (C) 2005 - 2017 UCWeb Inc. All Rights Reserved
 * Description  :  top.lizhengxian.material.RecommandFragment.java
 * <p>
 * Creation     : 2017/3/23
 * Author       : zhengxian.lzx@alibaba-inc.com
 * History      : Creation, 2017 lizx, Create the file
 * *************************************************************
 *
 * @author Administrator
 *  2017/03/23
 */

public class RecommandFragment extends BaseFragment {
    String url = "http://www.aotu15.com/file/5372/1/670f222fa7099efa3e44/1490748142/mp4/5372.mp4";
//    String url = "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";

    @BindView(R.id.player)
    JCVideoPlayerStandard mJCVideoPlayerStandard;
    @Override
    protected void initView(View rootView) {
        mJCVideoPlayerStandard.setUp(url,
                JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"hello");
        mJCVideoPlayerStandard.thumbImageView.setImageURI(Uri.parse(
                "http://www.aotu15.com/media/videos/tmb/000/005/372/player.jpg"));
    }

    @Override
    protected int getRootRes() {
        return R.layout.fragment_recommand;
    }
}
