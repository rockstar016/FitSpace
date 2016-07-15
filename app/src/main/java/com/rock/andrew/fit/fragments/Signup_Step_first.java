package com.rock.andrew.fit.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rock.andrew.fit.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Signup_Step_first#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Signup_Step_first extends Fragment {

    public Signup_Step_first() {
        // Required empty public constructor
    }

    public static Signup_Step_first newInstance() {
        Signup_Step_first fragment = new Signup_Step_first();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup__step_first, container, false);
    }

}
