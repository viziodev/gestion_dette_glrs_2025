package com.ism.services;

import java.util.List;

import com.ism.data.entities.User;

public interface UserService {

    public void createUser(User user) ;
    public List<User> findAllUser();
}
