package com.rock.andrew.fit.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.activities.SignupActivity;
import com.rock.andrew.fit.models.SignUserModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Signup_Step_first#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Signup_Step_first extends Fragment{
    View rootview;
    EditText txt_user_name, txt_user_email, txt_user_password;
    Button button_next;
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
        rootview = inflater.inflate(R.layout.fragment_signup__step_first, container, false);
        txt_user_email = (EditText)rootview.findViewById(R.id.txt_signup_email);
        txt_user_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkAllEditText();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txt_user_name = (EditText)rootview.findViewById(R.id.txt_signup_firstname);
        txt_user_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkAllEditText();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txt_user_password = (EditText)rootview.findViewById(R.id.txt_signup_lock);
        txt_user_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkAllEditText();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        button_next = (Button)rootview.findViewById(R.id.signup_bt_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUserModel.UserEmail = txt_user_email.getText().toString().trim();
                SignUserModel.UserName = txt_user_name.getText().toString().trim();

                ((SignupActivity)getActivity()).FragmentSetupBasedOnStep(1);
            }
        });
        checkAllEditText();
        return rootview;
    }
    private void checkAllEditText(){
        if(validAllValue() == false){
            button_next.setEnabled(false);
            button_next.setClickable(false);
            button_next.setTextColor(getResources().getColor(R.color.disableColor));
        }
        else {
            button_next.setEnabled(true);
            button_next.setClickable(true);
            button_next.setTextColor(getResources().getColor(R.color.textColor));
        }
    }
    private boolean validAllValue(){
        boolean m_result = (!txt_user_password.getText().toString().isEmpty() && !txt_user_email.getText().toString().isEmpty() && !txt_user_name.getText().toString().isEmpty());
        return m_result;
    }
}
