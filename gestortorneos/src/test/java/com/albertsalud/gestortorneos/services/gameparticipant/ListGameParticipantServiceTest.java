package com.albertsalud.gestortorneos.services.gameparticipant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.services.gameparticipant.ListGameParticipantService;
import com.albertsalud.gestortorneos.model.services.gameparticipant.ListGameParticipantService.ListGameParticipantServiceResultBean;

@SpringBootTest
public class ListGameParticipantServiceTest {
	
	@Autowired private ListGameParticipantService service;
	
	@Test
	public void listGameParticipantByGameTest() throws Exception {
		
		long gameId = -1;	// Unexisting gameparticipant
		ListGameParticipantServiceResultBean result = service.listGameParticipantByGame(gameId);
		
		Assertions.assertNotNull(result);
		printResult(result);
		
		long existingGame = 1;
		result = service.listGameParticipantByGame(existingGame);
		
		Assertions.assertNotNull(result);
		printResult(result);
		
	}
	
	private void printResult(ListGameParticipantServiceResultBean result) {
		if(result.isOk()) {
			Assertions.assertNotNull(result.getGameParticipantList());
			
			System.out.println(result.getGameParticipantList());
		
		} else {
			Assertions.assertNotNull(result.getErrorMessage());
			System.out.println(result.getErrorMessage());
		}
		
	}

	@Test
	public void listGameParticipantByParticipantTest() throws Exception {
		
		long participantId = -1;	// Unexisting gameparticipant
		ListGameParticipantServiceResultBean result = service.listGameParticipantByParticipant(participantId);
		
		Assertions.assertNotNull(result);
		printResult(result);
		
		long existingParticipant = 2;
		result = service.listGameParticipantByParticipant(existingParticipant);
		
		Assertions.assertNotNull(result);
		printResult(result);
	}
	
	

}
