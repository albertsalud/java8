package com.albertsalud.gestortorneos.model.builders;

public class RoundBuilderDirector {

	private RoundBuilder roundBuilder;
	
	public RoundBuilderDirector(RoundBuilder roundBuilder) {
		this.roundBuilder = roundBuilder;
	}
	
	public void createRound() {
		roundBuilder.createRound();
		roundBuilder.createGames();
	}
}
