package com.shakal.rpg.api.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;



public class AuthenticationContext implements Authentication {
	
	private Boolean authenticated;
    private Long id;
    private String email;
    private String password;
    
    public AuthenticationContext(Boolean authenticated, Long id, String email,
    		String password) {
		super();
		this.authenticated = authenticated;
		this.id = id;
		this.email = email;
		this.password = password;
		
	}
    public AuthenticationContext(Long id, String email) {
		super();
		this.authenticated = true;
		this.id = id;
		this.email = email;
		
	}
	public Boolean getAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getName() {
		return this.getEmail();
	}
	@Override
	public Object getCredentials() {
		return this.getPassword();
	}
	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return this.authenticated;
	}
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.authenticated = isAuthenticated;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<GrantedAuthority>();
	}
}
