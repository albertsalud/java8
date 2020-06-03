package com.albertsalud.gestortorneos.model.services.tournament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Game;
import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.helpers.TournamentPointsAssignment;
import com.albertsalud.gestortorneos.model.repositories.TournamentDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class ValidateGameService {
	
	@Autowired private TournamentDAO tournamentDao;
	
	public ValidateGameServiceResultBean validateGame(Game game, List<GameParticipant> gameParticipants) {
		
		ValidateGameServiceResultBean result = new ValidateGameServiceResultBean(GenericServiceResultBean.OK, null);
		
		game.getParticipants().forEach(gp -> {
			for(GameParticipant currentGame : gameParticipants) {
				if(currentGame.equals(gp)) {
					gp.addScore(currentGame.getScore());
					break;
				}
			}
		});
		game.setFinalized(true);
		
		try {
			TournamentPointsAssignment tpa = new TournamentPointsAssignment(gameParticipants);
			game.setParticipants(tpa.getGameParticipants());
			
			tournamentDao.validateGame(game);
		
		} catch (Exception e) {
			result = new ValidateGameServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
		
	}
	
	public class ValidateGameServiceResultBean extends GenericServiceResultBean {

		private ValidateGameServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}
		
	}

}
