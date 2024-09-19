package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.Processo;

public interface ProcessoDAO extends BaseDAO<Processo, Integer> {
	Optional<Processo> getByDescription(String processo);

}
