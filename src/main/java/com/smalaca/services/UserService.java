package com.smalaca.services;

import com.smalaca.domain.User;
import com.smalaca.domain.UserRepository;

class UserService {
    private final UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createAdmin(String login) {
        User user = new User(login, "admin");
        repository.save(user);

        return user;
    }

    public User createContributor(String login) {
        User user = new User(login, "contributor");
        repository.save(user);

        return user;
    }

    public User createWatcher(String login) {
        User user = new User(login, "watcher");
        repository.save(user);

        return user;
    }
}
