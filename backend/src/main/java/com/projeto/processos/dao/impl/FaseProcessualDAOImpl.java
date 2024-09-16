package com.projeto.processos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.FaseProcessualDAO;
import com.projeto.processos.model.FaseProcessual;

import jakarta.persistence.EntityManager;

@Repository
public class FaseProcessualDAOImpl implements FaseProcessualDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<FaseProcessual> getAll() {
		Session currentSession = entityManager.unwrap(Session.class); 
		Query<FaseProcessual> list =  currentSession.createQuery("from FaseProcessual", FaseProcessual.class);
		
		return list.getResultList();
	}

	@Override
	public FaseProcessual get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(FaseProcessual.class, id);
	}

	@Override
	public void save(FaseProcessual fase) {
		Session currentSession = entityManager.unwrap(Session.class); 
		currentSession.merge(fase);

	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		FaseProcessual f = currentSession.get(FaseProcessual.class, id);
		currentSession.remove(f);

	}

	@Override
	public FaseProcessual getByDescription(String fase) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String hql = "FROM FaseProcessual f WHERE LOWER(f.faseProcessual) = LOWER(:fase)";
	    return currentSession.createQuery(hql, FaseProcessual.class)
	                         .setParameter("fase", fase)
	                         .uniqueResult();

	}

}
