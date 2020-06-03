package com.albertsalud.gestortorneos.model.helpers;

import java.util.Comparator;

import com.albertsalud.gestortorneos.model.entities.CarcassonneScore;
import com.albertsalud.gestortorneos.model.entities.CatanScore;
import com.albertsalud.gestortorneos.model.entities.Score;

public abstract class ScoreComparatorFactory {

	public static Comparator<? super Score> getComparator(Score score) {
		
		if(score instanceof CarcassonneScore) return new CarcassonneScoreComparator();
		else if(score instanceof CatanScore) return new CatanScoreComparator();
		
		return null;
	}

}
