package com.example.srping_mc.repository;

import com.example.srping_mc.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long>{
    User findByUserName(String userName);
    
}   