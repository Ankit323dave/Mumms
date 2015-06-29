package org.gwt.hibernate.server;

import java.io.Serializable;

import org.gwt.hibernate.client.UserDTO;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String username;
	public String password;
	
	public User(){}

	
	public User(UserDTO user){
		this.id=user.getId();
		this.username=user.getUsername();
		this.password=user.getPassword();
	}
	
	public User(Integer id, String username, String password) {
		
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// saving the data on DB

	
}
