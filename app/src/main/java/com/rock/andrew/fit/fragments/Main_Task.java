package com.rock.andrew.fit.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.rock.andrew.fit.R;
import com.rock.andrew.fit.activities.GetStartedContentActivity;
import com.rock.andrew.fit.adapters.Task_adapter;
import com.rock.andrew.fit.models.base_tasks;
import com.rock.andrew.fit.models.tasks_content;
import com.rock.andrew.fit.models.tasks_headercontent;

import java.util.ArrayList;

public class Main_Task extends Fragment {
    TextView current_Progress_value;
    RoundCornerProgressBar current_progressbar;
    ImageButton button_get_start;
    ListView list_tasks;
    ArrayList<base_tasks> arraylist_tasks;
    public Main_Task() {
    }
    public static Main_Task newInstance()
    {
        Main_Task fragment = new Main_Task();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main_tasks,container,false);
        current_Progress_value = (TextView)rootview.findViewById(R.id.txt_tasks_getstart);
        current_progressbar = (RoundCornerProgressBar)rootview.findViewById(R.id.pb_current_prog);
        current_progressbar.setMax(100);
        button_get_start = (ImageButton)rootview.findViewById(R.id.button_goto_getstart);
        button_get_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goto_getstartActivity();
            }
        });
        setCurrentProgressValue(20);
        list_tasks = (ListView)rootview.findViewById(R.id.tasks_list_view);
        arraylist_tasks = new ArrayList<>();
        initArrayList();
        return rootview;
    }
    private void goto_getstartActivity(){
        Intent i = new Intent(getActivity(), GetStartedContentActivity.class);
        startActivity(i);
        getActivity().finish();
    }
    private void initArrayList(){
        tasks_headercontent tasksheader = new tasks_headercontent();
        tasksheader.setImagePath("");
        tasksheader.setTitleTask("you are invited");

        tasks_content taskscontent = new tasks_content();
        taskscontent.setContent("Hello everybody, This is sample data");
        taskscontent.setUnit_amount(2);
        taskscontent.setUnit_type(0);
        arraylist_tasks.add(tasksheader);
        arraylist_tasks.add(taskscontent);
        arraylist_tasks.add(taskscontent);
        arraylist_tasks.add(taskscontent);

        arraylist_tasks.add(tasksheader);
        arraylist_tasks.add(taskscontent);
        arraylist_tasks.add(taskscontent);
        arraylist_tasks.add(taskscontent);

        arraylist_tasks.add(tasksheader);
        arraylist_tasks.add(taskscontent);
        arraylist_tasks.add(taskscontent);
        arraylist_tasks.add(taskscontent);
        Task_adapter adapter = new Task_adapter(getActivity(),arraylist_tasks);
        list_tasks.setAdapter(adapter);

    }
    public void setCurrentProgressValue(int value){
        current_Progress_value.setText(value + "%");
        current_progressbar.setProgress(value);
    }
}
