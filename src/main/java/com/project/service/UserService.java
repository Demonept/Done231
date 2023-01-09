package com.project.service;

import com.project.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    void update(User user);

    User getUser(Long id);

    void deleteUser(Long id);
}
