package hn.techcom.com.hnapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                AllPostsFragment allPostsFragment = new AllPostsFragment();
                return allPostsFragment;
            case 1:
                TrendingPostsFragment trendingPostsFragment = new TrendingPostsFragment();
                return trendingPostsFragment;
            case 2:
                FeaturedPostsFragment featuredPostsFragment = new FeaturedPostsFragment();
                return featuredPostsFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "All Posts";
            case 1:
                return "Trending Posts";
            case 2:
                return "Featured Posts";
            default:
                return null;
        }

    }
}
