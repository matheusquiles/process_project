package com.projeto.processos.dao;

import java.util.Optional;

import com.projeto.processos.model.Tribunal;

public interface TribunalDAO extends GenericDAO<Tribunal, Integer> {
    Optional<Tribunal> getByDescription(String tribunalOrigem);
}