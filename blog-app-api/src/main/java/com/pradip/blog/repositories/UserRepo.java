package com.pradip.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pradip.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
