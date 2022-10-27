package com.pradip.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.blog.payloads.ApiResponse;
import com.pradip.blog.payloads.UserDTO;
import com.pradip.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	//Post-create user
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody   UserDTO userDTO){
		UserDTO createuserDTO = this.userService.createUser(userDTO);
		return new ResponseEntity<UserDTO>(createuserDTO, HttpStatus.CREATED);
			
	}
	//Put -update user 
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser( @Valid @RequestBody @PathVariable("userId") Integer userId , UserDTO userDTO){
		UserDTO updatedUser = this.userService.updateUser(userDTO, userId);
		
		return ResponseEntity.ok(updatedUser);
		
	}
	//Delete- delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId")Integer userId){
		 this.userService.deleteUser(userId);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true),HttpStatus.OK);
		
	}
	//Get -get user
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getsingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
		
	}

}
