package com.example.themes.di;

import com.example.themes.ui.home.HomeActivity;
import com.example.themes.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainModule.class}
    )
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract HomeActivity contributeHomeActivity();

}
