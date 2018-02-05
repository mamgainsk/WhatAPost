package whatanews.org.com.whatapost.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import whatanews.org.com.whatapost.Utils.ImageLoaderUtil;
import whatanews.org.com.whatapost.Networking.ImageURLInfoBean;
import whatanews.org.com.whatapost.R;

/**
 * Created by mobileprogramming on 05/02/18.
 */

public class BaseFragment extends Fragment {

    @BindView(R.id.display_news_image)
    AppCompatImageView newsImageView;

    ImageURLInfoBean imageURLInfoBean;
    private String TAG = "PagerFragment";
    private String title;

    public BaseFragment() {
    }

    public static Fragment getInstance(String url) {
        android.support.v4.app.Fragment fragment = new BaseFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photo_layout, container, false);
        ButterKnife.bind(this, view);
        ImageLoaderUtil.downloadImage(imageURLInfoBean.getThumbnailUrl(), newsImageView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public ImageURLInfoBean getImageURLInfoBean() {

        return imageURLInfoBean;
    }


    public ImageURLInfoBean setInfoBeanItem(ImageURLInfoBean imageURLInfoBean) {
        this.imageURLInfoBean = imageURLInfoBean;
        Log.i(TAG, "setInfoBeanItem:Title:" + imageURLInfoBean.getTitle());
        return imageURLInfoBean;
    }
}
