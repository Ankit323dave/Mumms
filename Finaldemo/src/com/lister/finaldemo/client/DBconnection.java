package com.lister.finaldemo.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MyPostgresConn")
public interface DBconnection extends RemoteService {
	User authenticateuser(String username, String password);

}
