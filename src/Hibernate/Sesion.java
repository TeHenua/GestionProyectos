package Hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Sesion {
	private static Configuration configuration;
	private static SessionFactory factory;
	private static Session session;
	private static Transaction tx;
	private static Query query;
	

	public static void abrir(){
		configuration = new Configuration().configure();	
		factory = configuration.buildSessionFactory( new StandardServiceRegistryBuilder().configure().build());
		session = factory.openSession();
	}
	
	public static void sesion(){
		if(session==null ){
			abrir();
		}else if(!session.isOpen()){
			session = factory.openSession();
		}
	}
	
	public static void guardar(Object object){
		sesion();
		tx = session.beginTransaction();
		session.save(object);
		tx.commit();
		System.out.println("Guardado " + object.getClass());
		session.close();
	}
	
	public static void modificar(Object object){
		sesion();
		tx = session.beginTransaction();
		session.update(object);
		tx.commit();
		System.out.println("Modificado " + object.getClass());
		session.close();
	}

	public static List<Proveedores> cargarProveedores() {
		sesion();
		query = session.createQuery("from Proveedores");
		List<Proveedores> proveedores = query.list();
		return proveedores;
	}
}
