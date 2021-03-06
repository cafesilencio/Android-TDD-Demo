package net.cafesilencio.demo;

import net.cafesilencio.demo.di.DaggerApplicationComponent;
import net.cafesilencio.demo.di.TestApplicationModule;

/**
 * Created by Seth Bourget on 4/14/18.
 */
public class TestDemoApp extends DemoApp {

    @Override
    protected void initializeInjector() {
        DaggerApplicationComponent.builder()
                .applicationModule(new TestApplicationModule(this))
                .build().inject(this);
    }


}
