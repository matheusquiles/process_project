package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.Funcao;

public interface FuncaoDAO extends BaseDAO<Funcao, Integer>{
	Optional<Funcao> getByDescription(String natureza);

}
