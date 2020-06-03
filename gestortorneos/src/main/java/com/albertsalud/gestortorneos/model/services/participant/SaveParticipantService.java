package com.albertsalud.gestortorneos.model.services.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Participant;
import com.albertsalud.gestortorneos.model.repositories.ParticipantDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class SaveParticipantService {
	
	@Autowired private ParticipantDAO participantDao;
	public SaveParticipantServiceResultBean saveParticipant(Participant participantToSave) {
		SaveParticipantServiceResultBean result = new SaveParticipantServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.participant = participantDao.saveParticipant(participantToSave);
		
		} catch (Exception e) {
			result = new SaveParticipantServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
	}
	
	public class SaveParticipantServiceResultBean extends GenericServiceResultBean {

		private Participant participant;

		private SaveParticipantServiceResultBean(boolean ok, String errorMessage) {
			this.ok = ok;
			this.errorMessage = errorMessage;
		}

		public Participant getParticipant() {
			return participant;
		}
		
	}

}
