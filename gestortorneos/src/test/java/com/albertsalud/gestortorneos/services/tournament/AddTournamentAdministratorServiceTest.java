package com.albertsalud.gestortorneos.services.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.services.tournament.AddTournamentAdministratorService;
import com.albertsalud.gestortorneos.model.services.tournament.AddTournamentAdministratorService.AddTournamentAdministratorServiceResultBean;

@SpringBootTest
public class AddTournamentAdministratorServiceTest {
	
	@Autowired private AddTournamentAdministratorService addTournamentAdministratorService;
	
	@Test
	public void addTournamentAdministratorServiceTest() {
		long tournamentId = -1;
		String email = "unexisting email";
		AddTournamentAdministratorServiceResultBean addAdministratorResult = 
				addTournamentAdministratorService.addTournametAdministrator(tournamentId, email);
		Assertions.assertNotNull(addAdministratorResult);
		Assertions.assertFalse(addAdministratorResult.isOk());
		
		System.out.println(addAdministratorResult.getErrorMessage());
	}

}
