package com.rock.andrew.fit.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.activities.SignupActivity;
import com.rock.andrew.fit.dialogs.SecuritySentDialog;
import com.rock.andrew.fit.models.CommonFragemtModels;
import com.rock.andrew.fit.models.SignUserModel;

public class Signup_Step_change_email extends Fragment {
    EditText txt_email_address;
    Button button_next;
    TextView txt_email_header;
    public Signup_Step_change_email() {
        // Required empty public constructor
    }
    public static Signup_Step_change_email newInstance() {
        Signup_Step_change_email fragment = new Signup_Step_change_email();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_signup_change_email,container,false);
        txt_email_address = (EditText)rootview.findViewById(R.id.txt_signup_changemail_address);
        txt_email_address.setText(SignUserModel.UserEmail);
        txt_email_header = (TextView)rootview.findViewById(R.id.txt_signup_changemail_header);
        txt_email_header.setText("Hi, " + SignUserModel.UserName);

        button_next = (Button)rootview.findViewById(R.id.bt_signup_changemal_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickNextButton();
            }
        });
        return rootview;
    }
    private void onClickNextButton(){
        if(txt_email_address.getText().toString().isEmpty())
        {
            Toast.makeText(getActivity(), "Input your new Email Address", Toast.LENGTH_SHORT).show();
        }
        else{
            final SecuritySentDialog m_dialog = new SecuritySentDialog(getContext());
            View.OnClickListener    m_listener = new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    m_dialog.dismiss();
                    onRemoveDialog();
                }
            };
            m_dialog.setButtonClickListener(m_listener);
            m_dialog.show();
        }
    }
    private void onRemoveDialog(){
        gotoOtherFragment(CommonFragemtModels.SIGNUP_FRAGMENT_VERIFY2);
    }
    private void gotoOtherFragment(int position){
        ((SignupActivity)getActivity()).FragmentSetupBasedOnStep(position);
    }
}
