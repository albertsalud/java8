package com.albertsalud.hibernate.relationships.oneToMany.unidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePersistenceContext");
		EntityManager em = emf.createEntityManager();
		
		Phone phone = new Phone();
		phone.setPhoneNumber("123456");
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone);
				
		Person person = new Person();
		person.setName("Albert Salud");
		person.setPhones(phones);
		
		
		em.getTransaction().begin();
		
		em.persist(person);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();

	}

}
