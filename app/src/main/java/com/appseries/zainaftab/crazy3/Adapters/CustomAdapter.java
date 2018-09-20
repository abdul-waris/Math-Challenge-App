package com.appseries.zainaftab.crazy3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.appseries.zainaftab.crazy3.Models.DataModel;
import com.appseries.zainaftab.crazy3.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    private ArrayList<DataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtScore;
        TextView txtDate;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.list_item_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }
//
//
//    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

//        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.list_item_layout, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtScore = (TextView) convertView.findViewById(R.id.score);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.date);
//            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtScore.setText(dataModel.getscore());
        viewHolder.txtDate.setText(dataModel.getDate());
        return convertView;
    }
}