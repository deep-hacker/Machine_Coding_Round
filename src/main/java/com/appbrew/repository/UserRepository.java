package com.appbrew.repository;

import com.appbrew.model.User;
import lombok.NonNull;

public interface UserRepository {
    void createUser(@NonNull User newUser);

    User getUser(@NonNull String userId);
}
