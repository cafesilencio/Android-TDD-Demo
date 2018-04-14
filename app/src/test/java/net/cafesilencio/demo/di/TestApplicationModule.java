package net.cafesilencio.demo.di;

import net.cafesilencio.demo.TestDemoApp;
import net.cafesilencio.demo.di.ApplicationModule;

import dagger.Module;

/**
 * Created by Seth Bourget on 3/31/18.
 */

@Module
public class TestApplicationModule extends ApplicationModule {

    public TestApplicationModule(TestDemoApp app) {
        super(app);
    }
}
