package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.NaturezaDAO;
import com.projeto.processos.model.Natureza;

@Repository
public class NaturezaDAOImpl extends BaseDAOImpl<Natureza, Integer> implements NaturezaDAO {


    @Autowired
    public NaturezaDAOImpl() {
        super(Natureza.class);
    }

	@Override
	public Optional<Natureza> getByDescription(String description) {
		Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Natureza n WHERE LOWER(n.natureza) = LOWER(:natureza)";
        Natureza n = currentSession.createQuery(hql, Natureza.class)
                .setParameter("natureza", description)
                .uniqueResult();
        return Optional.ofNullable(n);
	}
	
}
