package Hibernate;

import java.util.List;

import org.hibernate.query.Query;
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
		List<Proveedores> prov = query.list();
		session.close();
		return prov;
	}
	
	public static List<Piezas> cargarPiezas() {
		sesion();
		query = session.createQuery("from Piezas");
		List<Piezas> piezas = query.list();
		session.close();
		return piezas;
	}
	
	public static List<Proyectos> cargarProyectos() {
		sesion();
		query = session.createQuery("from Proyectos");
		List<Proyectos> pro = query.list();
		session.close();
		return pro;
	}
	
	public static List<Gestion> cargarGestiones() {
		sesion();
		query = session.createQuery("from Gestion");
		List<Gestion> ges = query.list();
		session.close();
		return ges;
	}

	public static void borrar(Object object) {
		sesion();
		tx = session.beginTransaction();
		session.delete(object);
		tx.commit();
		System.out.println("Eliminado " + object.getClass());
		session.close();
	}





	
}
