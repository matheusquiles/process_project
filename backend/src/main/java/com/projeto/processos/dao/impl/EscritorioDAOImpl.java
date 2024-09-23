package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.EscritorioDAO;
import com.projeto.processos.model.Escritorio;

@Repository
public class EscritorioDAOImpl extends BaseDAOImpl<Escritorio, Integer> implements EscritorioDAO{


	public EscritorioDAOImpl() {
        super(Escritorio.class);
    }

	 @Override
	    public Optional<Escritorio> getByDescription(String escritorio) {
	        Session currentSession = entityManager.unwrap(Session.class);
	        String hql = "FROM Escritorio e WHERE LOWER(e.nomeEscritorio) = LOWER(:escritorio)";
	        Escritorio e = currentSession.createQuery(hql, Escritorio.class)
	                .setParameter("escritorio", escritorio)
	                .uniqueResult();
	        return Optional.ofNullable(e);
	    }

}
