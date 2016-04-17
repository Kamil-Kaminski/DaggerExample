package com.kaminski.daggerexample.dagger.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kamil on 17.04.16.
 */
@Module
public class ApiConfigurationModule {

    @Provides
    @Singleton
    @Named("base_url")
    String provideBaseUrl() {
        return "https://api.github.com/";
    }

    @Provides
    @Singleton
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory provideCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named("base_url") String url, Converter.Factory converter,
                             CallAdapter.Factory callAdapter, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(converter)
                .addCallAdapterFactory(callAdapter)
                .client(client)
                .build();
    }
}
