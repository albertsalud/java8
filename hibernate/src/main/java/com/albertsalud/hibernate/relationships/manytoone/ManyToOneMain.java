package com.albertsalud.hibernate.relationships.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePersistenceContext");
		
		EntityManager em = emf.createEntityManager();
		
		Brand brand = new Brand("Hugo Boss", "my logotype");
		
		Product product = new Product();
		product.setBrand(brand);
		product.setName("Hugo boss fragance");
		product.setQuantity(350);
		product.setType("Fragance");
		
		em.getTransaction().begin();
		
		em.persist(brand);
		em.persist(product);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();

	}

}
