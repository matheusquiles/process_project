package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.Natureza;

public interface NaturezaDAO extends BaseDAO<Natureza, Integer> {
	Optional<Natureza> getByDescription(String natureza);
}
