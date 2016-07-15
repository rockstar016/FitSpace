package com.rock.andrew.fit.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rock.andrew.fit.R;
public class Login_ResetPassword_step2 extends Fragment {
    public Login_ResetPassword_step2() {
        // Required empty public constructor
    }
    public static Login_ResetPassword_step2 newInstance() {
        Login_ResetPassword_step2 fragment = new Login_ResetPassword_step2();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login__reset_password_step2, container, false);
    }
}
