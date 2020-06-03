package com.albertsalud.gestortorneos.model.services.gameparticipant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.GameParticipant;
import com.albertsalud.gestortorneos.model.entities.Score;
import com.albertsalud.gestortorneos.model.repositories.ParticipantDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class SaveGameParticipantService {
	
	@Autowired private ParticipantDAO participantDao;
	
	public SaveGameParticipantServiceResultBean saveGameParticipant(GameParticipant gameParticipant, Score score) {
		SaveGameParticipantServiceResultBean result = new SaveGameParticipantServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			gameParticipant.addScore(score);
			participantDao.saveGameParticipant(gameParticipant);
		
		} catch (Exception e) {
			result = new SaveGameParticipantServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
	}
	
	public class SaveGameParticipantServiceResultBean extends GenericServiceResultBean{

		private SaveGameParticipantServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}
		
	}

}
