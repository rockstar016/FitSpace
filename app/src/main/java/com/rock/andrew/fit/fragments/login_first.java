package com.rock.andrew.fit.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rock.andrew.fit.R;


public class login_first extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String imagePath;
    private String title;

    public login_first() {
        // Required empty public constructor
    }

    public static login_first newInstance(String param1, String param2) {
        login_first fragment = new login_first();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           imagePath = getArguments().getString(ARG_PARAM1);
            title = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.login_page_template,container,false);
        ImageView back_image = (ImageView)rootview.findViewById(R.id.login_frag_back);
        TextView title_text = (TextView)rootview.findViewById(R.id.login_frag_text);
        title_text.setText(title);
        //Picasso.with(rootview.getContext()).load(imagePath).into(back_image);
        return rootview;
    }
}
