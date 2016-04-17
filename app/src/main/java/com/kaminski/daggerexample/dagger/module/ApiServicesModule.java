package com.kaminski.daggerexample.dagger.module;

import com.kaminski.daggerexample.api.GitHubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by kamil on 17.04.16.
 */
@Module(includes = {ApiConfigurationModule.class})
public class ApiServicesModule {

    @Provides
    @Singleton
    GitHubService provideGitHubService(Retrofit retrofit) {
        return retrofit.create(GitHubService.class);
    }
}
