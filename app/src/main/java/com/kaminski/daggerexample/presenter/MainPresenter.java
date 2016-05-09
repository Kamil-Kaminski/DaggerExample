package com.kaminski.daggerexample.presenter;

import com.kaminski.daggerexample.App;
import com.kaminski.daggerexample.api.GitHubService;
import com.kaminski.daggerexample.api.model.User;
import com.kaminski.daggerexample.events.UsersListEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by kamil on 09.05.16.
 */
public class MainPresenter {
    @Inject
    GitHubService gitHubService;

    public interface Subscriber {
        void onMessageEvent(UsersListEvent event);
    }

    public MainPresenter() {
        App.appComponent().inject(this);
    }

    public void requestData() {
        gitHubService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<User>>() {
                    @Override
                    public void call(List<User> users) {
                        EventBus.getDefault().post(new UsersListEvent(users));
                    }
                });
    }
}
