package com.albertsalud.gestortorneos.model.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.entities.Participant;

@Repository
@Transactional
public class ParticipantDAOImpl implements ParticipantDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Participant saveParticipant(Participant participantToSave) {
		return em.merge(participantToSave);
		
	}

	@Override
	public Participant getParticipantById(long participantId) {
		
		return em.find(Participant.class, participantId);
	}

	@Override
	public Participant getParticipantByEmail(String email) {
		Query query = em.createQuery("select p from Participant p where p.email = :email");
		query.setParameter("email", email);
		
		return (Participant) query.getSingleResult();
	}

	@Override
	public Participant login(String email, String password) {
		
		Query query = em.createQuery("select p from Participant p where p.email = :email and p.password = MD5(:password)");
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		return (Participant) query.getSingleResult();
	}

	@Override
	public void saveGameParticipant(GameParticipant gameParticipant) {
		
		em.merge(gameParticipant);
		
	}

}
