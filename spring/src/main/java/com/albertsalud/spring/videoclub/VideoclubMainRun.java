package com.albertsalud.spring.videoclub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.albertsalud.spring.videoclub.services.FilmQueryService;
import com.albertsalud.spring.videoclub.services.FilmService;

@Component
public class VideoclubMainRun {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private FilmQueryService filmQueryService;
	
	public void run() {
		
		filmService.findAllGenres().forEach(System.out::println);
		
		filmQueryService.betweenYears("1975", "1982")
			.anyGenre("Mystery", "Drama")
			.exec().forEach(System.out::println);
		
	}

}
