package com.albertsalud.gestortorneos.model.builders;

import java.util.ArrayList;
import java.util.List;

import com.albertsalud.gestortorneos.model.entities.Game;
import com.albertsalud.gestortorneos.model.entities.Round;
import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.entities.TournamentParticipant;

public class RoundBuilder {
	
	private Tournament tournament;
	private Round round;
	
	public Round getRound() {
		return round;
	}
	
	public RoundBuilder(Tournament tournament) {
		this.tournament = tournament;
	}
	
	public void createRound() {
		this.round = new Round();
		this.round.setName(createRoundName());
		this.round.setRoundNumber(this.tournament.getRounds().size() + 1);
	}

	private String createRoundName() {
		if(tournament.getRounds().size() < tournament.getRoundsNumber()) return "Ronda " + (tournament.getRounds().size() + 1);
		
		if(tournament.isHasQuarters()) return "Octavos de final";
		if(tournament.isHasSemiFinal()) return "Semifinal";
		if(tournament.isHasFinal()) return "Final";
		
		return "Error";
	}
	
	public void createGames() {
		List<TournamentParticipant> sortedParticipants = getSortedParticipants();
		
		int currentGameNumber = 1;
		while(!sortedParticipants.isEmpty()) {
			currentGameNumber = createGame(sortedParticipants, currentGameNumber);
		}
		
	}

	private int createGame(List<TournamentParticipant> sortedParticipants, int currentGameNumber) {
		int participantsPerGame = getParticipantsPerGame(sortedParticipants);
		
		Game newGame = new Game();
		newGame.setGameNumber(currentGameNumber);
		
		System.out.println("remaining Participants[" + sortedParticipants.size() + "]: participantsPerGame:[" + participantsPerGame + "]");
		for(int i=0;i<participantsPerGame;i++) {
			newGame.addParticipant(sortedParticipants.remove(0).getParticipant());
		}
		this.round.addGame(newGame);
		
		currentGameNumber++;
		return currentGameNumber;
	}

	private int getParticipantsPerGame(List<TournamentParticipant> sortedParticipants) {
		
		return (sortedParticipants.size() - 4) >= 6 ||	// Si cogiendo 4 jugadores quedan más de 6 en la lista
				(sortedParticipants.size() - 4) ==  4 ||  // o si cogiendo 4 jugadores, aún quedan 4 jugadores
						(sortedParticipants.size() - 4) ==  3 ||
								(sortedParticipants.size() - 4) ==  0 ? 4 : 3; // o si cogiendo 4 jugadores, aún quedan 3 jugadores -> devuelve 4, sino devuelve 3
	}

	private List<TournamentParticipant> getSortedParticipants() {
		// TODO Generar una estrategia de ordenación en función de ronda y cantidad de participantes en cada ronda
		return new ArrayList<>(tournament.getTournamentParticipants());
	}
	
}
