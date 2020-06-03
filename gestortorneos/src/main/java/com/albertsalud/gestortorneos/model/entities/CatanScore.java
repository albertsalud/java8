package com.albertsalud.gestortorneos.model.entities;

import javax.persistence.Entity;

@Entity
public class CatanScore extends Score {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roadsNumber;
	private int villagesNumber;
	private int citiesNumber;

	private boolean greatTradeRoute;
	private boolean cavalryArmy;


	public int getRoadsNumber() {
		return roadsNumber;
	}

	public void setRoadsNumber(int roadsNumber) {
		this.roadsNumber = roadsNumber;
	}

	public int getVillagesNumber() {
		return villagesNumber;
	}

	public void setVillagesNumber(int villagesNumber) {
		this.villagesNumber = villagesNumber;
	}

	public int getCitiesNumber() {
		return citiesNumber;
	}

	public void setCitiesNumber(int citiesNumber) {
		this.citiesNumber = citiesNumber;
	}

	public boolean isGreatTradeRoute() {
		return greatTradeRoute;
	}

	public void setGreatTradeRoute(boolean greatTradeRoute) {
		this.greatTradeRoute = greatTradeRoute;
	}

	public boolean isCavalryArmy() {
		return cavalryArmy;
	}

	public void setCavalryArmy(boolean cavalryArmy) {
		this.cavalryArmy = cavalryArmy;
	}

}
