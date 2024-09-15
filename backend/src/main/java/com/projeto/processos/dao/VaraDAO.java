package com.projeto.processos.dao;

import java.util.List;

import com.projeto.processos.model.Vara;

public interface VaraDAO {
	
	List<Vara> getAll();
	
	Vara get(int id);
	
	void save(Vara vara);
	
	void delete(int id);

	Vara getByDescription(String vara);
	
}
