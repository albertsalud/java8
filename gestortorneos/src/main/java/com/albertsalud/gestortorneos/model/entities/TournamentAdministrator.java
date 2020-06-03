package com.albertsalud.gestortorneos.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(TournamentAdministratorId.class)
public class TournamentAdministrator {
	
	@Id
    @ManyToOne
    @JoinColumn(
            name="participantId",
            insertable = false, 
            updatable = false
    )
	private Participant administrator;
	
	@Id
    @ManyToOne
    @JoinColumn(
            name="tournamentId",
            insertable = false, 
            updatable = false
    )
	private Tournament tournament;
	
	private boolean accepted;

	public Participant getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Participant administrator) {
		this.administrator = administrator;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

}
