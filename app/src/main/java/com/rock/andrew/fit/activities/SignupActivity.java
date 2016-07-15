package com.rock.andrew.fit.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.fragments.Login_ResetPassword_step2;
import com.rock.andrew.fit.fragments.Signup_Step_first;

public class SignupActivity extends AppCompatActivity {
    Button m_tool_back,m_tool_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupToolbar();
        FragmentSetupBasedOnStep(0);
    }

    public void FragmentSetupBasedOnStep(int current_step) {
        if(current_step == 0)
        {
            Fragment frag = Signup_Step_first.newInstance();
            LoadFragment(frag);
        }
    }

    private void LoadFragment(Fragment frag) {
        while (getSupportFragmentManager().getBackStackEntryCount() > 0)
        {
            getSupportFragmentManager().popBackStackImmediate();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.signup_container, frag)
                .commit();
    }

    private void setupToolbar() {
        Toolbar m_toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(m_toolbar);
        m_tool_back = (Button)findViewById(R.id.toolbar_back);
        m_tool_next = (Button)findViewById(R.id.toolbar_next);
        m_tool_next.setVisibility(View.GONE);
        m_tool_back.setText("sign up");
        m_tool_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoFirstDisplay();
            }
        });
    }
    private void gotoFirstDisplay()
    {
        Intent i = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
    @Override
    public void onBackPressed() {
        gotoFirstDisplay();
    }

}
