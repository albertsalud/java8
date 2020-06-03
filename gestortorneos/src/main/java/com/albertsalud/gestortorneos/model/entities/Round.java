package com.albertsalud.gestortorneos.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Round {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private boolean finalized;
	
	@Column(nullable = false, length = 15)
	private String name;
	
	private int roundNumber;
	
	@OneToMany(mappedBy = "round", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Game> games;
	
	@ManyToOne
	@JoinColumn(name = "tournamentId")
	private Tournament tournament;
	
	public void setTournament(Tournament t) {
		this.tournament = t;
	}
	
	public Round() {
		games = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isFinalized() {
		return finalized;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	
	public void addGame(Game g) {
		this.games.add(g);
		g.setRound(this);
	}
	
	public List<Game> getGames(){
		return this.games;
	}

	@Override
	public String toString() {
		return "Round [id=" + id + ", finalized=" + finalized + ", name=" + name + ", roundNumber=" + roundNumber
				+ ", games=" + games + "]";
	}
	
	
	
}
