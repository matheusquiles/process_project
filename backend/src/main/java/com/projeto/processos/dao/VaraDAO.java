package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.Vara;

public interface VaraDAO extends BaseDAO<Vara, Integer>{
	Optional<Vara> getByDescription(String vara);
	
}
