package com.smalaca.domain;

public interface UserRepository {
    void save(User user);

    User findById(String id);
}
