package com.albertsalud.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {
	
	@Autowired
	protected R repository;
	
	public void delete(T entity) {
		repository.delete(entity);
	}

	public void deleteById(ID id) {
		repository.deleteById(id);
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}
	
	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}
	
	public T save(T entity) {
		return repository.save(entity);
	}
	
}
