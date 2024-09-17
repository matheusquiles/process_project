package com.projeto.processos.service;

import java.util.List;

import com.projeto.processos.model.Tribunal;

public interface TribunalService {
	
	List<Tribunal> getAll();
	
	Tribunal get(int id);
	
	void delete(int id);
	
	void save(Tribunal tribunal);
	
	Boolean getByDescription(String tribunal);

}
