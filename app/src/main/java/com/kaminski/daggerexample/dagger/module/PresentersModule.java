package com.kaminski.daggerexample.dagger.module;

import com.kaminski.daggerexample.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kamil on 09.05.16.
 */
@Module
public class PresentersModule {

    @Provides
    @Singleton
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
