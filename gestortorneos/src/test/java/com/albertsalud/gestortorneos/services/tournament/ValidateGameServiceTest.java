package com.albertsalud.gestortorneos.services.tournament;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.entities.CarcassonneScore;
import com.albertsalud.gestortorneos.model.entities.Game;
import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.services.tournament.ValidateGameService;
import com.albertsalud.gestortorneos.model.services.tournament.ValidateGameService.ValidateGameServiceResultBean;
import com.albertsalud.gestortorneos.services.tournament.GetGameService.GetGameServiceResultBean;

@SpringBootTest
public class ValidateGameServiceTest {
	
	@Autowired private ValidateGameService service;
	@Test
	public void validateGameTest() throws Exception {
		
		Game game = getExistingGame();
		
		for(GameParticipant currentGameParticipant : game.getParticipants()) {
			CarcassonneScore score = new CarcassonneScore();
			score.setVictoryPoints(new Random().nextInt(90));
			score.setValidated(true);
			
			currentGameParticipant.addScore(score);
		}
		
		ValidateGameServiceResultBean result = service.validateGame(game, game.getParticipants());
		
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isOk());
		
	}

	@Autowired private GetGameService getGameService;
	private Game getExistingGame() throws Exception {
		long existingGameId = 1;
		GetGameServiceResultBean getResult = getGameService.getGame(existingGameId);
		if(!getResult.isOk()) throw new Exception(getResult.getErrorMessage());
		
		return getResult.getGame();
	}

}
