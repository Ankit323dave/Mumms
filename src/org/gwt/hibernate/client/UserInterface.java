package org.gwt.hibernate.client;

import org.gwt.hibernate.server.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MyHBNConn")
public interface UserInterface extends RemoteService {
	
	public UserDTO saveuser(int id,String username,String password);
	
	
}
