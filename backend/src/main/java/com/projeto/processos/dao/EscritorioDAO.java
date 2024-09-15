package com.projeto.processos.dao;

import java.util.List;

import com.projeto.processos.model.Escritorio;

public interface EscritorioDAO {
	
	List<Escritorio> getAll();
	
	Escritorio get(int id);
	
	void save(Escritorio user);
	
	void delete(int id);
	
	Escritorio getByDescription(String escritorio);

}
