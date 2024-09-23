package com.projeto.processos.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.ProcessoDAO;
import com.projeto.processos.model.Processo;

import jakarta.persistence.EntityManager;

@Repository
public class ProcessoDAOImpl extends BaseDAOImpl<Processo, Integer> implements ProcessoDAO {

	@Autowired
	public ProcessoDAOImpl() {
		super(Processo.class);
	}
	
	@Override
	public void save(Processo entity) {
	    Session session = entityManager.unwrap(Session.class);
        ((EntityManager) session).merge(entity);
	}
	
	
	
	
	
	
}
