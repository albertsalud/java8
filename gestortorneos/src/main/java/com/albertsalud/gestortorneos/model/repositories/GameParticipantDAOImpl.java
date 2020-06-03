package com.albertsalud.gestortorneos.model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.albertsalud.gestortorneos.model.entities.GameParticipant;

@Repository
@Transactional
public class GameParticipantDAOImpl implements GameParticipantDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<GameParticipant> listParticipantByGame(long gameId) {
		
		Query query = em.createQuery("select gp from GameParticipant gp where gp.game.id = :gameId");
		query.setParameter("gameId", gameId);
		
		List<GameParticipant> gameParticipantToReturn = (List<GameParticipant>) query.getResultList();
		
		return gameParticipantToReturn;
	}

	@Override
	public List<GameParticipant> listParticipantByParticipant(long participantId) {
		
		Query query = em.createQuery(
				"select gp from GameParticipant gp where gp.game.finalized = false "
				+ "and gp.participant.id = :participantId");
		query.setParameter("participantId", participantId);
		
		List<GameParticipant> gameParticipantToReturn = (List<GameParticipant>) query.getResultList();
		
		return gameParticipantToReturn;
	}

}
