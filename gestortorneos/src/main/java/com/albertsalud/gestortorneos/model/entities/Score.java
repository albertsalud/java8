package com.albertsalud.gestortorneos.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Score implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	protected int victoryPoints;
	protected int tournamentPoints;
	protected boolean validated;
	
	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	/*@OneToOne
	@JoinColumns({
		@JoinColumn(name="participantId", referencedColumnName = "participantId"),
		@JoinColumn(name="gameId", referencedColumnName = "gameId")
	})
	protected GameParticipant gameParticipant;
	
	public void setGameParticipant(GameParticipant gp) {
		this.gameParticipant = gp;
	}*/

	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}

	public int getTournamentPoints() {
		return tournamentPoints;
	}

	public void setTournamentPoints(int tournamentPoints) {
		this.tournamentPoints = tournamentPoints;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", victoryPoints=" + victoryPoints + ", tournamentPoints=" + tournamentPoints
				+ ", validated=" + validated + "]";
	}
	
	

}
