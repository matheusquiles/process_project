package com.projeto.processos.dao;

import java.util.List;

import com.projeto.processos.model.FaseProcessual;

public interface FaseProcessualDAO {
	
	List<FaseProcessual> getAll();
	
	FaseProcessual get(int id);
	
	void save(FaseProcessual user);
	
	void delete(int id);
	
	FaseProcessual getByDescription(String fase);

}
