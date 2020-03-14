package com.example.themes.ui.home;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

import com.example.themes.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class HomeActivity extends DaggerAppCompatActivity {

    @BindView(R.id.ivWallpaper)
    ImageView ivWallpaper;
    @BindView(R.id.tvWallpaperName)
    TextView tvWallpaperName;
    @BindView(R.id.card_view)
    CardView cardView;
    @BindView(R.id.applywallpaper)
    Button applywallpaper;
    @BindView(R.id.progress_circular)
    ProgressBar progressCircular;

    private int drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        drawable = getIntent().getIntExtra("WallpaperImage", 0);
        String text = getIntent().getStringExtra("WallpaperName");

        getSupportActionBar().setTitle(text);

        ivWallpaper.setImageResource(drawable);
        tvWallpaperName.setText(text);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.applywallpaper)
    public void applyWallpaper() {
        AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner();
        asyncTaskRunner.execute();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }

    private class AsyncTaskRunner extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawable);
            WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
            try {
                manager.setBitmap(bitmap);
            } catch (IOException e) {
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressCircular.setVisibility(View.VISIBLE);
            applywallpaper.setVisibility(View.INVISIBLE);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressCircular.setVisibility(View.GONE);
            Toast.makeText(HomeActivity.this, "Wallpaper set!", Toast.LENGTH_SHORT).show();
            applywallpaper.setEnabled(true);
            finishAfterTransition();
        }
    }
}
