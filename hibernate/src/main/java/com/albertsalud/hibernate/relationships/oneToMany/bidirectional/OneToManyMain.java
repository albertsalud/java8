package com.albertsalud.hibernate.relationships.oneToMany.bidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePersistenceContext");
		EntityManager em = emf.createEntityManager();
		
		Parking parking = new Parking();
		parking.setName("Parking Albert");
		parking.setId(1);
		
		Vehicle car = new Vehicle();
		car.setId(1);
		car.setRegistration("1234-DMW");
		car.setVehicleType("car");
		
		Vehicle motorbike = new Vehicle();
		motorbike.setId(2);
		motorbike.setRegistration("9999-XXX");
		motorbike.setVehicleType("motorbike");
		
		parking.addVehicle(car);
		parking.addVehicle(motorbike);
		
		em.getTransaction().begin();
		
		em.persist(parking);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();

	}

}
