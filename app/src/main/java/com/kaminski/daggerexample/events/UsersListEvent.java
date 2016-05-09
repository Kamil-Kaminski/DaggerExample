package com.kaminski.daggerexample.events;

import com.kaminski.daggerexample.api.model.User;

import java.util.List;

/**
 * Created by kamil on 09.05.16.
 */
public class UsersListEvent {
    private List<User> users;

    public UsersListEvent(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
