package com.rock.andrew.fit.activities;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;
import com.rock.andrew.fit.R;
import com.rock.andrew.fit.fragments.Main_Task;

public class GetStartedActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    ImageButton tool_button_shownotification, tool_button_showmore;
    TextView tool_txt_notificationcount;
    TabLayout tab_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        settingupToolbar();
        initTabBar();
    }
    private void settingupToolbar(){
        tool_button_showmore = (ImageButton)findViewById(R.id. button_main_showmore);
        tool_button_shownotification = (ImageButton)findViewById(R.id.button_main_shownotification);
        tool_txt_notificationcount = (TextView)findViewById(R.id.txt_main_notification_count);
        tool_txt_notificationcount.setText("1");
    }
    private void initTabBar(){
        tab_layout = (TabLayout)findViewById(R.id.tablayout_main_start);
        TabLayout.Tab task_tab = tab_layout.newTab();
        task_tab.setIcon(R.drawable.ic_assignment_turned_in_black_24dp);
        task_tab.setText("Tasks");

        TabLayout.Tab feed_tab = tab_layout.newTab();
        feed_tab.setIcon(R.drawable.ic_list_black_24dp);
        feed_tab.setText("Feed");

        TabLayout.Tab profile_tab = tab_layout.newTab();
        profile_tab.setIcon(R.drawable.ic_person_outline_black_24dp);
        profile_tab.setText("Profile");
        //profile_tab.getIcon().setColorFilter(getResources().getColor(R.color.buttonColor), PorterDuff.Mode.SRC_IN);

        tab_layout.addTab(task_tab);
        tab_layout.addTab(feed_tab);
        tab_layout.addTab(profile_tab);
        tab_layout.setOnTabSelectedListener(this);
        tab_layout.setSelected(true);
        tab_layout.getTabAt(1).select();
        tab_layout.getTabAt(0).select();
    }
    private void initTabBarIconColor(){
        for (int i = 0; i < tab_layout.getTabCount(); i++) {
            tab_layout.getTabAt(i).getIcon().setColorFilter(getResources().getColor(R.color.blackColor), PorterDuff.Mode.SRC_IN);
        }
    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        initTabBarIconColor();
        tab.getIcon().setColorFilter(getResources().getColor(R.color.buttonColor), PorterDuff.Mode.SRC_IN);
        setFragmentIndex(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    private void setFragmentIndex(int position){
        if(position == 0){
            Fragment Task_fragment = Main_Task.newInstance();
            LoadFragment(Task_fragment);
        }
    }
    private void LoadFragment(Fragment frag) {
        while (getSupportFragmentManager().getBackStackEntryCount() > 0)
        {
            getSupportFragmentManager().popBackStackImmediate();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container_getstarted, frag)
                .commit();
    }
}
