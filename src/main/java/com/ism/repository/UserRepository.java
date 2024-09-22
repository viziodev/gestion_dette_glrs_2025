package com.ism.repository;

import com.ism.core.config.Repository;
import com.ism.entities.User;


public interface UserRepository extends Repository<User>{
    User selectByLogin(String login);
}

