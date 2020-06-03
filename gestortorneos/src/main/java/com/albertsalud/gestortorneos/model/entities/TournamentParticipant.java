package com.albertsalud.gestortorneos.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(TournamentParticipantId.class)
public class TournamentParticipant {
	@Id
	@ManyToOne
	@JoinColumn(name = "tournamentId", insertable = false, updatable = false)
	private Tournament tournament;

	@Id
	@ManyToOne
	@JoinColumn(name = "participantId", insertable = false, updatable = false)
	private Participant participant;

	private boolean confirmed;
	private boolean disqualified;

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public boolean isDisqualified() {
		return disqualified;
	}

	public void setDisqualified(boolean disqualified) {
		this.disqualified = disqualified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (confirmed ? 1231 : 1237);
		result = prime * result + (disqualified ? 1231 : 1237);
		result = prime * result + ((participant == null) ? 0 : participant.hashCode());
		result = prime * result + ((tournament == null) ? 0 : tournament.hashCode());
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
		TournamentParticipant other = (TournamentParticipant) obj;
		if (confirmed != other.confirmed)
			return false;
		if (disqualified != other.disqualified)
			return false;
		if (participant == null) {
			if (other.participant != null)
				return false;
		} else if (!participant.equals(other.participant))
			return false;
		if (tournament == null) {
			if (other.tournament != null)
				return false;
		} else if (!tournament.equals(other.tournament))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TournamentParticipant [participant=" + participant + ", confirmed="
				+ confirmed + ", disqualified=" + disqualified + "]";
	}
	
	

}
