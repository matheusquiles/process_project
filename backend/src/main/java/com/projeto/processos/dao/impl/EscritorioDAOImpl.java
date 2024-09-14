package com.projeto.processos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.EscritorioDAO;
import com.projeto.processos.model.Escritorio;

import jakarta.persistence.EntityManager;

@Repository
public class EscritorioDAOImpl implements EscritorioDAO{

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Escritorio> getAll() {
		Session currentSession = entityManager.unwrap(Session.class); 
		
		Query<Escritorio> list =  currentSession.createQuery("from Escritorio", Escritorio.class);
		
		return list.getResultList();
	}

	@Override
	public Escritorio get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Escritorio.class, id);
	}

	@Override
	public void save(Escritorio escritorio) {
		Session currentSession = entityManager.unwrap(Session.class); 
		currentSession.merge(escritorio);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
