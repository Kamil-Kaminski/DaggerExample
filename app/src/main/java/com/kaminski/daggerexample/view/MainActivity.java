package com.kaminski.daggerexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kaminski.daggerexample.App;
import com.kaminski.daggerexample.R;
import com.kaminski.daggerexample.api.GitHubService;
import com.kaminski.daggerexample.api.model.User;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    @Inject
    GitHubService gitHubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.component().inject(this);

        gitHubService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<User>>() {
                    @Override
                    public void call(List<User> users) {
                        Log.d("TAG", users.get(0).getLogin());
                    }
                });

    }
}
