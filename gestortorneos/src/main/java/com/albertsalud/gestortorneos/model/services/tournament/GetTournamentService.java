package com.albertsalud.gestortorneos.model.services.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.repositories.TournamentDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class GetTournamentService {
	
	@Autowired private TournamentDAO tournamentDao;
	
	public GetTournamentServiceResultBean getTournamentById(long tournamentId) {
		
		GetTournamentServiceResultBean result = new GetTournamentServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.tournament = tournamentDao.getTournamentById(tournamentId);
			if(result.tournament == null) throw new Exception("Unable to find tournament by Id");
		
		} catch (Exception e) {
			result = new GetTournamentServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
			
		}
		return result;
		
	}
	
	public class GetTournamentServiceResultBean extends GenericServiceResultBean{

		private GetTournamentServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}

		public Tournament getTournament() {
			return tournament;
		}

		private Tournament tournament;
		
	}

}
