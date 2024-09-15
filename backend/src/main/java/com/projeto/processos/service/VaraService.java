package com.projeto.processos.service;

import java.util.List;

import com.projeto.processos.model.Vara;

public interface VaraService {
	
	List<Vara> getAll();
	
	Vara get(int id);
	
	void save(Vara vara);
	
	void delete(int id);
	
	Boolean getByDescription(String vara);

}
