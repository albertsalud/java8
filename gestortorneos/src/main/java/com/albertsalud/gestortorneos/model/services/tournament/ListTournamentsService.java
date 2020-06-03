package com.albertsalud.gestortorneos.model.services.tournament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Tournament;
import com.albertsalud.gestortorneos.model.repositories.TournamentDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class ListTournamentsService {
	
	@Autowired private TournamentDAO tournamentDao;
	
	public ListTournamentsServiceResultBean listTournaments() {
		ListTournamentsServiceResultBean result = new ListTournamentsServiceResultBean(GenericServiceResultBean.OK, null);
		
		result.tournaments = tournamentDao.listTournaments();
		
		return result;
	}

	public class ListTournamentsServiceResultBean extends GenericServiceResultBean {

		private ListTournamentsServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}

		private List<Tournament> tournaments;

		public List<Tournament> getTournaments() {
			return tournaments;
		}
		
	}
}
