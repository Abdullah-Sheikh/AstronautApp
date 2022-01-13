package pk.nu.edu.astronautapp.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import pk.nu.edu.astronautapp.Fragments.Reserve;
import pk.nu.edu.astronautapp.Fragments.Rocket;
import pk.nu.edu.astronautapp.Fragments.Weather;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new Rocket();
        }
        else if (position == 1)
        {
           fragment = new Weather();
        }
        else if (position == 2)
        {
            fragment = new Reserve();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Rocket";
        }
        else if (position == 1)
        {
            title = "Weather";
        }
        else if (position == 2)
        {
            title = "Reserve";
        }
        return title;
    }
}
