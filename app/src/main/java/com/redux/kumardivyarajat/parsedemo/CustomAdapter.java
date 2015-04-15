package com.redux.kumardivyarajat.parsedemo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kumardivyarajat on 15/04/15.
 */
public class CustomAdapter extends BaseAdapter{

    private Activity activity;
    private LayoutInflater inflater = null;
    private List<Students> student;
    int layout;

    public CustomAdapter(Activity activity, List<Students> student) {
        //super(activity, R.layout.list_item_layout, student);

        this.activity = activity;

        this.student = student;

    }


    @Override
    public int getCount() {
        return student.size();
    }

    @Override
    public Object getItem(int position) {
        return student.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
       View v =view;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater li = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(android.R.layout.simple_list_item_2,null);
            holder = new ViewHolder();
            holder.name = (TextView)view.findViewById(R.id.name);
            holder.usn = (TextView)view.findViewById(R.id.usn);
            holder.semester = (TextView)view.findViewById(R.id.semester);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        Students s = student.get(position);
        holder.name.setText(s.getName());
        holder.usn.setText(s.getUSN());
        holder.semester.setText(s.getSemester());




        Log.d("CustomAdapter.class", "CustomAdapter");

       // imageView.setImageDrawable(s.getPic());



        return v;
    }
    public static class ViewHolder {
        ImageView imageView ;
        TextView name  ;
        TextView usn ;

        TextView semester  ;
    }

}

