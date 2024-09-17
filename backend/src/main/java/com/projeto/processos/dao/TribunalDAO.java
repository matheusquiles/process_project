package com.projeto.processos.dao;

import java.util.List;

import com.projeto.processos.model.Tribunal;

public interface TribunalDAO {
	
	List<Tribunal> getAll();
	
	Tribunal get(int id);
	
	void save(Tribunal tribunal);
	
	void delete(int id);
	
	Tribunal getByDescription(String tribunal);

}
