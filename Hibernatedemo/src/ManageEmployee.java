import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.annotationfactory.AnnotationFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class ManageEmployee {
	
	private static SessionFactory factory;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Configuration cfg=new Configuration();  
	    //cfg.configure("hibernate.cfg.xml");
	    //factory =new AnnotationConfiguration().configure().buildSessionFactory(serviceRegistry)
	    //SessionFactory factory=cfg.buildSessionFactory();
	    //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	    //factory =new AnnotationConfiguration().configure().addAnnotatedClass(Employee.class).buildSessionFactory(serviceRegistry);
	    factory = new AnnotationConfiguration().buildSessionFactory();
		ManageEmployee me=new ManageEmployee();
		me.addEmployee(1,"Ankit","Dave");
		me.addEmployee(1,"Ankit","lannister");
		me.addEmployee(1,"Ankit","Snow");
		me.addEmployee(1,"Ankit","S");
	}

	private void addEmployee(int i, String fname, String lname) {
		// TODO Auto-generated method stub
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee employee= new Employee(i, fname, lname);
		session.save(employee);
		tx.commit();
		session.close();
		System.out.println("successfully saved");  
	}

}
