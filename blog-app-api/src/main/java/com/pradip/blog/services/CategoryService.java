package com.pradip.blog.services;

import java.util.List;

import com.pradip.blog.payloads.CategoryDto;

public interface CategoryService  {
	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);

	//update
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	//delete
	public void deleteCategory(Integer categoryId);
	//get
	public CategoryDto getCategoryById(Integer categoryInteger);
	//getAll
	public List<CategoryDto> getAllCategory();
}
