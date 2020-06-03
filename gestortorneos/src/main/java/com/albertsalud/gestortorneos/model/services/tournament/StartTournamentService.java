package com.albertsalud.gestortorneos.model.services.tournament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.builders.RoundBuilder;
import com.albertsalud.gestortorneos.model.builders.RoundBuilderDirector;
import com.albertsalud.gestortorneos.model.entities.Round;
import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.entities.TournamentParticipant;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService.GetTournamentServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.SaveTournamentService.SaveTournamentServiceResultBean;

@Service
public class StartTournamentService {
	
	@Autowired private GetTournamentService getTournamentService;
	public StartTournamentServiceResultBean startTournament(long tournamentId, List<TournamentParticipant> tournamentParticipants) {
		GetTournamentServiceResultBean getResult = getTournamentService.getTournamentById(tournamentId);
		
		if(!getResult.isOk()) return new StartTournamentServiceResultBean(GenericServiceResultBean.KO, getResult.getErrorMessage());
		
		return this.startTournament(getResult.getTournament(), tournamentParticipants);
	}
	
	
	@Autowired private SaveTournamentService saveTournamentService;
	public StartTournamentServiceResultBean startTournament(Tournament tournament, List<TournamentParticipant> tournamentParticipants) {
		
		StartTournamentServiceResultBean result = new StartTournamentServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			setTournamentStatus(tournament);	// Establece el estado del torneo (ON COMMING -> PLAYING)
			
			tournament.setTournamentParticipants(tournamentParticipants);	// Establece los jugadores confirmados
			
			Round round = createRound(tournament);	// Crea la primera ronda
			tournament.addRound(round);
		
			SaveTournamentServiceResultBean saveResult = saveTournamentService.saveTournament(tournament);	// Almacena el torneo
			if(!saveResult.isOk()) throw new Exception(saveResult.getErrorMessage());
			
			result.tournament = saveResult.getTournament();
			
		} catch (Exception e) {
			result = new StartTournamentServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
		
	}
	
	private Round createRound(Tournament tournament) {
		RoundBuilder rb = new RoundBuilder(tournament);
		RoundBuilderDirector rbd = new RoundBuilderDirector(rb);
		
		rbd.createRound();
		
		return rb.getRound();
	}

	private void setTournamentStatus(Tournament tournament) throws Exception {
		if(tournament.getStatus() != Tournament.STATUS_ON_COMMING) throw new Exception("Unable to start a not on comming tournament");
		tournament.setStatus(Tournament.STATUS_PLAYING);
	}

	public class StartTournamentServiceResultBean extends GenericServiceResultBean {

		private Tournament tournament;

		private StartTournamentServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}

		public Tournament getTournament() {
			return tournament;
		}
		
	}

}
