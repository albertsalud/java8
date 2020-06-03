package com.albertsalud.gestortorneos.services.participant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.services.participant.TournamentRegistryService;
import com.albertsalud.gestortorneos.model.services.participant.TournamentRegistryService.TournamentRegistryServiceResultBean;

@SpringBootTest
public class TournamentRegistryServiceTest {
	
	@Autowired private TournamentRegistryService tournamentRegistryService;
	
	@Test
	public void tournamentRegistryTest() throws Exception {
		long participant = 1;
		long tournament = 1;
		
		TournamentRegistryServiceResultBean result =
				tournamentRegistryService.tournamentRegistry(participant, tournament);
		Assertions.assertNotNull(result);
		if(!result.isOk()) {
			Assertions.assertNotNull(result.getErrorMessage());
			System.out.println(result.getErrorMessage());
		}
		
		
	}
	
}
