package com.rock.andrew.fit.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rock.andrew.fit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login_ResetPassword_step1 extends Fragment {


    public Login_ResetPassword_step1() {
        // Required empty public constructor
    }

    public static Login_ResetPassword_step1 newInstance() {
        Login_ResetPassword_step1 fragment = new Login_ResetPassword_step1();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login__reset_password_step1, container, false);
    }

}
