package whatanews.org.com.whatapost.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import whatanews.org.com.whatapost.Adapter.StatePagerAdapter;
import whatanews.org.com.whatapost.Networking.ImageAPIInterface;
import whatanews.org.com.whatapost.Networking.ImageURLInfoBean;
import whatanews.org.com.whatapost.R;

/**
 * Created by mobileprogramming on 05/02/18.
 */

public class StatePagerFragment extends Fragment {

    @BindView(R.id.news_image_view_pager)
    ViewPager mViewPager;
    @BindView(R.id.pager_container)
    LinearLayout pagerContainerLayout;
    @BindView(R.id.news_description)
    TextView newsDescription;
    @BindView(R.id.news_full_description)
    WebView newsFullDescription;

    private ArrayList<ImageURLInfoBean> imageURLInfoBeans;


    private static final String TAG = "FragmentStatPgrAdapFrag";
    private StatePagerAdapter mPagerAdapter;
    private ArrayList<ImageURLInfoBean> mImageItemList;

    public StatePagerFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void slideToTop(View view) {
        TranslateAnimation animate = new TranslateAnimation(0, 0, 0, -view.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.GONE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sample, container, false);
        ButterKnife.bind(this, rootView);

        getJSONData();

        newsDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideToTop(pagerContainerLayout);
                newsFullDescription.setVisibility(View.VISIBLE);
                newsFullDescription.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        view.loadUrl("https://www.google.co.in/");
                        return false;
                    }
                });
            }
        });

        return rootView;

    }


    private void getJSONData() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vps165909.vps.ovh.ca/index.php/wp-json/whattapost-api/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImageAPIInterface imageAPIInterface = retrofit.create(ImageAPIInterface.class);
        Call<List<ImageURLInfoBean>> imagesResponseCall = imageAPIInterface.geImagesResponseCall();
        imagesResponseCall.enqueue(new Callback<List<ImageURLInfoBean>>() {
            @Override
            public void onResponse(Call<List<ImageURLInfoBean>> call, Response<List<ImageURLInfoBean>> response) {

                Log.d(TAG, "Image Res : " + response.body().toString());
                imageURLInfoBeans = (ArrayList<ImageURLInfoBean>) response.body();

                mPagerAdapter = new StatePagerAdapter(getChildFragmentManager(), imageURLInfoBeans);
                mViewPager.setAdapter(mPagerAdapter);

            }

            @Override
            public void onFailure(Call<List<ImageURLInfoBean>> call, Throwable t) {
                Log.e(TAG, "Failed : " + t.getLocalizedMessage());
            }
        });
    }
}
