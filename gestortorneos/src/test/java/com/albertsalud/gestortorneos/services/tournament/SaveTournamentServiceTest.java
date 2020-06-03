package com.albertsalud.gestortorneos.services.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.services.participant.GetParticipantService;
import com.albertsalud.gestortorneos.model.services.participant.GetParticipantService.GetParticipantServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.SaveTournamentService;
import com.albertsalud.gestortorneos.model.services.tournament.SaveTournamentService.SaveTournamentServiceResultBean;
import com.albertsalud.gestortorneos.services.helpers.TestObjectsGenerator;

@SpringBootTest
public class SaveTournamentServiceTest {
	
	@Autowired private GetParticipantService getParticipantService;
	@Autowired private SaveTournamentService saveTournamentService;
	@Test
	public void saveTournamentTest() throws Exception {
		
		GetParticipantServiceResultBean getResult = getParticipantService.getParticipantById(1);
		
		Tournament tournamentToSave = TestObjectsGenerator.getTestTournamet();
		tournamentToSave.setTournamentCreator(getResult.getParticipant());
		tournamentToSave.addTournamentAdminitrator(getResult.getParticipant());
		tournamentToSave.addTournamentParticipant(getResult.getParticipant());
		
		SaveTournamentServiceResultBean result = saveTournamentService.saveTournament(tournamentToSave);
		
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isOk());
		Assertions.assertNotNull(result.getTournament());
		Assertions.assertNotNull(result.getTournament().getId());
		
	}

}
