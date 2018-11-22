package Hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();		
		SessionFactory factory = cfg.buildSessionFactory( new StandardServiceRegistryBuilder().configure().build());
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Proyectos p = new Proyectos();
		p.setNombre("Nombre");
		p.setCodigo("14");
		p.setCiudad("Vitoria");
		session.save(p);
		tx.commit();
		System.out.println("=================================================");

		System.out.println("DATOS DEL DEPARTAMENTO 10.");
	}

}
