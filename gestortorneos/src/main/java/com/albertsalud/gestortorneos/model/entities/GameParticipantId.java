package com.albertsalud.gestortorneos.model.entities;

import java.io.Serializable;

public class GameParticipantId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long game;
	private long participant;

	public long getGame() {
		return game;
	}

	public void setGame(long game) {
		this.game = game;
	}

	public long getParticipant() {
		return participant;
	}

	public void setParticipant(long participant) {
		this.participant = participant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (game ^ (game >>> 32));
		result = prime * result + (int) (participant ^ (participant >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameParticipantId other = (GameParticipantId) obj;
		if (game != other.game)
			return false;
		if (participant != other.participant)
			return false;
		return true;
	}

}
