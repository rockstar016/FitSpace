package com.rock.andrew.fit.activities;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rock.andrew.fit.R;

public class LoginStepActivity extends AppCompatActivity implements View.OnClickListener{
    Button m_tool_back,m_tool_next;
    Button m_bt_Next, m_bt_Signup, m_bt_ForgotPwd;
    EditText m_txt_email, m_txt_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_step);
        setupToolbar();
        m_bt_Next = (Button)findViewById(R.id.login_bt_next);
        m_bt_Signup = (Button)findViewById(R.id.login_bt_signup);
        m_bt_ForgotPwd = (Button)findViewById(R.id.login_bt_forgotpwd);
        m_txt_email = (EditText)findViewById(R.id.login_txt_email);
        m_txt_pwd = (EditText)findViewById(R.id.login_txt_pwd);
        m_bt_ForgotPwd.setOnClickListener(this);
        m_bt_Signup.setOnClickListener(this);
        m_bt_Next.setOnClickListener(this);
    }
    private void setupToolbar() {
        Toolbar m_toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(m_toolbar);
        m_tool_back = (Button)findViewById(R.id.toolbar_back);
        m_tool_next = (Button)findViewById(R.id.toolbar_next);
        m_tool_next.setVisibility(View.GONE);
        m_tool_back.setText("login");
        m_tool_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoFirstDisplay();
            }
        });

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            getWindow().setStatusBarColor(getResources().getColor(R.color.textColor));
//        }
    }
    private void gotoFirstDisplay()
    {
        Intent i = new Intent(LoginStepActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        gotoFirstDisplay();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id)
        {
            case R.id.login_bt_forgotpwd:
                gotoForgotPwdActivity();
                break;
            case R.id.login_bt_next:
                gotoMainActivity();
                break;
            case R.id.login_bt_signup:
                gotoSignUpActivity();
                break;

        }
    }
    private void gotoForgotPwdActivity(){
        Intent i = new Intent(LoginStepActivity.this,ForgotPasswordActivity.class);
        startActivity(i);
        finish();
    }
    private void gotoMainActivity(){
        if(m_txt_pwd.getText().length() != 0 && m_txt_email.getText().length() != 0){
            Intent i = new Intent(LoginStepActivity.this, GetStartedActivity.class);
            startActivity(i);
            finish();

        }
        else
        {
            Toast.makeText(LoginStepActivity.this, "Fill out all textfields", Toast.LENGTH_SHORT).show();
        }
    }
    private void gotoSignUpActivity(){
        Intent i = new Intent(LoginStepActivity.this, SignupActivity.class);
        startActivity(i);
        finish();
    }
}
