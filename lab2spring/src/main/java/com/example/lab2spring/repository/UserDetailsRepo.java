package com.example.lab2spring.repository;

import com.example.lab2spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User,String> {
}
