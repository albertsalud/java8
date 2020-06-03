package com.albertsalud.gestortorneos.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Tournament implements Serializable {
	
	public static final int STATUS_ON_COMMING = 0;
	public static final int STATUS_PLAYING = 10;
	public static final int STATUS_FINISHED = 100;
	
	public static final String TYPE_CATAN = "CATAN";
	public static final String TYPE_CARCASSONNE = "CARCASSONNE";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, length = 60)
	private String name;
	
	@Column(nullable = false)
	private int roundsNumber;
	
	private boolean hasQuarters;
	private int quartersParticipantsPerGame;
	private boolean hasSemiFinal;
	private int semiFinalParticipantsPerGame;
	private boolean hasFinal;
	private int finalParticipantsPerGame;
	
	private int maxParticipants;
	
	private int status;
	
	@CreationTimestamp
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date tournamentDate;
	
	@Column(nullable = false, length = 15, updatable = false)
	private String tournamentType;
	
	public String getTournamentType() {
		return tournamentType;
	}

	public void setTournamentType(String tournamentType) {
		this.tournamentType = tournamentType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "creatorId")
	private Participant tournamentCreator;
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TournamentAdministrator> tournamentAdministrators;
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TournamentParticipant> tournamentParticipants;
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Round> rounds;
	
	public Tournament() {
		tournamentAdministrators = new ArrayList<>();
		tournamentParticipants = new ArrayList<>();
		rounds = new ArrayList<>();
	}
	
	public void addRound(Round round) {
		rounds.add(round);
		round.setTournament(this);
	}
	
	public List<TournamentParticipant> getTournamentParticipants(){
		return this.tournamentParticipants;
	}
	
	public void setTournamentParticipants(List<TournamentParticipant> tournamentParticipants) {
		this.tournamentParticipants = tournamentParticipants;
	}
	
	public List<TournamentAdministrator> getTournamentAdministrators(){
		return this.tournamentAdministrators;
	}

	public void addTournamentAdminitrator(Participant tournamentAdministrator) {
		TournamentAdministrator ta = new TournamentAdministrator();
		ta.setAdministrator(tournamentAdministrator);
		ta.setTournament(this);
		
		tournamentAdministrators.add(ta);
	}
	
	public void addTournamentParticipant(Participant participant) {
		TournamentParticipant tp = new TournamentParticipant();
		tp.setParticipant(participant);
		tp.setTournament(this);
		
		this.tournamentParticipants.add(tp);
	}
	
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

	public int getRoundsNumber() {
		return roundsNumber;
	}

	public void setRoundsNumber(int roundsNumber) {
		this.roundsNumber = roundsNumber;
	}

	public boolean isHasQuarters() {
		return hasQuarters;
	}

	public void setHasQuarters(boolean hasQuaters) {
		this.hasQuarters = hasQuaters;
	}

	public int getQuartersParticipantsPerGame() {
		return quartersParticipantsPerGame;
	}

	public void setQuartersParticipantsPerGame(int quartersParticipantsPerGame) {
		this.quartersParticipantsPerGame = quartersParticipantsPerGame;
	}

	public boolean isHasSemiFinal() {
		return hasSemiFinal;
	}

	public void setHasSemiFinal(boolean hasSemiFinal) {
		this.hasSemiFinal = hasSemiFinal;
	}

	public int getSemiFinalParticipantsPerGame() {
		return semiFinalParticipantsPerGame;
	}

	public void setSemiFinalParticipantsPerGame(int semiFinalParticipantsPerGame) {
		this.semiFinalParticipantsPerGame = semiFinalParticipantsPerGame;
	}

	public boolean isHasFinal() {
		return hasFinal;
	}

	public void setHasFinal(boolean hasFinal) {
		this.hasFinal = hasFinal;
	}

	public int getFinalParticipantsPerGame() {
		return finalParticipantsPerGame;
	}

	public void setFinalParticipantsPerGame(int finalParticipantsPerGame) {
		this.finalParticipantsPerGame = finalParticipantsPerGame;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public Date getTournamentDate() {
		return tournamentDate;
	}

	public void setTournamentDate(Date tournamentDate) {
		this.tournamentDate = tournamentDate;
	}

	public Participant getTournamentCreator() {
		return tournamentCreator;
	}

	public void setTournamentCreator(Participant tournamentCreator) {
		this.tournamentCreator = tournamentCreator;
	}

	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", roundsNumber=" + roundsNumber + ", hasQuaters="
				+ hasQuarters + ", quartersParticipantsPerGame=" + quartersParticipantsPerGame + ", hasSemiFinal="
				+ hasSemiFinal + ", semiFinalParticipantsPerGame=" + semiFinalParticipantsPerGame + ", hasFinal="
				+ hasFinal + ", finalParticipantsPerGame=" + finalParticipantsPerGame + ", maxParticipants="
				+ maxParticipants + ", tournamentDate=" + tournamentDate + ", tournamentCreator=" + tournamentCreator
				+ ", tournamentAdministrators=" + tournamentAdministrators + ", tournametParticipants="
				+ tournamentParticipants + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + finalParticipantsPerGame;
		result = prime * result + (hasFinal ? 1231 : 1237);
		result = prime * result + (hasQuarters ? 1231 : 1237);
		result = prime * result + (hasSemiFinal ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + maxParticipants;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quartersParticipantsPerGame;
		result = prime * result + roundsNumber;
		result = prime * result + semiFinalParticipantsPerGame;
		result = prime * result + ((tournamentAdministrators == null) ? 0 : tournamentAdministrators.hashCode());
		result = prime * result + ((tournamentCreator == null) ? 0 : tournamentCreator.hashCode());
		result = prime * result + ((tournamentDate == null) ? 0 : tournamentDate.hashCode());
		result = prime * result + ((tournamentParticipants == null) ? 0 : tournamentParticipants.hashCode());
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
		Tournament other = (Tournament) obj;
		if (finalParticipantsPerGame != other.finalParticipantsPerGame)
			return false;
		if (hasFinal != other.hasFinal)
			return false;
		if (hasQuarters != other.hasQuarters)
			return false;
		if (hasSemiFinal != other.hasSemiFinal)
			return false;
		if (id != other.id)
			return false;
		if (maxParticipants != other.maxParticipants)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quartersParticipantsPerGame != other.quartersParticipantsPerGame)
			return false;
		if (roundsNumber != other.roundsNumber)
			return false;
		if (semiFinalParticipantsPerGame != other.semiFinalParticipantsPerGame)
			return false;
		if (tournamentAdministrators == null) {
			if (other.tournamentAdministrators != null)
				return false;
		} else if (!tournamentAdministrators.equals(other.tournamentAdministrators))
			return false;
		if (tournamentCreator == null) {
			if (other.tournamentCreator != null)
				return false;
		} else if (!tournamentCreator.equals(other.tournamentCreator))
			return false;
		if (tournamentDate == null) {
			if (other.tournamentDate != null)
				return false;
		} else if (!tournamentDate.equals(other.tournamentDate))
			return false;
		if (tournamentParticipants == null) {
			if (other.tournamentParticipants != null)
				return false;
		} else if (!tournamentParticipants.equals(other.tournamentParticipants))
			return false;
		return true;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	
	

}
