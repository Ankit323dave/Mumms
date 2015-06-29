package com.lister.finaldemo.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class User implements IsSerializable{
	private int id;
	private String username;
	private String password;
	
	public User(){
		
	}
	
	public User(int id,String username, String password) {
		this.id=id;
		this.username = username;
		this.password = password;
	}
	
}
