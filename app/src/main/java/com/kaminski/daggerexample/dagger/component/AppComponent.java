package com.kaminski.daggerexample.dagger.component;

import com.kaminski.daggerexample.dagger.module.ApiServicesModule;
import com.kaminski.daggerexample.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kamil on 17.04.16.
 */
@Singleton
@Component(modules = {ApiServicesModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    final class Initializer {
        public static AppComponent init() {
            return DaggerAppComponent.builder()
                    .build();
        }
    }
}
