package com.albertsalud.spring.videoclub.dao;

import java.util.Collection;

import com.albertsalud.spring.videoclub.model.Film;

public interface FilmDao {
	
	public Film filmById(long id);
	public Collection<Film> findAll();
	public void insert(Film film);
	public void edit(Film film);
	public void delete(Film film);

}
