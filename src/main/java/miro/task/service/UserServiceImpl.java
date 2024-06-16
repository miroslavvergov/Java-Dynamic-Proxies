package miro.task.service;

import miro.task.model.User;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println(user.getName() + " is added successfully");
    }
}
