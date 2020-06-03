package com.albertsalud.gestortorneos.model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.albertsalud.gestortorneos.model.entities.Game;
import com.albertsalud.gestortorneos.model.entities.Round;
import com.albertsalud.gestortorneos.model.entities.Tournament;

@Repository
public class TournamentDAOImpl implements TournamentDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Tournament saveTournament(Tournament tournamentToSave) {
		
		return em.merge(tournamentToSave);
	}

	@Override
	public Tournament getTournamentById(long tournamentId) {
		
		return em.find(Tournament.class, tournamentId);
	}

	@Override
	@Transactional
	public void validateGame(Game game) {
		
		em.merge(game);
		checkFinalizedRound(game);
		
	}

	private void checkFinalizedRound(Game game) {
		Round round = game.getRound();
		
		boolean finalized = true;
		for(Game currentGame : round.getGames()) {
			if(!currentGame.isFinalized()) finalized = false;
		}
		
		if(finalized) {
			round.setFinalized(true);
			em.merge(round);
		}
		
	}

	@Override
	public Game getGame(long gameId) {
		
		return em.find(Game.class, gameId);
	}

	@Override
	public List<Tournament> listTournaments() {
		
		return em.createQuery("from Tournament").getResultList();
	}

}
