package com.albertsalud.gestortorneos.model.services.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.repositories.TournamentDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class SaveTournamentService {
	
	@Autowired private TournamentDAO tournamentDao;
	public SaveTournamentServiceResultBean saveTournament(Tournament tournamentToSave) {
		
		SaveTournamentServiceResultBean result = new SaveTournamentServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.tournament = tournamentDao.saveTournament(tournamentToSave);
		
		} catch (Exception e) {
			result = new SaveTournamentServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
		
	}
	
	public class SaveTournamentServiceResultBean extends GenericServiceResultBean {

		private Tournament tournament;

		private SaveTournamentServiceResultBean(boolean ok, String errorMessage) {
			this.ok = ok;
			this.errorMessage = errorMessage;
		}

		public Tournament getTournament() {
			return tournament;
		}
		
	}
	

}
