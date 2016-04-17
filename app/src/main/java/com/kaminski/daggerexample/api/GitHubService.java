package com.kaminski.daggerexample.api;

import com.kaminski.daggerexample.api.model.User;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by kamil on 17.04.16.
 */
public interface GitHubService {

    @GET("/users")
    Observable<List<User>> getUsers();
}
