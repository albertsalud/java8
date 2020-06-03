package com.albertsalud.gestortorneos.model.entities;

import java.io.Serializable;

public class TournamentAdministratorId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long tournament;
	private long administrator;

	public long getTournament() {
		return tournament;
	}

	public void setTournament(long tournament) {
		this.tournament = tournament;
	}

	public long getAdministrator() {
		return administrator;
	}

	public void setAdministrator(long administrator) {
		this.administrator = administrator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (administrator ^ (administrator >>> 32));
		result = prime * result + (int) (tournament ^ (tournament >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournamentAdministratorId other = (TournamentAdministratorId) obj;
		if (administrator != other.administrator)
			return false;
		if (tournament != other.tournament)
			return false;
		return true;
	}
	
	


}
