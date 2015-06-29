package com.lister.finaldemo.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.google.cloud.sql.jdbc.PreparedStatement;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.lister.finaldemo.client.DBconnection;
import com.lister.finaldemo.client.User;

public class MyPostgresConn extends RemoteServiceServlet implements DBconnection {
	
	private Connection conn = null;
	private String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private String user = "postgres";
	private String pass = "password";
	private static Logger log = Logger.getLogger(MyPostgresConn.class.getName());
	public MyPostgresConn(){
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			
			conn = DriverManager.getConnection(url, user, pass);
			log.severe("Exception in this class conn not found" + conn);
			//Window.alert("connected");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	@Override
	public User authenticateuser(String username1, String password1) {
		
		User user = null;
		try {
			if (conn==null){
				return null;
			}
			//PreparedStatement ps=(PreparedStatement) conn.prepareStatement("select * from users where username="+username+"and password="+password+";");
			java.sql.PreparedStatement ps= conn.prepareStatement("select * from users where username=?and password=?");
			ps.setString(1, username1);
			ps.setString(2, password1);
			
			ResultSet result=ps.executeQuery();
			
			while(result.next()){
//				Window.alert("executing");
				user=new User(result.getString(1), result.getString(2));
			}
			result.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		// TODO Auto-generated method stub
		
	}

}
