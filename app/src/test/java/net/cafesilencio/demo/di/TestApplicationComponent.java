package net.cafesilencio.demo.di;

import android.content.Context;

import net.cafesilencio.demo.TestDemoApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Seth Bourget on 4/14/18.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,TestApplicationModule.class,BuildersModule.class})
public interface TestApplicationComponent extends ApplicationComponent {
    Context context();
    void inject(TestDemoApp app);
}