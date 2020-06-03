package com.albertsalud.gestortorneos.model.helpers;

import java.util.Comparator;

import com.albertsalud.gestortorneos.model.entities.CarcassonneScore;
import com.albertsalud.gestortorneos.model.entities.Score;

public class CarcassonneScoreComparator implements Comparator<Score> {

	@Override
	public int compare(Score o1, Score o2) {
		CarcassonneScore cs1 = (CarcassonneScore) o1;
		CarcassonneScore cs2 = (CarcassonneScore) o2;
		
		if(cs1.getVictoryPoints() > cs2.getVictoryPoints()) return -1;
		if(cs2.getVictoryPoints() > cs1.getVictoryPoints()) return 1;
		
		return 0;
	}

}
