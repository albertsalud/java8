package com.albertsalud.gestortorneos.services.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Game;
import com.albertsalud.gestortorneos.model.repositories.TournamentDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class GetGameService {
	
	@Autowired private TournamentDAO tournamentDao;
	
	public GetGameServiceResultBean getGame(long gameId) {
		GetGameServiceResultBean result = new GetGameServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.game = tournamentDao.getGame(gameId);
			if(result.game == null) throw new Exception ("Unable to find Game by id");
		
		} catch (Exception e) {
			result = new GetGameServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
		
	}
	
	
	public class GetGameServiceResultBean extends GenericServiceResultBean {

		private Game game;

		private GetGameServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}

		public Game getGame() {
			return game;
		}
		
	}

}
