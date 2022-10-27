package com.pradip.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {
	private int id;
	@NotEmpty
	@Size(min=4 ,message = "UserName Must be min 4 charectors")
	private String name;

	@Email(message="email adrress is not valid")
	@NotEmpty
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message = "Password must be min of 3 chars and max of 10 chars")
	private  String Password;
	@NotEmpty
	private String about;
	public UserDTO(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Password = password;
		this.about = about;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}

}
