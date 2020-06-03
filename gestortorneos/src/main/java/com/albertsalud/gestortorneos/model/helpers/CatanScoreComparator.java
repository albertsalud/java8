package com.albertsalud.gestortorneos.model.helpers;

import java.util.Comparator;

import com.albertsalud.gestortorneos.model.entities.CatanScore;
import com.albertsalud.gestortorneos.model.entities.Score;

public class CatanScoreComparator implements Comparator<Score> {

	@Override
	public int compare(Score score1, Score score2) {
		CatanScore cs1 = (CatanScore) score1;
		CatanScore cs2 = (CatanScore) score2;
		
		if(cs1.getVictoryPoints() > cs2.getVictoryPoints()) return -1;
		if(cs1.getVictoryPoints() < cs2.getVictoryPoints()) return 1;
		
		int cs1BooleanValues = (cs1.isCavalryArmy() ? 1 : 0) + (cs1.isGreatTradeRoute() ? 1 : 0);
		int cs2BooleanValues = (cs2.isCavalryArmy() ? 1 : 0) + (cs2.isGreatTradeRoute() ? 1 : 0);
		
		if(cs1BooleanValues > cs2BooleanValues) return -1;
		if(cs1BooleanValues < cs2BooleanValues) return 1;
		
		if(cs1.getCitiesNumber() > cs2.getCitiesNumber()) return -1;
		if(cs1.getCitiesNumber() < cs2.getCitiesNumber()) return 1;
		
		if(cs1.getVillagesNumber() > cs2.getVillagesNumber()) return -1;
		if(cs1.getVillagesNumber() < cs2.getVillagesNumber()) return 1;
		
		if(cs1.getRoadsNumber() > cs2.getRoadsNumber()) return -1;
		if(cs1.getRoadsNumber() < cs2.getRoadsNumber()) return 1;
		
		return 0;
	}

}
