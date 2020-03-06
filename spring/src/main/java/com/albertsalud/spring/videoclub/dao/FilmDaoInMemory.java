package com.albertsalud.spring.videoclub.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.albertsalud.spring.videoclub.helper.CSVFileReader;
import com.albertsalud.spring.videoclub.model.Film;

@Repository
class FilmDaoInMemory implements FilmDao{
	
	private final int NOT_FOUND = -1;
	
	@Autowired
	private CSVFileReader csvFileReader;
	
	private List<Film> peliculas = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		peliculas = csvFileReader.readFile();
	}

	public Film filmById(long id) {
		Optional<Film> result = peliculas.stream()
			.filter(f -> f.getId() == id)
			.findFirst();
		return result.orElse(null);
	}

	public Collection<Film> findAll() {
		return peliculas;
	}

	public void insert(Film film) {
		peliculas.add(film);
		
	}

	public void edit(Film film) {
		
		int listIndex = this.getListIndex(film.getId());
		
		if(listIndex != NOT_FOUND)
			peliculas.set(listIndex, film);
		
	}

	public void delete(Film film) {
		int listIndex = this.getListIndex(film.getId());
		
		if(listIndex != NOT_FOUND)
			peliculas.remove(listIndex);
		
	}
	
	private int getListIndex(long filmId) {
		for(int index = 0; index < peliculas.size(); index++) {
			if(peliculas.get(index).getId() == filmId) return index;
		}
		
		return NOT_FOUND;
	}
	
}
