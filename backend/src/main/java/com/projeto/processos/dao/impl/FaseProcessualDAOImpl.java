package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.FaseProcessualDAO;
import com.projeto.processos.model.FaseProcessual;

@Repository
public class FaseProcessualDAOImpl extends BaseDAOImpl<FaseProcessual, Integer> implements FaseProcessualDAO {


	@Autowired
	public FaseProcessualDAOImpl() {
		super(FaseProcessual.class);
	}

	@Override
	public Optional<FaseProcessual> getByDescription(String description) {
		Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM FaseProcessual f WHERE LOWER(f.faseProcessual) = LOWER(:fase)";
        FaseProcessual f = currentSession.createQuery(hql, FaseProcessual.class)
                .setParameter("fase", description)
                .uniqueResult();
        return Optional.ofNullable(f);
	}

}
