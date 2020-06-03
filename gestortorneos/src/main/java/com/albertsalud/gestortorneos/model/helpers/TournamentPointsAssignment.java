package com.albertsalud.gestortorneos.model.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.entities.Score;

public class TournamentPointsAssignment {
	
	private List<GameParticipant> gameParticipants;
	private Comparator<? super Score> scoreComparator;
	private Map<Integer, List<Integer>> puntuations;
	
	public TournamentPointsAssignment(List<GameParticipant> gameParticipants) {
		this.gameParticipants = gameParticipants;
		
		initPuntuations();
		
		startTournamentPointsAssignment();
	}

	private void initPuntuations() {
		List<Integer> fourPlayersPuntuations = Arrays.asList(5, 3, 2, 1);
		List<Integer> threePlayersPuntuations = Arrays.asList(5, 3, 1);
		List<Integer> twoPlayersPuntuations = Arrays.asList(5, 3, 1);
		
		puntuations = new HashMap<>();
		puntuations.put(4, fourPlayersPuntuations);
		puntuations.put(3, threePlayersPuntuations);
		puntuations.put(2, twoPlayersPuntuations);
	}

	private void startTournamentPointsAssignment() {
		List<Score> sortedGameScores = sortScoreList();
		
		distributeGamePoints(sortedGameScores);
		
	}

	private void distributeGamePoints(List<Score> sortedGameScores) {
		List<Integer> puntuationsList = this.puntuations.get(sortedGameScores.size());
		int acumulatedPoints = 0;
		int acumulatedPlayers = 0;
		
		for(int i = 0; i < puntuationsList.size() ; i++) {
			acumulatedPoints += puntuationsList.get(i);
			acumulatedPlayers += 1;
			
			if(i <= puntuationsList.size() - 2 && 
					scoreComparator.compare(sortedGameScores.get(i), sortedGameScores.get(i + 1)) == -1) {
				assignPoints(sortedGameScores, acumulatedPoints, acumulatedPlayers);
			
				acumulatedPlayers = 0;
				acumulatedPoints = 0;
			}
			
		}
		
		assignPoints(sortedGameScores, acumulatedPoints, acumulatedPlayers);
		
	}

	private void assignPoints(List<Score> sortedGameScores, int acumulatedPoints, int acumulatedPlayers) {
		
		int remainingScoresToSet = acumulatedPlayers;
		for(Score currentScore : sortedGameScores) {
			if(currentScore.getTournamentPoints() != 0) continue;
			
			currentScore.setTournamentPoints(acumulatedPoints / acumulatedPlayers);
			remainingScoresToSet--;
			
			if(remainingScoresToSet == 0) break;
			
		}
		
	}

	private List<Score> sortScoreList() {
		List<Score> gameScores = new ArrayList<>();
		Score sampleScore = null;
		for(GameParticipant gp : gameParticipants) {
			gameScores.add(gp.getScore());
			
			sampleScore = gp.getScore();
		}
		
		scoreComparator = ScoreComparatorFactory.getComparator(sampleScore);
		gameScores.sort(scoreComparator);
		
		return gameScores;
	}
	
	public List<GameParticipant> getGameParticipants() {
		return this.gameParticipants;
	}

}
