package com.projeto.processos.service;

import java.util.List;

import com.projeto.processos.model.Escritorio;

public interface EscritorioService {
	
	List<Escritorio> getAll();
	
	Escritorio get(int id);
	
	void delete(int id);
	
	void save(Escritorio escritorio);
	
	Boolean getByDescription(String escritorio);

}
