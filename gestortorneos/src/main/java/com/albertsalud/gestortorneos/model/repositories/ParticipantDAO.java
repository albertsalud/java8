package com.albertsalud.gestortorneos.model.repositories;

import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.entities.Participant;

public interface ParticipantDAO {

	public Participant saveParticipant(Participant participantToSave);

	public Participant getParticipantById(long participantId);

	public Participant getParticipantByEmail(String email);

	public Participant login(String email, String password);

	public void saveGameParticipant(GameParticipant gameParticipant);
	

}
