package whatanews.org.com.whatapost.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import whatanews.org.com.whatapost.Fragments.BaseFragment;
import whatanews.org.com.whatapost.Networking.ImageURLInfoBean;

/**
 * Created by mobileprogramming on 05/02/18.
 */

public class StatePagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "FragmentStatPgrAdapter";
    private ArrayList<ImageURLInfoBean> mImageItemList;
    private FragmentManager mFragmentManager;

    public StatePagerAdapter(FragmentManager fm, ArrayList<ImageURLInfoBean> imageItemList) {
        super(fm);
        this.mImageItemList = imageItemList;
        this.mFragmentManager = fm;
    }

    public float GetPageWidth(int position) {
        return 0.93f;
    }

    @Override
    public int getCount() {
        return mImageItemList.size();
    }

    @Override
    public Fragment getItem(int position) {

        List<Fragment> fragmentsList = mFragmentManager.getFragments();
        int size = 0;
        if (fragmentsList != null) {
            size = fragmentsList.size();
        }
        ImageURLInfoBean bean = mImageItemList.get(position);
        Log.i(TAG, "********getItem position:" + position + " size:" + size + " title:" + bean.getTitle() + " url:" + bean.getThumbnailUrl());

        BaseFragment sampleFragment = (BaseFragment) BaseFragment.getInstance(bean.getThumbnailUrl());
        sampleFragment.setInfoBeanItem(bean);
        return sampleFragment;
    }

    @Override
    public int getItemPosition(Object object) {
        List<Fragment> fragmentsList = mFragmentManager.getFragments();
        BaseFragment fragment = (BaseFragment) object;
        ImageURLInfoBean dummyItem = fragment.getImageURLInfoBean();
        int position = mImageItemList.indexOf(dummyItem);


        if (position >= 0) {
            return position;
        } else {
            return POSITION_NONE;
        }
    }
}
