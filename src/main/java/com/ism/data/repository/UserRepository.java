package com.ism.data.repository;

import com.ism.core.repository.Repository;
import com.ism.data.entities.User;

public interface UserRepository extends Repository<User> {
    User selectByLogin(String login);
    User selectByID(int id);
}
