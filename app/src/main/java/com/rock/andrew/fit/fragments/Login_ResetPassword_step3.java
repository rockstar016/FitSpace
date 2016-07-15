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
public class Login_ResetPassword_step3 extends Fragment {


    public Login_ResetPassword_step3() {
        // Required empty public constructor
    }
    public static Login_ResetPassword_step3 newInstance() {
        Login_ResetPassword_step3 fragment = new Login_ResetPassword_step3();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login__reset_password_step3, container, false);
    }

}
