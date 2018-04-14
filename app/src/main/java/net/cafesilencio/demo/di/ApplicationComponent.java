package net.cafesilencio.demo.di;

import android.content.Context;

import net.cafesilencio.demo.DemoApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Seth Bourget on 4/14/18.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,ApplicationModule.class,BuildersModule.class})
public interface ApplicationComponent {
    Context context();
    void inject(DemoApp app);
}
