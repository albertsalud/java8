package com.albertsalud.spring.videoclub.services;

import java.util.Collection;

import com.albertsalud.spring.videoclub.model.Film;

public interface FilmQueryService {
	
	public Collection<Film> exec();
	public FilmQueryService anyGenre(String... genre);
	public FilmQueryService allGenre(String... genre);
	public FilmQueryService year(String year);
	public FilmQueryService betweenYears(String from, String to);
	public FilmQueryService titleContains(String title);

}
