package org.gwt.hibernate.client;

import org.gwt.hibernate.server.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserInterfaceAsync {

	void saveuser(int id, String username, String password,
			AsyncCallback<UserDTO> callback);

}
