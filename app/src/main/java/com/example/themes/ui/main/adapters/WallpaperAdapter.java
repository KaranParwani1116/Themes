package com.example.themes.ui.main.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.themes.Models.Wallpaper;
import com.example.themes.R;
import com.example.themes.ui.home.HomeActivity;

import java.util.ArrayList;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.CustomViewHolder>{
    private static final String TAG = "WallpaperAdapter";
    private Context context;
    private ArrayList<Wallpaper> wallpapers;
    private LayoutInflater inflater;

    public WallpaperAdapter(Context context, ArrayList<Wallpaper> wallpapers) {
        this.context = context;
        this.wallpapers = wallpapers;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.single_wallpaper, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Wallpaper wallpaper = wallpapers.get(position);
        holder.tvChapterName.setText(wallpaper.WallpaperName);
        holder.ivChapter.setImageResource(wallpaper.WallpaperImage);
        Log.d(TAG, "onBindViewHolder: "+ wallpaper.WallpaperName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pair[] pair = new Pair[2];
                pair[0] = new Pair<View,String>(holder.ivChapter,"wallpaper_shared");
                pair[1] = new Pair<View,String>(holder.tvChapterName,"name_shared");

                ActivityOptions options = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,pair);
                }

                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra("WallpaperImage",wallpaper.WallpaperImage);
                intent.putExtra("WallpaperName",wallpaper.WallpaperName);
                context.startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallpapers.size();
    }


    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivChapter;
        public TextView tvChapterName;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvChapterName = (TextView) itemView.findViewById(R.id.tvChapterName);
            ivChapter = (ImageView) itemView.findViewById(R.id.ivChapter);
        }
    }
}
