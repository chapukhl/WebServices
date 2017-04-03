package com.epam.mp.service.impl;

import com.epam.mp.entity.User;
import com.epam.mp.service.UserService;

import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    static  {
        users.add(new User("Luka", "Chapukhin", "chapukhl", "Luka_Chapukhin@epam.com"));
        users.add(new User("Andrei", "Bordak", "bordakan", "Andrei_Bordal@epam.com"));

    }

    @Override
    public User getUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst().get();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void createUser(User user) {
        users.add(user);
    }

    public void deleteUser(String login) {
        users.removeIf(user -> user.getLogin().equals(login));
    }

    public void updateUser(String login, User newUser) {
        deleteUser(login);
        createUser(newUser);
    }
}
