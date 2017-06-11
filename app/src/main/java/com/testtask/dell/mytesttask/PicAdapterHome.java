package com.testtask.dell.mytesttask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by DELL on 6/10/2017.
 */

class PicAdapterHome extends PagerAdapter {

    private int mSize;
    private Activity mActivity;
    private float mImageCorner = -1F;
    private int[] ResIds;
    static int[] arrayvid;
    private VideoView videoView;

    public PicAdapterHome(Activity activity,int[] ResIds){
        mActivity = activity;
        this.ResIds=ResIds;

    }

    @Override
    public int getCount(){
        return ResIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object){
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position){
        View view = LayoutInflater.from(mActivity.getApplicationContext()).inflate
                (R.layout.recommend_page_home, container, false);
      /*  videoView = (VideoView)view.findViewById(R.id.video_view);
       // message = (TextView)layout.findViewById(R.id.message);

        MediaController mediaController = new MediaController(mActivity, false);
        mediaController.setAnchorView(videoView);
*/
        final ImageButton play=(ImageButton)view.findViewById(R.id.videoplay);
        videoView = (VideoView) view.findViewById(R.id.videoview);
        videoView.setBackgroundResource(R.drawable.video1);
                //setImageResource(ResIds[position]);
       /* Bitmap image = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        Bitmap newimage = getRoundCornerImage(image,50);
        ImageView imageView2 = new ImageView(view.getContext());
        imageView2.setImageBitmap(newimage);
       */
       container.addView(view);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("clikced","play");
                play(position);

            }
        });

        return view;
    }
    private Uri getPath(int id) {
        Log.i("Video", "num" + id);

        return Uri.parse("android.resource://com.testtask.dell.mytesttask/raw/video_1");
    }

    public void play(int position) {

        videoView.setVideoURI(Uri.parse("android.resource://com.testtask.dell.mytesttask/raw/video_1"));

        MediaController mediaController = new MediaController(mActivity, false);
        mediaController.setAnchorView(videoView);         //getPath(position+1));
        videoView.requestFocus();

        videoView.start();
        Log.i("in play()","playing");

    }
    public void addItem(){
        mSize++;
        notifyDataSetChanged();
    }
    public void removeItem(){
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }
    public Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels)
    {
        Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundConcerImage);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rect, paint);
        return roundConcerImage;
    }
}


