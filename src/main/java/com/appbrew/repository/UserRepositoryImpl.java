package com.appbrew.repository;

import com.appbrew.model.User;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    Map<String, User> users = new HashMap<>();

    @Override
    public void createUser(@NonNull final User newUser) {
        if (users.containsKey(newUser.getId())) {
            throw new RuntimeException("User Already Exists");
        }

        users.put(newUser.getId(), newUser);
    }

    @Override
    public User getUser(@NonNull final String userId) {
        if (!users.containsKey(userId)) {
            throw new RuntimeException("User Not Found");
        }
        return users.get(userId);
    }
}
