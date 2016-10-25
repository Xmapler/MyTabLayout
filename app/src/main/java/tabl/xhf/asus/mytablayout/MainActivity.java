package tabl.xhf.asus.mytablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import tabl.xhf.asus.mytablayout.frag.Fragment1;
import tabl.xhf.asus.mytablayout.frag.Fragment2;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.tablelayout)
    TabLayout tablelayout;
    @BindView(R.id.vp)
    ViewPager vp;
    private String[] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        for (int i = 0; i < str.length; i++) {
            //给tablelayout添加导航条目
            tablelayout.addTab(tablelayout.newTab().setText(str[i]));
        }

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position){
                    case 0:
                        fragment = new Fragment1();
                        break;

                    case 1:
                        fragment = new Fragment2();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return str.length;
            }
        });

        vp.setCurrentItem(0);
        tablelayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablelayout));
    }

    private void initData() {
        str = new String[]{"入驻部门","政务联播"};
    }

}
