package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.Escritorio;

public interface EscritorioDAO extends BaseDAO<Escritorio, Integer>{
	Optional<Escritorio> getByDescription(String escritorio); 
	

}
