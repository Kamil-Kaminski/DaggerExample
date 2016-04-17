package com.kaminski.daggerexample;

import android.app.Application;

import com.kaminski.daggerexample.dagger.component.AppComponent;

/**
 * Created by kamil on 17.04.16.
 */
public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    public static AppComponent component() {
        return appComponent;
    }

    private static void buildComponentAndInject() {
        appComponent = AppComponent.Initializer.init();
    }
}
