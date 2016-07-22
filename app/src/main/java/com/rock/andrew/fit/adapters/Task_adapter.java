package com.rock.andrew.fit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rock.andrew.fit.R;
import com.rock.andrew.fit.models.base_tasks;
import com.rock.andrew.fit.models.tasks_content;
import com.rock.andrew.fit.models.tasks_headercontent;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by RockStar-0116 on 2016.07.20.
 */
public class Task_adapter extends BaseAdapter {
    ArrayList<base_tasks> m_arraylist;
    LayoutInflater mInflater;
    public Task_adapter(Context context, ArrayList e){
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        m_arraylist = e;
    }
    @Override
    public int getCount() {
        return m_arraylist.size();
    }
    @Override
    public Object getItem(int i) {
        return m_arraylist.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(m_arraylist.get(i).getType() == 0) {
            view = mInflater.inflate(R.layout.listitem_maintasks_header_video,null);
            ImageView imageheader = (ImageView)view.findViewById(R.id.image_header);
            TextView txtContent = (TextView)view.findViewById(R.id.title_header_content);
            tasks_headercontent m_tmpcontent = ((tasks_headercontent)(getItem(i)));
            txtContent.setText(m_tmpcontent.getTitleTask());
        }
        else
        {
            view = mInflater.inflate(R.layout.listitem_maintasks_content,null);
            ImageView imageheader = (ImageView)view.findViewById(R.id.image_header);
            TextView txtContent = (TextView)view.findViewById(R.id.txt_taks_content);
            TextView txtUnitLeft = (TextView)view.findViewById(R.id.txt_taks_timeamount);
            TextView txtUnit = (TextView)view.findViewById(R.id.txt_taks_dayleft);
            tasks_content m_tmpcontent = ((tasks_content)(getItem(i)));
            if(m_tmpcontent.getUnit_type() == 0){
                txtUnit.setText("days left");
            }
            else{
                txtUnit.setText("hours left");
            }
            txtUnitLeft.setText(m_tmpcontent.getUnit_amount()+"");
            txtContent.setText(m_tmpcontent.getContent());
        }
        return view;
    }
}
