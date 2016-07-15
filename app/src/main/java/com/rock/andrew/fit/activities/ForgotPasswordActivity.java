package com.rock.andrew.fit.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.fragments.Login_ResetPassword_step1;
import com.rock.andrew.fit.fragments.Login_ResetPassword_step2;
import com.rock.andrew.fit.fragments.Login_ResetPassword_step3;

public class ForgotPasswordActivity extends AppCompatActivity {
    Button m_tool_back,m_tool_next;
    int current_step;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        current_step = 0;
        setupToolbar();
    }
    private void setupToolbar() {
        Toolbar m_toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(m_toolbar);
        m_tool_back = (Button) findViewById(R.id.toolbar_back);
        m_tool_next = (Button) findViewById(R.id.toolbar_next);
        setToolbarTitle();
        setToolbarAction();
        m_tool_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_step-=1;
                setToolbarTitle();
                setToolbarAction();
            }
        });
        m_tool_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_step+=1;
                setToolbarTitle();
                setToolbarAction();
            }
        });
    }
    private void setToolbarTitle(){
        if(current_step == 0)
        {
            m_tool_back.setText("forgot password");
            m_tool_next.setText("next");
        }
        else if(current_step == 1)
        {
            m_tool_back.setText("enter token");
            m_tool_next.setText("next");
        }
        else if(current_step == 2)
        {
            m_tool_back.setText("reset password");
            m_tool_next.setText("done");
        }
    }
    private void setToolbarAction()
    {
        if(current_step == 0)
        {
            Fragment frag = Login_ResetPassword_step1.newInstance();
            LoadFragment(frag);
        }
        else if(current_step == 1)
        {
            Fragment frag = Login_ResetPassword_step2.newInstance();
            LoadFragment(frag);
        }
        else if(current_step == 2)
        {
            Fragment frag = Login_ResetPassword_step3.newInstance();
            LoadFragment(frag);
        }
        else if(current_step == -1)
        {
            Intent i = new Intent(ForgotPasswordActivity.this, LoginStepActivity.class);
            startActivity(i);
            finish();
        }
        else if(current_step == 3)
        {
            Intent i = new Intent(ForgotPasswordActivity.this, LoginStepActivity.class);
            startActivity(i);
            finish();
        }
    }
    private void LoadFragment(Fragment frag){
        while (getSupportFragmentManager().getBackStackEntryCount() > 0)
        {
            getSupportFragmentManager().popBackStackImmediate();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_area, frag)
                .commit();
    }
}
