package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.ClassificacaoRisco;

public interface ClassificacaoRiscoDAO extends BaseDAO<ClassificacaoRisco, Integer> {
	Optional<ClassificacaoRisco> getByDescription(String natureza);
	

}
