package com.ebookfrenzy.tablayoutdemo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.PagerAdapter;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;
import java.net.URI;

public class MainActivity extends AppCompatActivity implements
    Tab1Fragment.OnFragmentInteractionListener,
    Tab2Fragment.OnFragmentInteractionListener,
    Tab3Fragment.OnFragmentInteractionListener,
    Tab4Fragment.OnFragmentInteractionListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = findViewById(R.id.fab);

    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });
    configureTabLayout();
  }

  private void configureTabLayout() {
    TabLayout tabLayout = findViewById(R.id.tab_layout);

    tabLayout.addTab(tabLayout.newTab().setText("Tab 1 Item"));
    tabLayout.addTab(tabLayout.newTab().setText("Tab 2 Item"));
    tabLayout.addTab(tabLayout.newTab().setText("Tab 3 Item"));
    tabLayout.addTab(tabLayout.newTab().setText("Tab 4 Item"));

    final ViewPager viewPager = findViewById(R.id.pager);
    final PagerAdapter adapter = new TabPagerAdapter
        (getSupportFragmentManager(),
            tabLayout.getTabCount());

    viewPager.setAdapter(adapter);

    viewPager.addOnPageChangeListener(new
        TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.addOnTabSelectedListener(new
                                           TabLayout.OnTabSelectedListener() {
                                             @Override
                                             public void OnTabSelected(TabLayout.Tab tab) {
                                               viewPager.setCurrentItem(tab.getPosition());
                                             }

                                             @Override
                                             public void onTabUnselected(TabLayout.Tab tab) {
                                             }

                                             @Override
                                             public void onTabReselected(TabLayout.Tab tab) {

                                             }

                                           });
  }

  @Override
  public void onFragmentInteraction(URI uri) {

  }


}
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
