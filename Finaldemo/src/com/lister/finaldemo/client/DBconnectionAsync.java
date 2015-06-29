package com.lister.finaldemo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DBconnectionAsync {

	void authenticateuser(String username, String password,
			AsyncCallback<User> callback);

}
