package net.cafesilencio.demo;

import android.app.Activity;
import android.app.Application;

import net.cafesilencio.demo.di.ApplicationModule;
import net.cafesilencio.demo.di.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

/**
 * Created by Seth Bourget on 4/14/18.
 */
public class DemoApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        initializeInjector();
    }

    protected void initializeInjector() {
        DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
