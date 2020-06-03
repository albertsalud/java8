package com.albertsalud.gestortorneos.model.services.participant;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Participant;
import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;
import com.albertsalud.gestortorneos.model.services.participant.GetParticipantService.GetParticipantServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService.GetTournamentServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.SaveTournamentService;
import com.albertsalud.gestortorneos.model.services.tournament.SaveTournamentService.SaveTournamentServiceResultBean;

@Service
@Transactional
public class TournamentRegistryService {
	
//	public TournamentRegistryServiceResultBean tournamentRegistry(Participant participant, long tournamentId) {
//		try {
//			Tournament tournament = getTournament(tournamentId);
//			
//			return this.tournamentRegistry(participant, tournament);
//		
//		} catch (Exception e) {
//			return new TournamentRegistryServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
//		}
//	}
	
//	public TournamentRegistryServiceResultBean tournamentRegistry(long participantId, Tournament tournament) {
//		try {
//			Participant participant = getParticipant(participantId);
//			
//			return this.tournamentRegistry(participant, tournament);
//		
//		} catch (Exception e) {
//			return new TournamentRegistryServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
//		}
//	}
	
	public TournamentRegistryServiceResultBean tournamentRegistry(long participantId, long tournamentId) {
		try {
			Participant participant = getParticipant(participantId);
			Tournament tournament = getTournament(tournamentId);
			
			return this.tournamentRegistry(participant, tournament);
		
		} catch (Exception e) {
			return new TournamentRegistryServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
	}
	
	@Autowired private GetTournamentService getTournamentService;
	private Tournament getTournament(long tournamentId) throws Exception {
		
		GetTournamentServiceResultBean getTournamentResult = getTournamentService.getTournamentById(tournamentId);
		if(!getTournamentResult.isOk()) throw new Exception(getTournamentResult.getErrorMessage());
		
		return getTournamentResult.getTournament();
	}

	@Autowired private GetParticipantService getParticipantService;
	private Participant getParticipant(long participantId) throws Exception {
		
		GetParticipantServiceResultBean getParticipantResult = getParticipantService.getParticipantById(participantId);
		if(!getParticipantResult.isOk()) throw new Exception(getParticipantResult.getErrorMessage());
		
		return getParticipantResult.getParticipant();
	}

	@Autowired private SaveTournamentService saveTournamentService;
	private TournamentRegistryServiceResultBean tournamentRegistry(Participant participant, Tournament tournament) {
		TournamentRegistryServiceResultBean result = new TournamentRegistryServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			if(tournament.getStatus() != Tournament.STATUS_ON_COMMING) throw new Exception("Unable to add participants on started tournament");
			
			tournament.addTournamentParticipant(participant);
			SaveTournamentServiceResultBean saveResult = saveTournamentService.saveTournament(tournament);
		
			if(!saveResult.isOk()) throw new Exception(saveResult.getErrorMessage());
		
		} catch (Exception e) {
			result = new TournamentRegistryServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
	}
	
	public class TournamentRegistryServiceResultBean extends GenericServiceResultBean {

		private TournamentRegistryServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}
		
	}

}
