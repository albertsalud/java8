package com.albertsalud.gestortorneos.model.services.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;
import com.albertsalud.gestortorneos.model.services.participant.GetParticipantService;
import com.albertsalud.gestortorneos.model.services.participant.GetParticipantService.GetParticipantServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.GetTournamentService.GetTournamentServiceResultBean;
import com.albertsalud.gestortorneos.model.services.tournament.SaveTournamentService.SaveTournamentServiceResultBean;

@Service
public class AddTournamentAdministratorService {
	
	@Autowired private GetParticipantService getParticipantService;
	@Autowired private GetTournamentService getTournamentService;
	@Autowired private SaveTournamentService saveTournamentService;
	
	public AddTournamentAdministratorServiceResultBean addTournametAdministrator(long tournamentId, 
			String email) {
		AddTournamentAdministratorServiceResultBean result = new AddTournamentAdministratorServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			GetParticipantServiceResultBean getParticipantResult = getParticipantService.getParticipantByEmail(email);
			if(!getParticipantResult.isOk()) throw new Exception(getParticipantResult.getErrorMessage());
			
			GetTournamentServiceResultBean getTournamentResult = getTournamentService.getTournamentById(tournamentId);
			if(!getTournamentResult.isOk()) throw new Exception(getTournamentResult.getErrorMessage());
			
			Tournament selectedTournament = getTournamentResult.getTournament();
			if(selectedTournament.getStatus() != Tournament.STATUS_ON_COMMING) throw new Exception("Unable to add administrators on stated tournament");
			selectedTournament.addTournamentAdminitrator(getParticipantResult.getParticipant());
			
			SaveTournamentServiceResultBean saveTournamentResult = saveTournamentService.saveTournament(selectedTournament);
			if(!saveTournamentResult.isOk()) throw new Exception (saveTournamentResult.getErrorMessage());
		
		} catch (Exception e) {
			result = new AddTournamentAdministratorServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		
		}
		return result;
	}
	
	public class AddTournamentAdministratorServiceResultBean extends GenericServiceResultBean {

		private AddTournamentAdministratorServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}
		
	}

}
