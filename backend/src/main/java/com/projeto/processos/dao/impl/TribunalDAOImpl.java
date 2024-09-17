package com.projeto.processos.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.projeto.processos.dao.BaseDAOImpl;
import com.projeto.processos.dao.TribunalDAO;
import com.projeto.processos.model.Tribunal;


@Repository
public class TribunalDAOImpl extends BaseDAOImpl<Tribunal, Integer> implements TribunalDAO{
    
	
	public TribunalDAOImpl() {
        super(Tribunal.class);
    }

    @Override
    public Optional<Tribunal> getByDescription(String tribunalOrigem) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Tribunal t WHERE LOWER(t.tribunalOrigem) = LOWER(:tribunalOrigem)";
        Tribunal t = currentSession.createQuery(hql, Tribunal.class)
                .setParameter("tribunalOrigem", tribunalOrigem)
                .uniqueResult();
        return Optional.ofNullable(t);
    }

}