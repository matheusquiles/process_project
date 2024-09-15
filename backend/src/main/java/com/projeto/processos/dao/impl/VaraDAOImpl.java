package com.projeto.processos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.VaraDAO;
import com.projeto.processos.model.Escritorio;
import com.projeto.processos.model.Vara;

import jakarta.persistence.EntityManager;

@Repository
public class VaraDAOImpl implements VaraDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Vara> getAll() {
		Session currentSession = entityManager.unwrap(Session.class); 
		Query<Vara> list =  currentSession.createQuery("from Vara", Vara.class);
		
		return list.getResultList();
	}

	@Override
	public Vara get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Vara.class, id);
	}

	@Override
	public void save(Vara vara) {
		Session currentSession = entityManager.unwrap(Session.class); 
		currentSession.merge(vara);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Vara v = currentSession.get(Vara.class, id);
		currentSession.remove(v);

	}

	@Override
	public Vara getByDescription(String vara) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		String hql = "FROM Vara v WHERE LOWER(v.vara) = LOWER(:vara)";
	    return currentSession.createQuery(hql, Vara.class)
	                         .setParameter("vara", vara)
	                         .uniqueResult();

	}

}
