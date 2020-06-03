package com.albertsalud.gestortorneos.model.services.gameparticipant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Game;
import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.repositories.GameParticipantDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class ListGameParticipantService {
	
	public ListGameParticipantServiceResultBean listGameParticipantByGame(Game game) {
		return this.listGameParticipantByGame(game.getId());
	}
	
	@Autowired private GameParticipantDAO gameParticipantDao;
	public ListGameParticipantServiceResultBean listGameParticipantByGame(long gameId) {
		ListGameParticipantServiceResultBean result = new ListGameParticipantServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.gameParticipantList = gameParticipantDao.listParticipantByGame(gameId);
			if(result.gameParticipantList == null || result.getGameParticipantList().isEmpty()) throw new Exception("Unable to get gameParticipant list by gameId");
		
		} catch (Exception e) {
			result = new ListGameParticipantServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		return result;
		
	}
	
	public ListGameParticipantServiceResultBean listGameParticipantByParticipant(long participantId) {
		ListGameParticipantServiceResultBean result = new ListGameParticipantServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.gameParticipantList = gameParticipantDao.listParticipantByParticipant(participantId);
			if(result.gameParticipantList == null || result.getGameParticipantList().isEmpty()) throw new Exception("Unable to get gameParticipant list by participantId");
		
		} catch (Exception e) {
			result = new ListGameParticipantServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		return result;
	}
	
	public class ListGameParticipantServiceResultBean extends GenericServiceResultBean {

		private ListGameParticipantServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}

		public List<GameParticipant> getGameParticipantList() {
			return gameParticipantList;
		}

		private List<GameParticipant> gameParticipantList;
		
	}

}
