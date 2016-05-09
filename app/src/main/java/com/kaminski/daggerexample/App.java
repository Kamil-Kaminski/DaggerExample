package com.kaminski.daggerexample;

import android.app.Application;

import com.kaminski.daggerexample.dagger.component.AppComponent;
import com.kaminski.daggerexample.dagger.component.PresentersComponent;

/**
 * Created by kamil on 17.04.16.
 */
public class App extends Application {

    private static AppComponent appComponent;
    private static PresentersComponent presentersComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildAppComponentAndInject();
        buildPresentersComponentAndInject();
    }

    public static AppComponent appComponent() {
        return appComponent;
    }

    public static PresentersComponent presentersComponent() {
        return presentersComponent;
    }

    private static void buildAppComponentAndInject() {
        appComponent = AppComponent.Initializer.init();
    }

    private static void buildPresentersComponentAndInject() {
        presentersComponent = PresentersComponent.Initializer.init();
    }
}
