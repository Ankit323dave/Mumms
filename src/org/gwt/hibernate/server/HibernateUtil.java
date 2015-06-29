package org.gwt.hibernate.server;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	
		private static SessionFactory factory= new Configuration().configure().buildSessionFactory();
						
		public  SessionFactory getsessionfactory(){
			return factory;
		} 
}
