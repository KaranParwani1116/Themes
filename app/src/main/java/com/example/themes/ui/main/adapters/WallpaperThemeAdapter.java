package com.example.themes.ui.main.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themes.Models.WallpaperTheme;
import com.example.themes.R;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WallpaperThemeAdapter extends RecyclerView.Adapter<WallpaperThemeAdapter.ViewHolder> {
    public ArrayList<WallpaperTheme> themes = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private LinearLayoutManager linearLayoutManager;

    @Inject
    public WallpaperThemeAdapter(LinearLayoutManager linearLayoutManager) {
      this.linearLayoutManager = linearLayoutManager;
    }

    public void setData(ArrayList<WallpaperTheme> WallpaperThemes, Context context) {
        this.themes.addAll(WallpaperThemes);
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_wallpaper_theme, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.rvChapters.setAdapter(new WallpaperAdapter(context, themes.get(position).wallpapers));
        holder.rvChapters.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        holder.rvChapters.setHasFixedSize(true);
        holder.tvSubjectName.setText(themes.get(position).Title);
    }

    @Override
    public int getItemCount() {
        return themes.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvSubjectName)
        TextView tvSubjectName;
        @BindView(R.id.rvChapters)
        RecyclerView rvChapters;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
