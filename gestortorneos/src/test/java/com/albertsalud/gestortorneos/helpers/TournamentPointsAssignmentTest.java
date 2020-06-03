package com.albertsalud.gestortorneos.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.entities.CarcassonneScore;
import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.helpers.TournamentPointsAssignment;

@SpringBootTest
public class TournamentPointsAssignmentTest {	
	
	@Test
	public void tournamentPointsAssignmentTest() {
		List<GameParticipant> gp = new ArrayList<GameParticipant>();
		for(int i = 0; i < 4 ; i++) {
			GameParticipant currentGp = new GameParticipant();
			
			CarcassonneScore cs = new CarcassonneScore();
			cs.setVictoryPoints(new Random().nextInt(100));
			
			currentGp.addScore(cs);
			gp.add(currentGp);
		}
		
		TournamentPointsAssignment tpa = new TournamentPointsAssignment(gp);
		
		List<GameParticipant> result = tpa.getGameParticipants();
		Assertions.assertNotNull(result);
		
		System.out.println(result);
		
		
	}

}
