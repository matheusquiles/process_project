package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.VaraDAO;
import com.projeto.processos.model.Vara;

@Repository
public class VaraDAOImpl extends BaseDAOImpl<Vara, Integer> implements VaraDAO {
	

	@Autowired
	public VaraDAOImpl() {
		super(Vara.class);
	}
	
    @Override
    public Optional<Vara> getByDescription(String vara) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Vara v WHERE LOWER(v.vara) = LOWER(:vara)";
        Vara v = currentSession.createQuery(hql, Vara.class)
                .setParameter("vara", vara)
                .uniqueResult();
        return Optional.ofNullable(v);
    }

}
