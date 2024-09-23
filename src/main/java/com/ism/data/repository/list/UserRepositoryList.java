package com.ism.data.repository.list;



import com.ism.core.repository.impl.RepositoryListImpl;
import com.ism.data.entities.User;
import com.ism.data.repository.UserRepository;

public class UserRepositoryList extends RepositoryListImpl<User> implements UserRepository {

    @Override
    public User selectByLogin(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByLogin'");
    }

    @Override
    public User selectByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByID'");
    } 

}
