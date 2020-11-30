package matejpersic_dz1.ferit.osnove_rwma_dz3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Locale;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES=4;
    private static final String BASE_NAME="#%d";
    private FragmentManager mFragmentManager;

    public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mFragmentManager=fm;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position) {
           case 0:
               return InputFragment.newInstance("");
           case 1:
               return MessageFragment.newInstance("Hello world");
           case 2:
               return ModularFragment.newInstance("2");
           default:
               return ModularFragment.newInstanceImage("3");
       }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  String.format(Locale.getDefault(),BASE_NAME,position+1);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
