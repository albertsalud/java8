package com.albertsalud.gestortorneos.services.participant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.entities.Participant;
import com.albertsalud.gestortorneos.model.services.participant.GetParticipantService;
import com.albertsalud.gestortorneos.model.services.participant.GetParticipantService.GetParticipantServiceResultBean;

@SpringBootTest
public class GetParticipantServiceTest {
	
	@Autowired private GetParticipantService service;
	@Test
	public void getParticipantByIdTest() throws Exception {
		long requestedId = 1;
		GetParticipantServiceResultBean result = service.getParticipantById(requestedId);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isOk());
		Assertions.assertNotNull(result.getParticipant());
		Participant p = result.getParticipant();
		
		Assertions.assertEquals(requestedId, p.getId());
		
		System.out.println(p);
		
	}
	

	@Test
	public void getParticipantByEmailTest() throws Exception {
		String requestedEmail = "email1@gmail.com";
		GetParticipantServiceResultBean result = service.getParticipantByEmail(requestedEmail);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isOk());
		
		Assertions.assertNotNull(result.getParticipant());
		Participant p = result.getParticipant();
		
		Assertions.assertEquals(requestedEmail, p.getEmail());
		
		System.out.println(p);
		
	}
	
	@Test
	public void loginTest() {
		String requestedEmail = "email1@gmail.com";
		String password = "test1";
		GetParticipantServiceResultBean result = service.login(requestedEmail, password);
		Assertions.assertNotNull(result);
		Assertions.assertTrue(result.isOk());
		Assertions.assertNotNull(result.getParticipant());
		Participant p = result.getParticipant();
		
		Assertions.assertEquals(requestedEmail, p.getEmail());
		
		System.out.println(p);
		
	}

}
