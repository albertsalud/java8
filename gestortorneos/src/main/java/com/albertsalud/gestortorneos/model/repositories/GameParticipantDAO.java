package com.albertsalud.gestortorneos.model.repositories;

import java.util.List;

import com.albertsalud.gestortorneos.model.entities.GameParticipant;

public interface GameParticipantDAO  {

	public List<GameParticipant> listParticipantByGame(long gameId);

	public List<GameParticipant> listParticipantByParticipant(long participantId);

}
