package com.pradip.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pradip.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
