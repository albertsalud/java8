package com.albertsalud.gestortorneos.services.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.services.tournament.ListTournamentsService;
import com.albertsalud.gestortorneos.model.services.tournament.ListTournamentsService.ListTournamentsServiceResultBean;

@SpringBootTest
public class ListTournamentsServiceTest {
	
	@Autowired private ListTournamentsService service;
	@Test
	public void listTournamentTest() {
		ListTournamentsServiceResultBean result = service.listTournaments();
		Assertions.assertNotNull(result);
		
		if(result.isOk()) {
			Assertions.assertNotNull(result.getTournaments());
			System.out.println("Tournaments: " + result.getTournaments().size());
		} else {
			Assertions.assertNotNull(result.getErrorMessage());
			System.out.println("Error: " + result.getErrorMessage());
		}
	}

}
