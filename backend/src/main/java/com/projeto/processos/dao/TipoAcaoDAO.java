package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.TipoAcao;

public interface TipoAcaoDAO extends BaseDAO<TipoAcao, Integer>{
	Optional<TipoAcao> getByDescription(String natureza);
	
}
