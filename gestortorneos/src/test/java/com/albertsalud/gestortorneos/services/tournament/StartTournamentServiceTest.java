package com.albertsalud.gestortorneos.services.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService.GetTournamentServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.StartTournamentService;
import com.albertsalud.gestortorneos.model.services.tournament.StartTournamentService.StartTournamentServiceResultBean;

@SpringBootTest
public class StartTournamentServiceTest {
	
	@Autowired private StartTournamentService startTournamentService;
	
	@Autowired private GetTournamentService getTournamentService;
	@Test
	public void startTournamentTest() {
		
		GetTournamentServiceResultBean getResult = getTournamentService.getTournamentById(1);
		
		Tournament tournament = getResult.getTournament();
		tournament.getTournamentParticipants().forEach(tp -> tp.setConfirmed(true)); // Confirma los participantes al torneo
		
		
		StartTournamentServiceResultBean startResult = startTournamentService.startTournament(tournament, tournament.getTournamentParticipants());
		
		Assertions.assertNotNull(startResult);
		Assertions.assertTrue(startResult.isOk());
		Assertions.assertNotNull(startResult.getTournament());
		
		Assertions.assertNotNull(startResult.getTournament().getRounds());
		Assertions.assertEquals(Tournament.STATUS_PLAYING, startResult.getTournament().getStatus());
		System.out.println(startResult.getTournament().getRounds());
		
	}

}
