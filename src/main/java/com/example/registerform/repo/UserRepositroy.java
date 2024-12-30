package com.example.registerform.repo;


import com.example.registerform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositroy extends JpaRepository<User,Long> {
}
