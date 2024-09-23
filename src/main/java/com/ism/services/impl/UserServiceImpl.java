package com.ism.services.impl;

import java.util.List;
import java.util.Collections;

import com.ism.core.repository.Repository;
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
  public User createUser(User user) {
    try {
      userRepository.insert(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public List<User> findAllUser() {
    try {
      return userRepository.selectAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return  Collections.emptyList();
  }

}
