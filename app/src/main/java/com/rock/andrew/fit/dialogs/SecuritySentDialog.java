package com.rock.andrew.fit.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.models.SignUserModel;

import java.util.List;

/**
 * Created by RockStar-0116 on 2016.07.19.
 */
public class SecuritySentDialog extends Dialog {
    Context _this;
    Button m_bt_yes;
    TextView m_txt_content;
    View.OnClickListener m_listener;
    public SecuritySentDialog(Context context){
        super(context);
        _this = context;
    }
    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.alert_securitycode_sent);
        m_bt_yes = (Button)findViewById(R.id.button_alert_ok);
        m_txt_content = (TextView)findViewById(R.id.txt_alert_email);
        m_txt_content.setText(SignUserModel.UserEmail);
        m_bt_yes.setOnClickListener(m_listener);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
    public void setButtonClickListener(View.OnClickListener m_listener){
        this.m_listener = m_listener;
    }

}
