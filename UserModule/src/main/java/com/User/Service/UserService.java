package com.User.Service;

import com.User.Entity.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    List<User> getAllUsers();

    public User getUserById(String userId);


}
