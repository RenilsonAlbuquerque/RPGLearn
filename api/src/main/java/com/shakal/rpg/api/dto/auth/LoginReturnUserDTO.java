package com.shakal.rpg.api.dto.auth;

import java.io.Serializable;

public class LoginReturnUserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9161763410710641665L;
	private long id;
	private String name;
	private String email;
	private String token;
	
	public LoginReturnUserDTO() {
		super();
	}
	public LoginReturnUserDTO(long id, String name, String email, String token) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.token = token;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
