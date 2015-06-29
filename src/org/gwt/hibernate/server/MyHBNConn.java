package org.gwt.hibernate.server;



import org.gwt.hibernate.client.UserDTO;
import org.gwt.hibernate.client.UserInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MyHBNConn extends RemoteServiceServlet implements UserInterface {
	
	//HibernateUtil hb= new HibernateUtil();
	@Override
	public UserDTO saveuser(int id,String username,String password) {
		// TODO Auto-generated method stub
		//SessionFactory factory= new Configuration().configure().buildSessionFactory();
		SessionFactory factory= new AnnotationConfiguration().configure().addPackage("org.gwt.hibernate.client").addAnnotatedClass(UserDTO.class).buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		session = factory.openSession();   
		session.beginTransaction();
		Transaction tx=session.beginTransaction();
		UserDTO userdto = new UserDTO(1, username, password);
		//User user= new User();
		//User user= new User(id, username, password);
		session.save(userdto);
		tx.commit();
		session.close();
		System.out.println("successfully saved");  
		return userdto;
	}

}
