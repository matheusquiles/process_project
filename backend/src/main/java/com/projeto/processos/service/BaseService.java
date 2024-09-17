package com.projeto.processos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


public interface BaseService<T, ID> {
	
	@Transactional
	List<T> findAll();

	@Transactional
	Optional<T> findById(ID id);

	@Transactional
	void save(T entity);

	@Transactional
	void deleteById(ID id);

	@Transactional
	T update(T entity);
	
	@Transactional
	Boolean findByDescription(String s);

}
