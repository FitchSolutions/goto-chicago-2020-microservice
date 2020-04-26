package com.dmrtech.userservice.services;

import com.dmrtech.userservice.model.User;

import java.util.Optional;

public interface UserService {
    enum UserCreationStatus {
        USER_CREATED,
        NOT_CREATED_DUPLICATE_USERNAME,
        NOT_CREATED_DUPLICATE_EMAIL
    }


    Optional<User> findById(long id);
    Iterable<User> findAll();
    UserCreationStatus createUser(User user);
}
