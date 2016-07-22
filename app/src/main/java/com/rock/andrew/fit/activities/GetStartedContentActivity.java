package com.rock.andrew.fit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.rock.andrew.fit.R;

public class GetStartedContentActivity extends AppCompatActivity {
    Button tool_back, tool_next;
    CheckBox chk_confirmEmail,chk_profilephoto,chk_inviteFriend, chk_socialMedia;
    TextView txt_step_social;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initActionBar(toolbar);
        chk_confirmEmail = (CheckBox)findViewById(R.id.chk_getstarted_emailconfirm);
        chk_profilephoto = (CheckBox)findViewById(R.id.chk_getstated_profilephoto);
        chk_inviteFriend = (CheckBox)findViewById(R.id.chk_getstarted_invitefreinds);
        chk_socialMedia = (CheckBox)findViewById(R.id.chk_getstarted_social);
        txt_step_social = (TextView)findViewById(R.id.txt_getstart_socialcount);
        chk_confirmEmail.setChecked(true);
        chk_profilephoto.setChecked(true);
        chk_inviteFriend.setChecked(false);
        chk_socialMedia.setChecked(true);

        chk_confirmEmail.setEnabled(false);
        chk_profilephoto.setEnabled(false);
        chk_inviteFriend.setEnabled(false);
        chk_socialMedia.setEnabled(false);
    }
    private void initActionBar(Toolbar toolbar){
        tool_back = (Button)findViewById(R.id.toolbar_back);
        tool_next = (Button)findViewById(R.id.toolbar_next);
        tool_next.setVisibility(View.GONE);
        tool_back.setText("get started");
        tool_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GetStartedContentActivity.this, GetStartedActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
