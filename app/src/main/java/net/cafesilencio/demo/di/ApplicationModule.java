package net.cafesilencio.demo.di;

import android.content.Context;

import net.cafesilencio.demo.DemoApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Seth Bourget on 4/14/18.
 */
@Module
public class ApplicationModule {

    private DemoApp app;

    public ApplicationModule(DemoApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return app;
    }
}
