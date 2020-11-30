package matejpersic_dz1.ferit.osnove_rwma_dz3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements  ButtonClickListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private MessageFragment mMessageFragment;
    private Fragment mInputFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpPager();
    }

    private void setUpPager() {
        PagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initViews() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tab);
    }

    @Override
    public void onButtonClicked(String message) {
        mMessageFragment =(MessageFragment) getSupportFragmentManager().findFragmentById(R.id.viewPager);
        mMessageFragment.displayMessage(message);
        //getSupportFragmentManager().beginTransaction().replace(R.id.viewPager,mMessageFragment).commit();
        mViewPager.setCurrentItem(1);
    }

}


