package michaeltm98.com.motivationalquotesapp.data;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.io.FileReader;
import java.util.List;

public class QuoteViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public QuoteViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);

    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
