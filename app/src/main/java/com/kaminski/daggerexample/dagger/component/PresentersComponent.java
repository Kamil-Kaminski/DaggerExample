package com.kaminski.daggerexample.dagger.component;

import com.kaminski.daggerexample.dagger.module.PresentersModule;
import com.kaminski.daggerexample.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kamil on 09.05.16.
 */
@Singleton
@Component(modules = {PresentersModule.class})
public interface PresentersComponent {

    void inject(MainActivity mainActivity);

    final class Initializer {
        public static PresentersComponent init() {
            return DaggerPresentersComponent.builder()
                    .build();
        }
    }
}
