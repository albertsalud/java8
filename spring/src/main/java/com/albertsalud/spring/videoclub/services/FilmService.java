package com.albertsalud.spring.videoclub.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.spring.videoclub.dao.FilmDao;

@Service
public class FilmService {
	
	@Autowired
	private FilmDao filmDao;
	
	public Collection<String> findAllGenres(){
		List<String> result = null;
		
		result = filmDao.findAll().stream()
			.map(film -> film.getGenres())
			.flatMap(list -> list.stream())
			.distinct()
			.sorted((genre1, genre2) -> genre2.compareTo(genre1))
			.collect(Collectors.toList());
		
		return result;
	}

}
