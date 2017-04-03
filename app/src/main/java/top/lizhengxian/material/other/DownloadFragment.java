package top.lizhengxian.material.other;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;
import butterknife.OnClick;
import top.lizhengxian.material.R;
import top.lizhengxian.material.core.BaseFragment;

/**
 * Created by lee on 17-3-29.
 */

public class DownloadFragment extends BaseFragment {

    int cur = 0;
    public static final String NETEASY_BASE_URL = "http://www.aotu15.com";
    public static final String RECENT = "http://www.aotu15.com/recent/";


    @BindView(R.id.btnLoad)
    Button mBtnLoad;
    @BindView(R.id.urlText)
    EditText mUrlText;

    @Override
    protected void initView(View rootView) {

    }

    @OnClick(R.id.btnLoad)
    protected void onClick() {
        try {
            cur = Integer.parseInt(mUrlText.getText().toString());
            new AsyncTask<String, String, String>() {
                @Override
                protected String doInBackground(String... params) {
                    try {
                        Document document = Jsoup.connect(RECENT + cur).get();
                        Elements elements = document.select(".videos").select("a[href]");
                        StringBuilder sb = new StringBuilder();
                        for (Element link : elements) {
                            String url = NETEASY_BASE_URL + link.attr("href");
                            Document videoDoc = Jsoup.connect(url).get();
                            String videoUrl = videoDoc.getElementsByTag("source").get(0).attr("src");
                            sb.append(videoUrl).append('\n');
                        }
                        return sb.toString();
                    }catch(Exception exceptions){

                    }
                    return null;
                }

                @Override
                protected void onPostExecute(String urls) {
                    super.onPostExecute(urls);
                    mUrlText.setText(urls);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } catch (Exception e) {

        }
    }

    @Override
    protected int getRootRes() {
        return R.layout.fragment_download;
    }
}
