package top.lizhengxian.material.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import top.lizhengxian.material.R;
import top.lizhengxian.material.core.BaseFragment;
import top.lizhengxian.material.model.VideoModel;

/**
 * Created by lee on 17-3-26.
 */

public class SectionFragment extends BaseFragment {
    protected RecyclerViewVideoAdapter mVideoListAdapter;
    @BindView(R.id.videolist)
    protected RecyclerView mVideoListView;
    protected VideoModel mVideoModel;
    @Override
    protected void initView(View rootView) {
        mVideoListAdapter = new RecyclerViewVideoAdapter(getActivity());
        mVideoListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mVideoListView.setAdapter(mVideoListAdapter);
        mVideoModel = new VideoModel();
    }

    @Override
    protected int getRootRes() {
        return R.layout.fragment_video;
    }
}
