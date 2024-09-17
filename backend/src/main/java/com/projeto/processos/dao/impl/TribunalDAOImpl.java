package com.projeto.processos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.TribunalDAO;
import com.projeto.processos.model.Tribunal;

import jakarta.persistence.EntityManager;

@Repository
public class TribunalDAOImpl implements TribunalDAO {

	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Tribunal> getAll() {
		Session currentSession = entityManager.unwrap(Session.class); 
		
		Query<Tribunal> list =  currentSession.createQuery("from Tribunal", Tribunal.class);
		
		return list.getResultList();
	}

	@Override
	public Tribunal get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Tribunal.class, id);
	}

	@Override
	public void save(Tribunal tribunal) {
		Session currentSession = entityManager.unwrap(Session.class); 
		currentSession.merge(tribunal);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Tribunal t = currentSession.get(Tribunal.class, id);
		currentSession.remove(t);
	}

	@Override
	public Tribunal getByDescription(String tribunal) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String hql = "FROM Tribunal t WHERE LOWER(t.tribunalOrigem) = LOWER(:tribunal)";
	    return currentSession.createQuery(hql, Tribunal.class)
	                         .setParameter("tribunal", tribunal)
	                         .uniqueResult();

	}

}
