package com.example.themes.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themes.Constants.Data;
import com.example.themes.Models.WallpaperTheme;
import com.example.themes.R;
import com.example.themes.ui.main.adapters.WallpaperThemeAdapter;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.rvSubject)
    RecyclerView rvSubject;

    ArrayList<WallpaperTheme>themes;

    @Inject
    WallpaperThemeAdapter adapter;

    @Inject
    @Named("Vertical")
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        themes = Data.prepareData();
        Log.d(TAG, "onCreate: "+themes.get(0).wallpapers.get(0).WallpaperName);

        rvSubject.setLayoutManager(linearLayoutManager);
        rvSubject.setAdapter(adapter);

        adapter.setData(themes,this);

    }

}
