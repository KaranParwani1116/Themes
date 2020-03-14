package com.example.themes.Constants;

import com.example.themes.Models.Wallpaper;
import com.example.themes.Models.WallpaperTheme;
import com.example.themes.R;

import java.util.ArrayList;

public class Data {

    public static ArrayList<WallpaperTheme> prepareData() {
        ArrayList<WallpaperTheme> subjects = new ArrayList<WallpaperTheme>();

        WallpaperTheme physics = new WallpaperTheme();
        physics.id = 1;
        physics.Title = "RainThemes";
        physics.wallpapers = new ArrayList<Wallpaper>();

        Wallpaper chapter1 = new Wallpaper();
        chapter1.id = 1;
        chapter1.WallpaperName = "RainyStorm";
        chapter1.WallpaperImage = R.drawable.rains;

        Wallpaper chapter2 = new Wallpaper();
        chapter2.id = 2;
        chapter2.WallpaperName = "RainyPhone";
        chapter2.WallpaperImage = R.drawable.rainphone;

        Wallpaper chapter3 = new Wallpaper();
        chapter3.id = 3;
        chapter3.WallpaperName = "RainyFlower";
        chapter3.WallpaperImage = R.drawable.rainflower;

        Wallpaper chapter4 = new Wallpaper();
        chapter4.id = 4;
        chapter4.WallpaperName = "RainyTornado";
        chapter4.WallpaperImage = R.drawable.rainc;

        Wallpaper chapter5 = new Wallpaper();
        chapter5.id = 5;
        chapter5.WallpaperName = "RainyMan";
        chapter5.WallpaperImage = R.drawable.rainmain;

        Wallpaper chapter6 = new Wallpaper();
        chapter6.id = 6;
        chapter6.WallpaperName = "RainyNature";
        chapter6.WallpaperImage = R.drawable.rainnature;

        physics.wallpapers.add(chapter1);
        physics.wallpapers.add(chapter2);
        physics.wallpapers.add(chapter3);
        physics.wallpapers.add(chapter4);
        physics.wallpapers.add(chapter5);
        physics.wallpapers.add(chapter6);

        WallpaperTheme Nature = new WallpaperTheme();
        Nature.id = 2;
        Nature.Title = "NatureThemes";
        Nature.wallpapers = new ArrayList<Wallpaper>();

        Wallpaper Nature1 = new Wallpaper();
        Nature1.id = 1;
        Nature1.WallpaperName = "Heaven";
        Nature1.WallpaperImage = R.drawable.heavenpath;

        Wallpaper Nature2 = new Wallpaper();
        Nature2.id = 2;
        Nature2.WallpaperName = "Dark Night";
        Nature2.WallpaperImage = R.drawable.darkknight;

        Wallpaper Nature3 = new Wallpaper();
        Nature3.id = 3;
        Nature3.WallpaperName = "Mother Mirror";
        Nature3.WallpaperImage = R.drawable.mirror;

        Wallpaper Nature4 = new Wallpaper();
        Nature4.id = 4;
        Nature4.WallpaperName = "River";
        Nature4.WallpaperImage = R.drawable.natureriver;

        Wallpaper Nature5 = new Wallpaper();
        Nature5.id = 5;
        Nature5.WallpaperName = "Red Tree";
        Nature5.WallpaperImage = R.drawable.redtree;

        Wallpaper Nature6 = new Wallpaper();
        Nature6.id = 6;
        Nature6.WallpaperName = "Sunrise";
        Nature6.WallpaperImage = R.drawable.sunrise;

        Nature.wallpapers.add(Nature1);
        Nature.wallpapers.add(Nature2);
        Nature.wallpapers.add(Nature3);
        Nature.wallpapers.add(Nature4);
        Nature.wallpapers.add(Nature5);
        Nature.wallpapers.add(Nature6);

        subjects.add(physics);
        subjects.add(Nature);

        return subjects;
    }
}
