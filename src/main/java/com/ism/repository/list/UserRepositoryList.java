package com.ism.repository.list;



import com.ism.core.config.RepositoryListImpl;
import com.ism.entities.User;
import com.ism.repository.UserRepository;

public class UserRepositoryList extends RepositoryListImpl<User> implements UserRepository {

    @Override
    public User selectByLogin(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByLogin'");
    } 

}
