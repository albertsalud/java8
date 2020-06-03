package com.albertsalud.gestortorneos.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int gameNumber;
	
	private boolean finalized;
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<GameParticipant> participants;
	
	@ManyToOne
	@JoinColumn(name = "roundId")
	private Round round;
	
	public void setRound(Round round) {
		this.round = round;
	}
	
	public Round getRound() {
		return round;
	}
	
	public Game() {
		participants = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public boolean isFinalized() {
		return finalized;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}
	
	public List<GameParticipant> getParticipants(){
		return this.participants;
	}
	
	public void addParticipant(Participant p) {
		GameParticipant gp = new GameParticipant();
		gp.setParticipant(p);
		gp.setGame(this);
		
		this.participants.add(gp);
	}
	
	public void setParticipants(List<GameParticipant> gameParticipants) {
		this.participants = gameParticipants;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", gameNumber=" + gameNumber + ", finalized=" + finalized + "]";
	}

	
	
}
