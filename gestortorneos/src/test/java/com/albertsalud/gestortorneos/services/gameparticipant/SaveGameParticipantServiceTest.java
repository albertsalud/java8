package com.albertsalud.gestortorneos.services.gameparticipant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.entities.CarcassonneScore;
import com.albertsalud.gestortorneos.model.entities.CatanScore;
import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.entities.Score;
import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.services.gameparticipant.ListGameParticipantService;
import com.albertsalud.gestortorneos.model.services.gameparticipant.ListGameParticipantService.ListGameParticipantServiceResultBean;
import com.albertsalud.gestortorneos.model.services.gameparticipant.SaveGameParticipantService;
import com.albertsalud.gestortorneos.model.services.gameparticipant.SaveGameParticipantService.SaveGameParticipantServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService.GetTournamentServiceResultBean;

@SpringBootTest
public class SaveGameParticipantServiceTest {
	
	@Autowired private SaveGameParticipantService saveGameParticipantService;
	
	@Test
	public void saveGameParticipantTest() throws Exception {
		
		Tournament t = getStartedTournament();
		
		Score score = createGameScore(t);
		score.setVictoryPoints(87);
		
		GameParticipant gameParticipant = getExistingGameParticipant(t);
		
		SaveGameParticipantServiceResultBean result = saveGameParticipantService.saveGameParticipant(gameParticipant, score);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isOk());
		
		
	}

	@Autowired private ListGameParticipantService listGameParticipantService;
	private GameParticipant getExistingGameParticipant(Tournament t) throws Exception {
		ListGameParticipantServiceResultBean getResult = 
				listGameParticipantService.listGameParticipantByGame(t.getRounds().get(0).getGames().get(0));
		if(!getResult.isOk()) throw new Exception(getResult.getErrorMessage());
		
		return getResult.getGameParticipantList().get(0);
	}

	private Score createGameScore(Tournament t) {
		switch(t.getTournamentType()) {
			case Tournament.TYPE_CARCASSONNE: return new CarcassonneScore();
			default: return new CatanScore();
		}
	}

	@Autowired private GetTournamentService getTournamentService;
	private Tournament getStartedTournament() throws Exception {
		long startedTournamentId = 3;
		GetTournamentServiceResultBean getResult = getTournamentService.getTournamentById(startedTournamentId);
		if(!getResult.isOk()) throw new Exception(getResult.getErrorMessage());
		
		return getResult.getTournament();
	}

}
