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

    private MessageFragment messageFragment;

    public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position) {
           case 0:
               return new InputFragment();
           case 1:
               if (messageFragment == null) {
                   messageFragment = new MessageFragment();
               }
               return messageFragment;
           case 2:
               return ModularFragment.newInstance("Hello world");
           default:
               return ModularFragment.newInstance("");
       }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  String.format(Locale.getDefault(),BASE_NAME,position+1);
    }

    public MessageFragment getMessageFragment() {
        return messageFragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
