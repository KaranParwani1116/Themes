package com.example.themes.di;

import android.app.Application;

import com.example.themes.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {AndroidSupportInjectionModule.class, ActivityBuildersModule.class}
)
public interface AppComponent  extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder Application(Application application);

        AppComponent build();
    }
}
