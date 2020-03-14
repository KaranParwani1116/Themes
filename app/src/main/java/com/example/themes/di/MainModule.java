package com.example.themes.di;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themes.ui.main.MainActivity;
import com.example.themes.ui.main.adapters.WallpaperThemeAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    static WallpaperThemeAdapter getWallpaperThemeAdapterInstance(@Named("Horizontal")LinearLayoutManager linearLayoutManager){
        return new WallpaperThemeAdapter(linearLayoutManager);
    }

    @Provides
    @Named("Vertical")
    static LinearLayoutManager getLayoutManagerInstance(MainActivity activity){
        return new LinearLayoutManager(activity);
    }

    @Provides
    @Named("Horizontal")
    static LinearLayoutManager getHorizontalLayoutManagerInstance(MainActivity activity){
        return new LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false);
    }


}
