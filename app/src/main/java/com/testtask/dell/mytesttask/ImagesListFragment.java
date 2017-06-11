package com.testtask.dell.mytesttask;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by DELL on 6/11/2017.
 */

public class ImagesListFragment extends Fragment {
    RecyclerView videosRecyclerView;
    RecyclerView.Adapter videosAdapter;
    RecyclerView.LayoutManager videosLayoutManager;
    Context context;
    ArrayList<String> Title=new ArrayList<>();
    ArrayList<String > Time=new ArrayList<>();
    ArrayList<String> Descrpt=new ArrayList<>();
    ArrayList<Integer> images=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        images.add(R.drawable.video1);
        images.add(R.drawable.video3);
        images.add(R.drawable.video3);
        Title.add("EMPTINESS FT. JUSTIN TIBLEKER");
        Title.add("I'M FALLING LOVE WITH YOU");
        Title.add("BABY FT. JUSTIN BABER");
        Descrpt.add("Lorem Ipsum is simply dummy text of the printing and typing industry");
        Descrpt.add("Lorem Ipsum is simply dummy text of the printing and typing industry");
        Descrpt.add("Lorem Ipsum is simply dummy text of the printing and typing industry");
        Time.add("18 HOURS AGO");
        Time.add("20 HOURS AGO");
        Time.add("22 HOURS AGO");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_videos, container, false);
        videosRecyclerView=((RecyclerView)view.findViewById(R.id.videosRecyclerView));
        videosLayoutManager = new LinearLayoutManager(getActivity());
        videosRecyclerView.setLayoutManager(videosLayoutManager);
        videosAdapter = new VideosAdapter(getContext(),images,Title,Time,Descrpt);
        videosRecyclerView.setAdapter(videosAdapter);
        return view;

    }
      /*  videosRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener()
        {
            GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e){

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(child);
                    Log.i("pos", String.valueOf(position));

                }

                return false;
            }


            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e){

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept){

            }
        });*/

}

