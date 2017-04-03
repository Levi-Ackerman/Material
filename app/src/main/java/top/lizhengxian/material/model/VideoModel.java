package top.lizhengxian.material.model;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by lee on 17-4-3.
 */

public class VideoModel {
    private static final String BASE_VIDEO_URL = "http://www.aotu9.com";

    public VideoModel(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_VIDEO_URL)
                .build();
        VideoService videoService = retrofit.create(VideoService.class);
        videoService.listVideo(2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String html) {
                        Log.e("lee..",html);
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.e("lee..","complete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.e("lee..","error",e);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("lee..","next");
                    }
                });
    }

    interface VideoService {
        @GET("/recent/{id}")
        Observable<String> listVideo(@Path("id") int pageId);
    }
    class Video{
        String videoUrl;
        String thumbUrl;
        String title;
        String time;
    }
}
