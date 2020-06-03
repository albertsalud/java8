package com.albertsalud.gestortorneos.services.helpers;

import java.util.Calendar;

import com.albertsalud.gestortorneos.model.entities.Participant;
import com.albertsalud.gestortorneos.model.entities.Tournament;

public class TestObjectsGenerator {
	
	private static Participant testParticipant;
	private static Tournament testTournament;

	
	public static Participant getTestParticipant() {
		if(testParticipant == null) {
			testParticipant = new Participant();
			
			testParticipant.setEmail("albertsalud@gmail.com");
			testParticipant.setEnabledToCreateTournaments(true);
			testParticipant.setName("Albert Salud");
			testParticipant.setPassword("1234");
			
		}
		return testParticipant;
	}
	
	public static Tournament getTestTournamet() {
		if(testTournament == null) {
			testTournament = new Tournament();
			
			testTournament.setMaxParticipants(15);
			testTournament.setName("Torneo de prueba");
			testTournament.setRoundsNumber(3);
			testTournament.setTournamentDate(Calendar.getInstance().getTime());
			testTournament.setTournamentType(Tournament.TYPE_CARCASSONNE);
			
		}
		return testTournament;
	}


}
