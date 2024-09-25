package com.ism.data.repository.em;

import com.ism.core.repository.impl.RepositoryEmImpl;
import com.ism.data.entities.User;
import com.ism.data.repository.UserRepository;

public class UserRepositoryEm extends RepositoryEmImpl<User> implements UserRepository {

    public UserRepositoryEm() {
        super(User.class);
    }

    @Override
    public User selectByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User selectByLogin(String login) {
        // TODO Auto-generated method stub
        return null;
    }

}
