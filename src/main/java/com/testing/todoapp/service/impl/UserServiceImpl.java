package com.testing.todoapp.service.impl;

import com.testing.todoapp.model.User;
import com.testing.todoapp.repository.UserRepository;
import com.testing.todoapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }
}
