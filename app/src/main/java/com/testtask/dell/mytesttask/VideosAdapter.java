package com.testtask.dell.mytesttask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL on 6/11/2017.
 */

class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {
    Context context1;
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();
    ArrayList<String > descrpt=new ArrayList<>();
    ArrayList<Integer> images=new ArrayList<>();

    public VideosAdapter(Context context,ArrayList<Integer> images, ArrayList<String> title, ArrayList<String> time, ArrayList<String> descrpt) {
        this.descrpt=descrpt;
        this.context1=context;
        this.title=title;
        this.time=time;
        this.images=images;
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView titleTv,timeTv,descpTv;
        ImageView imageVieww;

        public View view;
        public ViewHolder(View v){
            super(v);
            titleTv = (TextView) v.findViewById(R.id.titletv);
            timeTv = (TextView) v.findViewById(R.id.timetv);
            descpTv = (TextView) v.findViewById(R.id.descptv);
            imageVieww=(ImageView)v.findViewById(R.id.imageVieww);


        }
    }

    @Override
    public VideosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context1).inflate(R.layout.videos_frag_adapter,parent,false);
        ViewHolder viewHolder1 = new ViewHolder(view1);
        return viewHolder1;
    }


    @Override
    public void onBindViewHolder(VideosAdapter.ViewHolder Vholder, final int position){
        Log.i("onbind","called "+position);
        Vholder.titleTv.setText((title.get(position)));
        Vholder.timeTv.setText((time.get(position)));
        Vholder.descpTv.setText((descrpt.get(position)));
        Vholder.imageVieww.setImageResource(images.get(position));
        Log.i("image", String.valueOf(images.get(position)));


    }

    @Override
    public int getItemCount() {
        Log.i("getcount", String.valueOf(title.size()));
        return title.size();
    }
}
