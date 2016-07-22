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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.activities.SignupActivity;
import com.rock.andrew.fit.dialogs.SecuritySentDialog;
import com.rock.andrew.fit.models.CommonFragemtModels;
import com.rock.andrew.fit.models.SignUserModel;

public class Signup_Step_verify_step2 extends Fragment implements View.OnClickListener{
    TextView txt_header_view, txt_email_address;
    Button button_resend_message, button_change_email;
    Button button_next;

    EditText txt_signup_code;
    public Signup_Step_verify_step2() {
        // Required empty public constructor
    }
    public static Signup_Step_verify_step2 newInstance() {
        Signup_Step_verify_step2 fragment = new Signup_Step_verify_step2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_signup_verify__step2,container,false);
        txt_header_view = (TextView)rootview.findViewById(R.id.lbl_signup_hi);
        txt_email_address = (TextView)rootview.findViewById(R.id.txt_signup_emailaddress);
        txt_header_view.setText("Hi, " + SignUserModel.UserName);
        txt_email_address.setText("(" + SignUserModel.UserEmail+")");
        button_resend_message = (Button)rootview.findViewById(R.id.button_signup_resendmessage);
        button_change_email = (Button)rootview.findViewById(R.id.button_signup_chanagemail);
        button_next = (Button)rootview.findViewById(R.id.button_signup_code_next);
        button_next.setOnClickListener(this);
        button_resend_message.setOnClickListener(this);
        button_change_email.setOnClickListener(this);
        txt_signup_code = (EditText)rootview.findViewById(R.id.txt_signup_code);
        return rootview;
    }
    private void showDialog(){
        final SecuritySentDialog m_dialog = new SecuritySentDialog(getContext());
        View.OnClickListener    m_listener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                m_dialog.dismiss();
            }
        };
        m_dialog.setButtonClickListener(m_listener);
        m_dialog.show();
    }
    @Override
    public void onClick(View view) {
        int view_id = view.getId();
        if(view_id == R.id.button_signup_resendmessage ){
            showDialog();
        }
        else if(view_id == R.id.button_signup_chanagemail){
             gotoOtherFragment(CommonFragemtModels.SIGNUP_FRAGMENT_EMAIL_CHANGE);
        }
        else if(view_id == R.id.button_signup_code_next){
            if(!txt_signup_code.getText().toString().isEmpty())
                gotoOtherFragment(CommonFragemtModels.SIGNUP_FRAGMENT_UPLOAD_PICTURE);
            else
                Toast.makeText(getActivity(), "Input Code, please", Toast.LENGTH_SHORT).show();
        }
    }
    private void gotoOtherFragment(int position){
        ((SignupActivity)getActivity()).FragmentSetupBasedOnStep(position);
    }
}
