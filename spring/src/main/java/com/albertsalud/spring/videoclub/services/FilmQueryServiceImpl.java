package com.albertsalud.spring.videoclub.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.spring.videoclub.dao.FilmDao;
import com.albertsalud.spring.videoclub.model.Film;

@Service
class FilmQueryServiceImpl implements FilmQueryService{
	
	@Autowired
	private FilmDao filmDao;

	private Predicate<Film> predicate;
	
	@PostConstruct
	public void init() {
		predicate = null;
	}
	
	@Override
	public Collection<Film> exec() {
		return filmDao.findAll().stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}

	@Override
	public FilmQueryService anyGenre(String... genre) {
		Predicate<Film> anyGenere = (film -> Arrays.stream(genre).anyMatch(film.getGenres()::contains));
		predicate = predicate == null ? anyGenere : predicate.and(anyGenere);
		
		return this;
	}

	@Override
	public FilmQueryService allGenre(String... genre) {
		Predicate<Film> allGenere = (film -> Arrays.stream(genre).allMatch(film.getGenres()::contains));
		predicate = predicate == null ? allGenere : predicate.and(allGenere);
		
		return this;
	}

	@Override
	public FilmQueryService year(String year) {
		Predicate<Film> yearPredicate = (film -> film.getYear().equals(year));
		predicate = predicate == null ? yearPredicate : predicate.and(yearPredicate);
		
		return this;
	}

	@Override
	public FilmQueryService betweenYears(String from, String to) {
		Predicate<Film> betweenPredicate = (film -> {
			LocalDate formYear = LocalDate.of(Integer.parseInt(from), 1, 1);
			LocalDate toYear = LocalDate.of(Integer.parseInt(to), 1, 30);
			LocalDate filmYear = LocalDate.of(Integer.parseInt(film.getYear()), 1, 15);
			
			return filmYear.isAfter(formYear) && filmYear.isBefore(toYear);
		});
		
		predicate = predicate == null ? betweenPredicate : predicate.and(betweenPredicate);
		return this;
	}

	@Override
	public FilmQueryService titleContains(String title) {
		Predicate<Film> titlePredicate = (film -> film.getTitle().toLowerCase().contains(title.toLowerCase()));
		predicate = predicate == null ? titlePredicate : predicate.and(titlePredicate);
		
		return this;
	}

}
