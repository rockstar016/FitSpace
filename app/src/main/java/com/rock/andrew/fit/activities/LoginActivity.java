package com.rock.andrew.fit.activities;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.adapters.Login_firstScreen_Adapter;

import me.relex.circleindicator.CircleIndicator;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    FragmentPagerAdapter adapterViewPager;
    CircleIndicator m_indicator;
    Button m_bt_login, m_bt_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ViewPager vpPager = (ViewPager) findViewById(R.id.main_image);
        adapterViewPager = new Login_firstScreen_Adapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        m_indicator = (CircleIndicator)findViewById(R.id.login_indicator);
        m_indicator.setViewPager(vpPager);
        adapterViewPager.registerDataSetObserver(m_indicator.getDataSetObserver());
        m_bt_login = (Button)findViewById(R.id.login_bt_login);
        m_bt_signup = (Button)findViewById(R.id.login_bt_signup);
        m_bt_signup.setOnClickListener(this);
        m_bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.login_bt_login)
        {
            Intent i = new Intent(LoginActivity.this, LoginStepActivity.class);
            startActivity(i);
            finish();
        }
        else if(id == R.id.login_bt_signup)
        {
            Intent i = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(i);
            finish();
        }
    }
}
