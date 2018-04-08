package com.retrofitdemo.retrofitlearnigtopics.adapter;

import android.content.Context;


import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pkmmte.view.CircularImageView;
import com.retrofitdemo.retrofitlearnigtopics.R;
import com.retrofitdemo.retrofitlearnigtopics.model.AppList;
import com.retrofitdemo.retrofitlearnigtopics.utils.CircleTransform;

import java.util.List;

/**
 * Created by KP on 4/8/2018.
 */

public class MyAppListAdapter extends RecyclerView.Adapter<MyAppListAdapter.MyViewHolder> {

    private Context mContext;
    private List<AppList> listApp;
    private LayoutInflater inflater;

    public MyAppListAdapter(Context context, List<AppList> listApp) {
        this.mContext = context;
        this.listApp = listApp;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.app_list_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.appName.setText(listApp.get(position).getAppName());
        Glide.with(this.mContext).load(listApp.get(position).getAppImageUrl()).into(holder.appImage);
        Glide.with(mContext)
                .load(Uri.parse(listApp.get(position).getAppImageUrl())) // add your image url
                .placeholder(R.mipmap.ic_launcher)
                .transform(new CircleTransform(mContext))
                .into(holder.appImage);
    }

    @Override
    public int getItemCount() {
        return listApp.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView appName;
        public CircularImageView appImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            appName = (TextView) itemView.findViewById(R.id.txtAppName);
            appImage = (CircularImageView) itemView.findViewById(R.id.imgAppImage);
        }
    }
}
