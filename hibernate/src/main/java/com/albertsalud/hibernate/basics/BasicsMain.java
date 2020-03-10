package com.albertsalud.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BasicsMain {
	
	public static void main(String[] main) {
		
		// Código de creación de SF para versiones de hibernate anteriores a la 5
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		// Generacion del session factory
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		// Apertura de sesion
		Session session = sf.openSession();
		
		User user = new User();
		user.setId(1);
		user.setUserName("Albert");
		user.setUserMessage("Hola de parte de Albert");
		
		User user2 = new User();
		user2.setId(2);
		user2.setUserName("Juan");
		user2.setUserMessage("Hola de parte de Juan");
		
		session.getTransaction().begin();
		
		session.save(user);
		session.save(user2);
		
		session.getTransaction().commit();
		
		// Cierre de la sesion
		session.close();
		sf.close();
		
	}

}
