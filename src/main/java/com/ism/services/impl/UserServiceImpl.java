package com.ism.services.impl;

import java.util.List;

import com.ism.core.config.Repository;
import com.ism.entities.User;
import com.ism.services.UserService;

public class UserServiceImpl implements UserService {
  // Couplage Faible
  private Repository<User> userRepository;

  // Injection de Dependance
  // Constructeur

  // Setters

  public UserServiceImpl(Repository<User> userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createUser(User user) {
    userRepository.insert(user);
  }

  @Override
  public List<User> findAllUser() {
    return userRepository.selectAll();
  }

}
