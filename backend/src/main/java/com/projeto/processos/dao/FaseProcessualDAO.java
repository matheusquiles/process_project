package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.FaseProcessual;


public interface FaseProcessualDAO extends BaseDAO<FaseProcessual, Integer>{
	
	Optional<FaseProcessual> getByDescription(String fase);

}
