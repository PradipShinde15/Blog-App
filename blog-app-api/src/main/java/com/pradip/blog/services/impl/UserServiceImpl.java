package com.pradip.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradip.blog.exceptions.*;
import com.pradip.blog.entities.User;
import com.pradip.blog.payloads.UserDTO;
import com.pradip.blog.repositories.UserRepo;
import com.pradip.blog.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.dtoToUser(userDTO);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		//user.setId(userDTO.getId());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		User updatedUser=this.userRepo.save(user);
		UserDTO userDTO1=this.userToDto(updatedUser);
		
		
		return userDTO1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users =this.userRepo.findAll();
		 List<UserDTO> userDTOs = users.stream().map(user->userToDto(user)).collect(Collectors.toList());
		return userDTOs; 
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
		
	}
	public User dtoToUser(UserDTO userDTO) {
		User user=new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		return user;
		
	}
	public UserDTO userToDto(User user) {
		UserDTO userDTO =new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setAbout(user.getAbout());
		userDTO.setPassword(user.getPassword());
		return userDTO;
		
	}

}
