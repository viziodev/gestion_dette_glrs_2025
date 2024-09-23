package com.ism.services.impl;

import java.util.List;
import com.ism.data.entities.User;
import com.ism.data.repository.UserRepository;
import com.ism.services.UserService;

public class UserServiceImpl implements UserService {
  // Couplage Faible
  private UserRepository userRepository;

  // Injection de Dependance
  // Constructeur

  // Setters

  public UserServiceImpl(UserRepository userRepository) {
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
