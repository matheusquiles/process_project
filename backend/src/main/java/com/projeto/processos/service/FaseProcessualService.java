package com.projeto.processos.service;

import java.util.List;

import com.projeto.processos.model.FaseProcessual;

public interface FaseProcessualService {
	
	List<FaseProcessual> getAll();
	
	FaseProcessual get(int id);
	
	void save(FaseProcessual vara);
	
	void delete(int id);
	
	Boolean getByDescription(String vara);

}
