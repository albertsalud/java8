package com.albertsalud.gestortorneos.model.entities;

import java.io.Serializable;

public class TournamentParticipantId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long tournament;
	private long participant;

	public long getTournament() {
		return tournament;
	}

	public void setTournament(long tournament) {
		this.tournament = tournament;
	}

	public long getParticipant() {
		return participant;
	}

	public void setParticipant(long participant) {
		this.participant = participant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (participant ^ (participant >>> 32));
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
		TournamentParticipantId other = (TournamentParticipantId) obj;
		if (participant != other.participant)
			return false;
		if (tournament != other.tournament)
			return false;
		return true;
	}

}
