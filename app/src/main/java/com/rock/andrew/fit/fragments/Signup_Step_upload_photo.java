package com.rock.andrew.fit.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.activities.LoginActivity;
import com.rock.andrew.fit.models.SignUserModel;

import org.w3c.dom.Text;

import java.io.File;

public class Signup_Step_upload_photo extends Fragment implements View.OnClickListener{
    LinearLayout layout_done, layout_skip;
    FloatingActionButton circle_plus_photo;
    Button button_skip,button_photo_change, button_photo_done;
    TextView lbl_upload_picture;
    ImageView m_image_photo;
    public Signup_Step_upload_photo() {
        // Required empty public constructor
    }
    public static Signup_Step_upload_photo newInstance() {
        Signup_Step_upload_photo fragment = new Signup_Step_upload_photo();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_signup_uploadpicture,container,false);
        layout_done = (LinearLayout)rootview.findViewById(R.id.layout_uploadphoto_done);
        layout_skip = (LinearLayout)rootview.findViewById(R.id.layout_uploadphoto_skip);
        circle_plus_photo = (FloatingActionButton)rootview.findViewById(R.id.circle_uploadphoto_add);
        circle_plus_photo.setOnClickListener(this);
        button_skip = (Button)rootview.findViewById(R.id.button_uploadphoto_skip);
        button_photo_change = (Button)rootview.findViewById(R.id.button_uploadphoto_changephoto);
        button_photo_done = (Button)rootview.findViewById(R.id.button_uploadphoto_done);
        button_skip.setOnClickListener(this);
        button_photo_change.setOnClickListener(this);
        button_photo_done.setOnClickListener(this);
        lbl_upload_picture = (TextView)rootview.findViewById(R.id.txt_upload_headertext);
        lbl_upload_picture.setText("Hi, "+ SignUserModel.UserName);
        showSkipLayout();
        return rootview;
    }
    private void showSkipLayout(){
        layout_done.setVisibility(View.GONE);
        layout_skip.setVisibility(View.VISIBLE);
    }
    private void showDoneLayout(){
        layout_done.setVisibility(View.VISIBLE);
        layout_skip.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        int view_id = view.getId();
        if(view_id == R.id.circle_uploadphoto_add){
            Intent i = new Intent( Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, 150);
        }
        else if(view_id == R.id.button_uploadphoto_changephoto){
            showSkipLayout();
        }
        else if(view_id == R.id.button_uploadphoto_done){
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
            getActivity().finish();
        }
        else if(view_id == R.id.button_uploadphoto_skip){
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
            getActivity().finish();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 150&& resultCode == Activity.RESULT_OK) {
            String path = getPathFromCameraData(data, this.getActivity());
            if (path != null) {
                setFullImageFromFilePath(path);
                showDoneLayout();
            }
        }
        else{
            showDoneLayout();
        }
    }
    public static String getPathFromCameraData(Intent data, Context context) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }
    public void setFullImageFromFilePath(String path){
        File face_photo = new File(path);
        Bitmap myBitmap = BitmapFactory.decodeFile(face_photo.getAbsolutePath());
        m_image_photo.setImageBitmap(myBitmap);
    }
}
