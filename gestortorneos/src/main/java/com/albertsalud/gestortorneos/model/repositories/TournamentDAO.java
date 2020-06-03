package com.albertsalud.gestortorneos.model.repositories;

import java.util.List;

import com.albertsalud.gestortorneos.model.entities.Game;
import com.albertsalud.gestortorneos.model.entities.Tournament;

public interface TournamentDAO {

	public Tournament saveTournament(Tournament tournamentToSave);

	public Tournament getTournamentById(long tournamentId);

	public void validateGame(Game game);

	public Game getGame(long gameId);

	public List<Tournament> listTournaments();

}
