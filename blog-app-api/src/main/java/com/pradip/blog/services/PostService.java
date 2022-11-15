package com.pradip.blog.services;

import java.util.List;

import com.pradip.blog.entities.Post;
import com.pradip.blog.payloads.PostDto;

public interface PostService {
	PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId);
	
	PostDto updatePostById(PostDto postDto,Integer postId);
	
	void deletePost(Integer postId);
	
	List<PostDto> getAllPost();
	
	PostDto getPostById (Integer postId);
	
	//get all post by category
	 
	List<PostDto> getPostByCategory(Integer categoryId);
	
	// get all post by user
	
	List<PostDto> getAllPostByUser(Integer userId);
	//search posts
	List<PostDto> searchPosts(String keyword);
	
	

}
