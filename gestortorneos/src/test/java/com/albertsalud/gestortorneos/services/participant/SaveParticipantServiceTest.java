package com.albertsalud.gestortorneos.services.participant;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.albertsalud.gestortorneos.model.entities.Participant;
import com.albertsalud.gestortorneos.model.services.participant.SaveParticipantService;
import com.albertsalud.gestortorneos.model.services.participant.SaveParticipantService.SaveParticipantServiceResultBean;
import com.albertsalud.gestortorneos.services.helpers.TestObjectsGenerator;

@SpringBootTest
public class SaveParticipantServiceTest {
	
	@Autowired private SaveParticipantService service;
	
	@Test
	public void saveParticipant() {
		
		Participant participant = TestObjectsGenerator.getTestParticipant();
		
		SaveParticipantServiceResultBean result = service.saveParticipant(participant);
		assertNotNull(result);
		if(result.isOk()) {
			assertNotNull(result.getParticipant());
			assertNotNull(result.getParticipant().getId());
		} else {
			assertNotNull(result.getErrorMessage());
			System.out.println(result.getErrorMessage());
		}
		
		
		
	}

}
