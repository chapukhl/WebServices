package com.epam.mp.service;

import com.epam.mp.entity.User;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);

    List<User> getAllUsers();

    void createUser(User user);

    void  deleteUser(String login);

    void updateUser(String login, User newUser);
}
