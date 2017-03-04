package uu.bwei.com.fragmentlianxi;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uu.bwei.com.fragmentlianxi.Fragment.OneFragment;
import uu.bwei.com.fragmentlianxi.Fragment.TweFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private List<Fragment> fragmentList=new ArrayList<>();
    private List<TextView> textList=new ArrayList<>();
    private OneFragment oneFragment;
    private TweFragment tweFragment;
    private ViewPager vp;
    private TextView one;
    private TextView twe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //得到控件
        vp = (ViewPager) findViewById(R.id.vp);
        one = (TextView) findViewById(R.id.one);
        twe = (TextView) findViewById(R.id.twe);

        oneFragment = new OneFragment();
        tweFragment = new TweFragment();
        fragmentList.add(oneFragment);
        fragmentList.add(tweFragment);

        textList.add(one);
        textList.add(twe);

        one.setOnClickListener(this);
        twe.setOnClickListener(this);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<fragmentList.size();i++)
                {
                  if(i==position)
                  {
                      textList.get(i).setTextColor(Color.RED);
                  }
                  else
                  {
                      textList.get(i).setTextColor(Color.BLACK);
                  }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case  R.id.one :
                vp.setCurrentItem(0);
              /*  FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction replace = manager.beginTransaction().replace(R.id.vp, new OneFragment());
                replace.commit();*/
                break;
            case  R.id.twe :
                vp.setCurrentItem(1);
              /*  FragmentManager manager1 = getSupportFragmentManager();
                FragmentTransaction replace1 = manager1.beginTransaction().replace(R.id.vp, new TweFragment());
                replace1.commit();*/
                break;
        }
    }
}
