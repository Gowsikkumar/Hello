package com.example.registerform.service;

import com.example.registerform.model.User;
import com.example.registerform.repo.UserRepositroy;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepositroy userrepository;

    public UserService(UserRepositroy userrepository) {
        this.userrepository = userrepository;
    }
    public List<User> getAllUsers()
    {
        return userrepository.findAll();

    }
    public User create(User user)
    {
        return userrepository.save(user);
    }
    public Optional<User>getById(Long id)
    {
        return userrepository.findById(id);

    }
    public void deleteById(Long id)
    {
        userrepository.deleteById(id);
    }
    public List<User>Read()
    {
        return userrepository.findAll();
    }
}
