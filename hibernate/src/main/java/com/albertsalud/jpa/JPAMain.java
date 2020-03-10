package com.albertsalud.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.albertsalud.hibernate.basics.User;

public class JPAMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePersistenceContext");
		
		EntityManager em = emf.createEntityManager();
		
		User user = new User();
		user.setId(1);
		user.setUserName("Albert");
		user.setUserMessage("Hola de parte de Albert con JPA");
		
		User user2 = new User();
		user2.setId(2);
		user2.setUserName("Juan");
		user2.setUserMessage("Hola de parte de Juan con JPA");
		
		em.getTransaction().begin();
		
		
		em.persist(user);
		em.persist(user2);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}

}
