package com.kaminski.daggerexample.view;

import android.os.Bundle;
import android.util.Log;

import com.kaminski.daggerexample.App;
import com.kaminski.daggerexample.R;
import com.kaminski.daggerexample.api.model.User;
import com.kaminski.daggerexample.events.UsersListEvent;
import com.kaminski.daggerexample.presenter.MainPresenter;
import com.kaminski.daggerexample.util.BaseActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenter.Subscriber {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.presentersComponent().inject(this);
        mainPresenter.requestData();
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(UsersListEvent event) {
        List<String> names = new ArrayList<>();
        for (User user : event.getUsers()) {
            names.add(user.getLogin());
        }

        Log.d(MainActivity.class.getSimpleName(), Arrays.toString(names.toArray()));
    }
}
