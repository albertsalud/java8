package com.albertsalud.hibernate.relationships.oneToMany.bidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parking {
	
	public Parking() {
		vehicles = new ArrayList<>();
	}
	
	@Id
	private long id;
	private String name;
	
	@OneToMany
	private List<Vehicle> vehicles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	} 
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		vehicle.setParking(this);
	}
	

}
