package net.cafesilencio.demo.di;

import net.cafesilencio.demo.view.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Seth Bourget on 4/14/18.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();


}
