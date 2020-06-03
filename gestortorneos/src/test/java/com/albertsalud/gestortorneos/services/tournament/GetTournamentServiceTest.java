package com.albertsalud.gestortorneos.services.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService.GetTournamentServiceResultBean;

@SpringBootTest
public class GetTournamentServiceTest {
	
	@Autowired private GetTournamentService getTournamentService;
	
	@Test
	public void getTournamentByIdTest() {
		long requestedId = 1;	// Existing Id
		
		GetTournamentServiceResultBean result = getTournamentService.getTournamentById(requestedId);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isOk());
		Assertions.assertNotNull(result.getTournament());
		Tournament t = result.getTournament();
			
		Assertions.assertEquals(requestedId, t.getId());
			
		System.out.println(t);
	}



}
