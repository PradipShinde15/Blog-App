package com.pradip.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradip.blog.entities.Category;
import com.pradip.blog.exceptions.ResourceNotFoundException;
import com.pradip.blog.payloads.CategoryDto;
import com.pradip.blog.repositories.CategoryRepo;
import com.pradip.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addedCateory=this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCateory, CategoryDto.class);
		 
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
			Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "category Id", categoryId));
			this.categoryRepo.deleteById(categoryId);
			

	}

	@Override
	public CategoryDto getCategoryById(Integer categoryInteger) {
		Category cat=this.categoryRepo.findById(categoryInteger).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", categoryInteger));
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> cate=this.categoryRepo.findAll();
		List<CategoryDto> list=cate.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return list;
	}
	

}
