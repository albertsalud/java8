package com.albertsalud.gestortorneos.model.services.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.gestortorneos.model.entities.Participant;
import com.albertsalud.gestortorneos.model.repositories.ParticipantDAO;
import com.albertsalud.gestortorneos.model.services.GenericServiceResultBean;

@Service
public class GetParticipantService {
	
	@Autowired private ParticipantDAO participantDao;
	
	public GetParticipantServiceResultBean login(String email, String password) {
		GetParticipantServiceResultBean result = new GetParticipantServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.participant = participantDao.login(email, password);
			if(result.participant == null) throw new Exception("Invalid credentials");
		
		} catch (Exception e) {
			result = new GetParticipantServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
	}
	
	public GetParticipantServiceResultBean getParticipantById(long participantId) {
		
		GetParticipantServiceResultBean result = new GetParticipantServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.participant = participantDao.getParticipantById(participantId);
			if(result.participant == null) throw new Exception("Unable to find Participant by Id");
		
		} catch (Exception e) {
			result = new GetParticipantServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
		
	}
	
	public GetParticipantServiceResultBean getParticipantByEmail(String email) {
		
		GetParticipantServiceResultBean result = new GetParticipantServiceResultBean(GenericServiceResultBean.OK, null);
		
		try {
			result.participant = participantDao.getParticipantByEmail(email);
			if(result.participant == null) throw new Exception("Unable to find Participant by email");
		
		} catch (Exception e) {
			result = new GetParticipantServiceResultBean(GenericServiceResultBean.KO, e.getMessage());
		}
		
		return result;
		
	}
	
	public class GetParticipantServiceResultBean extends GenericServiceResultBean {

		private Participant participant;

		private GetParticipantServiceResultBean(boolean ok, String message) {
			this.ok = ok;
			this.errorMessage = message;
		}

		public Participant getParticipant() {
			return participant;
		}
		
	}

}
